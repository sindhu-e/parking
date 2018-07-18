package datareader;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.Reader;
import java.lang.reflect.Method;
import java.lang.ArrayIndexOutOfBoundsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import com.opencsv.CSVReader;


import customannotations.CsvFileParameters;

/**
 * @author sindhuja edupuganti
 * This class is used to read data from .CSV files. This class uses third party
 * library called openCSV to parse the CSV input files
 */
public class CsvReader {
	
	private static Logger logger = LogManager.getFormatterLogger("CsvReader");;
	
	@DataProvider()
	public Iterator<Object[]> getTestData(final Method testMethod) throws IOException {	
		    
		//Read the CSV parameters
		CsvFileParameters parameters = testMethod.getAnnotation(CsvFileParameters.class);
		Collection<Object[]> dataList = new ArrayList<>(); 
	    
		if (parameters != null) {
	        String filepath = parameters.path();	        
	    			
			logger.debug(filepath);;
		    try (
		            Reader reader = Files.newBufferedReader(Paths.get(filepath));
		            CSVReader csvReader = new CSVReader(reader);
		        ) {
		    	
		    	String[] record;
	
		    	while ((record = csvReader.readNext()) != null) {
		    		ParkingData data = new ParkingData();
		    		try {
			    		data.setLot(record[0]);
			    		data.setEntryTime(record[1]);
			    		data.setEntryTimeAMPM(record[2]);
			    		data.setEntryDate(record[3]);
			    		data.setExitTime(record[4]);
			    		data.setExitTimeAMPM(record[5]);
			    		data.setExitDate(record[6]);
			    		data.setCost(record[7]);
		    		} catch(ArrayIndexOutOfBoundsException e) {
		    			logger.warn("Insufficient CSV data provided. Check the record %s", Arrays.toString(record));
		    			continue;
		    		}
	
		    		Object obj[] = new Object[1];
		    		obj[0] = data;
		    		dataList.add(obj);
		    	}
		    }		
		} else {
	        throw new RuntimeException("Couldn't find the annotation");	        
	    }
		return dataList.iterator();
	}
}

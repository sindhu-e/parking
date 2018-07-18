package calculatorTests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;

import datareader.ParkingData;
import datareader.CsvReader;
import pages.ParkingCalculator;
import customannotations.CsvFileParameters;


public class LongTerm extends TestSuiteParent {
	
	private Logger logger;
	
	@BeforeClass
	public void beforeClass() {				    
	    logger  = LogManager.getFormatterLogger("LongTerm");
	}
	
	
	@Test(dataProvider="getTestData",  dataProviderClass = CsvReader.class)
	//Input data file for Long term tests
	@CsvFileParameters(path = "src/main/resources/longterm.csv")
	public void runTestCase(ParkingData data) {
		
		logger.info("Start Running Long term test");
		ParkingCalculator calculator = new ParkingCalculator(driver);		
    	calculator.chooseLotType(data.getLot());
		calculator.chooseEntryDate(data.getEntryDate());
		calculator.chooseEntryTime(data.getEntryTime());
		if (data.getEntryTimeAMPM().equals("AM")) {
			calculator.chooseEntryTimeAM();
		}
		else if (data.getEntryTimeAMPM().equals("PM")) {
			calculator.chooseEntryTimePM();
		}
		else {
			logger.error("%s invalid option provided. Only AM and PM is supported", data.getEntryTimeAMPM());
		}
		calculator.chooseExitDate(data.getExitDate());
		calculator.chooseExitTime(data.getExitTime());
		if (data.getExitTimeAMPM().equals("AM")) {
			calculator.chooseExitTimeAM();
		}
		else if (data.getExitTimeAMPM().equals("PM")) {
			calculator.chooseExitTimePM();
		}
		else {
			logger.error("%s invalid option provided. Only AM and PM is supported. Default value is used", data.getExitTimeAMPM());
		}
		calculator.clickSubmitButton();
		logger.debug("Actual cost is :%s and Expected cost is :%s", calculator.getCost(), data.getCost());
		Assert.assertEquals(calculator.getCost(), data.getCost());
	}
	
}


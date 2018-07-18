package datareader;

/**
 * @author sindhuja edupuganti
 * This class represents the input data model provided to the tests
 * Test data can be read from any type of input format files(currently CSV is used)
 * to the objects of this class. This class acts as an abstraction layer between the
 * input data and tests. 
 */
public class ParkingData {
	/* Read data from input file into objects of ParkingData class
	 * This class mostly contains getters and setters
	 */
	private String lot;
	private String entryTime;
	private String entryTimeAMPM;
	private String entryDate;
	private String exitTime;
	private String exitTimeAMPM;
	private String exitDate;
	private String cost;
    private String duration;
    
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String getEntryTimeAMPM() {
		return entryTimeAMPM;
	}
	public void setEntryTimeAMPM(String entryTimeAMPM) {
		this.entryTimeAMPM = entryTimeAMPM;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getExitTime() {
		return exitTime;
	}
	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}
	public String getExitTimeAMPM() {
		return exitTimeAMPM;
	}
	public void setExitTimeAMPM(String exitTimeAMPM) {
		this.exitTimeAMPM = exitTimeAMPM;
	}
	public String getExitDate() {
		return exitDate;
	}
	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}   
    
}

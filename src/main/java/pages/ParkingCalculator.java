package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


/**
 * @author sindhuja edupuganti
 * This class represents the page model of calculator page.
 * It has functions to access all the webelements in calculator page
 */
public class ParkingCalculator extends PageObject{
	WebDriver driver;
	 
	public ParkingCalculator(WebDriver driver){ 
		super(driver); 
	}

	//Using FindBy for locating elements
	@FindBy(id="Lot") 
	private WebElement lotType;
	
	@FindBy(id="EntryDate")
	private WebElement entryDate;
	
	@FindBy(id="EntryTime") 
	private WebElement entryTime;
	
	@FindBy(xpath="//*[@name='EntryTimeAMPM' and @value='AM'] ")
	private WebElement entryTimeAM;
	
	@FindBy(xpath="//*[@name='EntryTimeAMPM' and @value='PM'] ")
	private WebElement entryTimePM;
	 
	@FindBy(id="ExitDate")  
	private WebElement exitDate;
	
	@FindBy(id="ExitTime")  
	private WebElement exitTime;
	
	@FindBy(xpath="//*[@name='ExitTimeAMPM' and @value='AM'] ")
	private WebElement exitTimeAM;
	
	@FindBy(xpath="//*[@name='ExitTimeAMPM' and @value='PM'] ")
	private WebElement exitTimePM;
	
	@FindBy(name="Submit") 
	private WebElement submit;
	
	@FindBy(xpath="//*[@class='SubHead']//b")
	private WebElement cost;
	
	@FindBy(xpath="//*[@class='BodyCopy']//b")
	private WebElement duration;
	     
	// Defining all the user actions (Methods) that can be performed in the parking calculator page
		 
	/**
	 * This method is used to choose a lot type
	 * @param type Lot type. This should match the exact text provided in the parking type drop down menu
	 */
	public void chooseLotType(String type){
		
		Select dropdown= new Select(lotType);
		dropdown.selectByVisibleText(type);
	}
	
	/**
	 * This method is used to choose the Entry Time
	 * @param time Time has to be in string format. Ex: 10:00
	 */
	public void chooseEntryTime(String time){
		entryTime.clear();
		entryTime.sendKeys(time);
	}
	
	/**
	 * This method is used to send the Entry Date
	 * @param date Date has to be in string format. Ex: 05/01/2018
	 */
	public void chooseEntryDate(String date){
		entryDate.clear();
		entryDate.sendKeys(date);
	}	
	
	/**
	 * This method is used to chose AM radio button for the entry time
	 */
	public void chooseEntryTimeAM(){		
		entryTimeAM.click();
	}
	
	/**
	 * This method is used to chose PM radio button for the entry time
	 */
	public void chooseEntryTimePM(){		
		entryTimePM.click();
	}
	
	/**
	 * This method is used to choose the Exit Time
	 * @param time Time has to be in string format. Ex: 10:00
	 */
	public void chooseExitTime(String time){
		exitTime.clear();
		exitTime.sendKeys(time);
	}
	
	/**
	 * This method is used to send the Exit Date
	 * @param date Date has to be in string format. Ex: 05/03/2018
	 */
	public void chooseExitDate(String date){
		exitDate.clear();
		exitDate.sendKeys(date);
	}
	
	/**
	 * This method is used to chose AM radio button for the exit time
	 */
	public void chooseExitTimeAM(){		
		exitTimeAM.click();
	}
	
	/**
	 * This method is used to chose PM radio button for the exit time
	 */
	public void chooseExitTimePM(){		
		exitTimePM.click();
	}
	
	
	/**
	 * This method is used to click the submit button
	 */
	public void clickSubmitButton(){
		submit.click();
	}
	
	/**
	 * This method returns the total cost after clicking submit button
	 * @return Return the total cost generated from the parking calculator. Ex:$ 40
	 *         or an error based on the input values
	 */
	public String getCost() {
		return cost.getText();
	}
	
	/**
	 * This method returns total duration for parking 
	 * @return Return the total duration for parking in following format (1 Days, 0 Hours, 0 Minutes)
	 */
	public String getduration() {
		return duration.getText();
	}
}

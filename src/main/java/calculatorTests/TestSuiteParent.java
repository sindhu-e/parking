package calculatorTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * @author sindhuja edupuganti
 * This is the base class for all the classes in the suite. 
 * It will initialize the chrome driver at the start of test suite and 
 * quit the chrome driver at end of the test suite.
 * For each test method, a new instance of browser is opened at the start and 
 * closed at the end of the test method
 */
public class TestSuiteParent {
	 public WebDriver driver = null;
	  
	  @BeforeSuite
	  public void beforeSuite() {			  		  
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\rppendya\\Downloads\\chromedriver_win32\\chromedriver.exe");		
	  }
	  
	  @BeforeMethod
	  public void initPage() {		
		  driver = new ChromeDriver();	
		  driver.get("http://adam.goucher.ca/parkcalc/");
	  }
	  
	  @AfterMethod
	  public void cleanUp(){
		  if (driver != null) {
			  driver.manage().deleteAllCookies();
			  driver.quit();
		  }	
	  }
	  
}

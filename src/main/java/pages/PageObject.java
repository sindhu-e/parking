package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * @author sindhuja edupuganti
 * This class has pagefactory initializing the webelements in a page.
 * All the classes that are implementing page objects will be subclasses of this class
 */
public class PageObject {
	
	protected WebDriver driver;
	
	public PageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}

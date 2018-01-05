package bjss.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Menu {
	WebDriver driver;
	ExtentTest test;
	static Logger log = LogManager.getLogger(Menu.class);
	
	public Menu(WebDriver driverIn,ExtentTest testIn){
		driver = driverIn;
		PageFactory.initElements(driver, this);
		test = testIn;
	}
	
	public HeaderMenu headerMenu(){
		HeaderMenu hMenu = new HeaderMenu(driver,test);
		return hMenu;
	}
}

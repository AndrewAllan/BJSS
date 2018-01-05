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
	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement MnuSignOut;
	
	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[1]/a")
	WebElement MnuWoman;
	
	//clicks the signout button in the menu
	public void clickSignOut(){
		MnuSignOut.click();
		test.log(LogStatus.PASS, "click signout from menu");
		log.info("User Menu - the sign out menu opption has been clicked");	
	}
	
	//clicks the woman menu option
	public void clickMenuOptionWoman(){
		MnuWoman.click();
	}
}

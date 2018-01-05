package bjss.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyAccount {
	WebDriver driver;
	ExtentTest test;
	static Logger log = LogManager.getLogger(Menu.class);
	
	public MyAccount(WebDriver driverIn,ExtentTest testIn){
		driver = driverIn;
		PageFactory.initElements(driver, this);
		test = testIn;
	}
	
	@FindBy(xpath=".//*[@id='center_column']/div/div[1]/ul/li[1]/a/span")
	WebElement orderHistory;
	
	public void clickOrderHistory(){
		orderHistory.click();
		test.log(LogStatus.PASS, "click order history");
		log.info("the order history button was clicked");
	}
}

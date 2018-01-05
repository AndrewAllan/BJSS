package bjss.test.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Address {
	WebDriver driver;
	ExtentTest test;
	
	static Logger log = LogManager.getLogger(Address.class);
	
	public Address(WebDriver driverIn,ExtentTest testIn){
		driver = driverIn;
		PageFactory.initElements(driver, this);
		test = testIn;
	}
	
	@FindBy(name = "processAddress")
	WebElement BtnProccedToCheckOut;
	
	public void clickProccedToCheckout(){
		BtnProccedToCheckOut.click();
		test.log(LogStatus.PASS, "click procced to checkout");
		log.info("Address - Procced to check out button pressed");
	}

}

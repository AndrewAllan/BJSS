package bjss.test.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Shipping {
	WebDriver driver;
	static Logger log = LogManager.getLogger(Shipping.class);
	ExtentTest test;
	
	public Shipping(WebDriver driverIn,ExtentTest testIn){
		driver = driverIn;
		PageFactory.initElements(driverIn, this);
		test = testIn;
	}
	
	@FindBy(id ="cgv")
	WebElement CkBoxTandC;
	
	@FindBy(name = "processCarrier")
	WebElement BtnProccedToCheckOut;
	
	//checks the terms and conditions check box
	public void clickTandC(){
		CkBoxTandC.click();
		test.log(LogStatus.PASS, "check the check box for terms and conditions");
		log.info("Shipping - the terms and conditions check box has been clicked");
	}
	
	//clicks the proceed to checkout
	public void clickProccedToCheckout(){
		BtnProccedToCheckOut.click();
		test.log(LogStatus.PASS, "click the procced to checkout");
		log.info("Shipping - the procced to checkout button has been clicked");
	}
}

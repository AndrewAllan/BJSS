package bjss.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Payment {
	WebDriver driver;
	static Logger log = LogManager.getLogger(Payment.class);
	ExtentTest test;
	
	public Payment(WebDriver driverIn,ExtentTest testIn){
		driver = driverIn;
		PageFactory.initElements(driver, this);
		test = testIn;
	}
	
	@FindBy(xpath = ".//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
	WebElement BtnPayByBankWire;
	
	@FindBy(xpath = ".//*[@id='cart_navigation']/button")
	WebElement BtnConfirmOrder;
	
	public void clickPayByWire(){
		BtnPayByBankWire.click();
		test.log(LogStatus.PASS, "click the pay by wire option");
		log.info("Payment - the pay by wire option has been clicked");	
	}
	
	public void clickConfirmOrder(){
		BtnConfirmOrder.click();
		test.log(LogStatus.PASS, "click the confirm order button");
		log.info("Payment - the confirm order button has been clicked");
	}
	
}

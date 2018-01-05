package bjss.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Woman {
	WebDriver driver;
	ExtentTest test;
	
	static Logger log = LogManager.getLogger(Woman.class);
	
	public Woman(WebDriver driverIn,ExtentTest testIn){
		driver = driverIn;
		test = testIn;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ".//*[@id='center_column']/ul/li[1]/div/div[1]/div")
	WebElement Item1;
	
	@FindBy(xpath = ".//*[@id='center_column']/ul/li[2]/div/div[1]/div")
	WebElement Item2;
	
	//clicks the item 1 quick view
	public void clickItem1(){
		Item1.click();
		driver.switchTo().frame(0);	
		log.info("Womans Clothing -- item 1 quick view was clicked");
		test.log(LogStatus.PASS, "the quick view for item 1 was clicked");
	}
	
	//clicks the item 2 quick view
	public void clickItem2(){
		Item2.click();
		driver.switchTo().frame(0);	
		log.info("Womans Clothing -- item 2 quick view was clicked");
		test.log(LogStatus.PASS, "the quick view for item 2 was clicked");
	}
	
	//returns an instance of the quick view class
	public ItemQuickView itemQuickView(){
		ItemQuickView itemQuickView = new ItemQuickView(driver,test);
		return itemQuickView;	
	}
	
}

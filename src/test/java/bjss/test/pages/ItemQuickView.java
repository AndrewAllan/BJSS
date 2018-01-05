package bjss.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ItemQuickView {
	WebDriver driver;
	static Logger log = LogManager.getLogger(ItemQuickView.class);
	ExtentTest test;
	
	public ItemQuickView(WebDriver driverIn,ExtentTest testIn){
		driver = driverIn;
		PageFactory.initElements(driver, this);
		test = testIn;
	}
	
	@FindBy(id = "group_1")
	WebElement drpSize;
	
	@FindBy (id =  "add_to_cart")
	WebElement BtnAddToCart;
	
	@FindBy (xpath =  ".//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
	WebElement BtnContinueShopping;
	
	@FindBy(xpath = ".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	WebElement BtnCheckout;
	
	//selects the item size from dropdown
	public void selectSize(String sizeIn){
		Select dropDownList = new Select(drpSize);		
		dropDownList.selectByVisibleText(sizeIn);	
		test.log(LogStatus.PASS, "change quick view item size");
		log.info("Quick view - size" +" "+ sizeIn +" "+ "has been selected from size dropdown");
	}
	
	//clicks the add to cart
	public void addToCart(){
		BtnAddToCart.click();
		driver.switchTo().parentFrame();
		test.log(LogStatus.PASS, "click add to cart");
		log.info("Quick view - the add to cart button has been pressed");
	}
	
	//clicks the continue shopping button 
	public void continueShopping(){
		BtnContinueShopping.click();
		test.log(LogStatus.PASS, "click continue shopping");
		log.info("Quick view - the continue shopping button has been pressed");
	}
	
	//clicks the checkout button
	public void checkout(){
		BtnCheckout.click();
		test.log(LogStatus.PASS, "click checkout");
		log.info("Quick view - the checkout button has been pressed");
	}

}

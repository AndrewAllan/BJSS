package bjss.test.pages;

import java.text.DecimalFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Summary {
	WebDriver driver;
	DecimalFormat df = new DecimalFormat("#.##");
	static Logger log = LogManager.getLogger(Summary.class);
	ExtentTest test;
	
	public Summary(WebDriver driverIn,ExtentTest testIn){
		driver = driverIn;
		PageFactory.initElements(driver, this);
		test = testIn;
	}
	
	@FindBy(xpath = ".//tr[1]//td[2]//small/a")
	//.//tr[1]//td[2]//small/a
	WebElement item1size;
	
	@FindBy(xpath =".//tr[1]//td[6]/span")
	WebElement item1price;
	
	@FindBy(xpath = ".//tr[2]//td[6]/span")
	WebElement item2price;
	
	@FindBy(xpath = ".//tr[2]//td[2]//small/a")
	WebElement item2size;
	
	@FindBy(id = "total_product")	
	WebElement totalProducts;
	
	@FindBy(id = "total_shipping")
	WebElement totalShipping;
	
	@FindBy(id = "total_price")	
	WebElement totalPrice;
	
	@FindBy(xpath = ".//*[@id='center_column']/p[2]/a[1]/span")
	WebElement BtnProccedToCheckOut;
	
	public void checkItem1Size(String sizeIn){
		Assert.assertEquals(sizeIn, item1size.getText().substring(item1size.getText().length() -1));
		test.log(LogStatus.PASS, "check that item 1 size matches "+" "+sizeIn);
		//log.info("Order Summary - checked that item 1 size matches "+" "+sizeIn);
	}
	
	public void checkItem2Size(String sizeIn){
		Assert.assertEquals(sizeIn, item2size.getText().substring(item2size.getText().length() -1));
		test.log(LogStatus.PASS, "check that item 2 size matches "+" "+sizeIn);
		log.info("Order Summary - checked that item 2 size matches "+" "+sizeIn);
	}
		
	public void checkItem1Price(String priceIn){
		Assert.assertEquals(priceIn, item1price.getText().substring(1, item1price.getText().length()));
		test.log(LogStatus.PASS, "check that item 1 price matches "+" "+priceIn);
		log.info("Order Summary - checked that item 1 price matches "+" "+ priceIn);
	}
	
	public void checkItem2Price(String priceIn){
		Assert.assertEquals(priceIn, item2price.getText().substring(1, item2price.getText().length()));
		test.log(LogStatus.PASS, "check that item 2 price matches "+" "+priceIn);
		log.info("Order Summary - checked that item 2 price matches "+" "+ priceIn);
	}
	
	public double convertToDouble(String priceIn){
		return Double.parseDouble(priceIn.substring(1, priceIn.length()));
	}
	public void checkTotalProductsPrice(){
		double productPrice = convertToDouble(item2price.getText()) + convertToDouble(item1price.getText());
		Assert.assertEquals(totalProducts.getText().substring(1, totalProducts.getText().length()), df.format(productPrice));
		test.log(LogStatus.PASS, "check that the price of all items matches the total products");
		log.info("Order Summary - checked that the price of all items matches the total products");
	}
	
	public void checkFinalTotal(){
		double ProductAndShipping = convertToDouble(totalProducts.getText()) + convertToDouble(totalShipping.getText());
		Assert.assertEquals(totalPrice.getText().substring(1, totalProducts.getText().length()), df.format(ProductAndShipping));
		test.log(LogStatus.PASS, "check that the items plus the shipping matches the final total");
		log.info("Order Summary - checked that the items plus the shipping matches the final total");
	}
	
	public void clickProccedToCheckOut(){
		BtnProccedToCheckOut.click();
		test.log(LogStatus.PASS, "click the procced to checkout button");
		log.info("Order Summary - clicked procced to checkout");
	}
	
}

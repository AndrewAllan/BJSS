package bjss.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class Order {
	WebDriver driver;
	ExtentTest test;
	
	public Order(WebDriver driverIn,ExtentTest testIn)
	{
		driver = driverIn;
		PageFactory.initElements(driver, this);
		test = testIn;
	}
	public Summary summary(){
		Summary summary = new Summary(driver,test);
		return summary;	
	}
	
	public Address address(){
		Address address = new Address(driver,test);
		return address;	
	}
	
	public Shipping shipping(){
		Shipping shipping = new Shipping(driver,test);
		return shipping;
	}
	
	public Payment payment(){
		Payment payment = new Payment(driver,test);
		return payment;
	}
}

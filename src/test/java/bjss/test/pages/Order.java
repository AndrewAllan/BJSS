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
	
	//returns an instance of the summary class
	public Summary summary(){
		Summary summary = new Summary(driver,test);
		return summary;	
	}
	
	//returns an instance of the address class
	public Address address(){
		Address address = new Address(driver,test);
		return address;	
	}
	
	//returns an instance of the shipping class
	public Shipping shipping(){
		Shipping shipping = new Shipping(driver,test);
		return shipping;
	}
	
	//returns an instance of the payment class
	public Payment payment(){
		Payment payment = new Payment(driver,test);
		return payment;
	}
}

package bjss.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class Shopping {
	WebDriver driver;
	ExtentTest test;
	
	public Shopping(WebDriver driverIn,ExtentTest testIn){
		driver = driverIn;
		PageFactory.initElements(driver, this);
		test = testIn;
	}
	
	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[1]/a")
	WebElement MnuWoman;

	public void clickMenuOptionWoman(){
		MnuWoman.click();
	}
	
	public Woman woman(){
		Woman woman = new Woman(driver,test);
		return woman;
	}
}

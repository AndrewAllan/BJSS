package bjss.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Signin {
	WebDriver driver;
	static Logger log = LogManager.getLogger(Signin.class);
	ExtentTest test;
	
	
	public Signin(WebDriver driverIn,ExtentTest testIn){
		driver = driverIn;
		PageFactory.initElements(driver, this);
		test = testIn;
	}
	@FindBy(name = "email")
	public WebElement txtEmail;
	
	@FindBy(name = "passwd")
	public WebElement txtPassword;
	
	@FindBy(name = "SubmitLogin")
	public WebElement btnSignin;
	
	public void signin(String emailIn,String passwordIn){
		txtEmail.sendKeys(emailIn);
		log.info("Signin -- email address"+" "+"was entered");
		txtPassword.sendKeys(passwordIn);
		log.info("Signin -- password"+" "+"was entered");
		btnSignin.click();
		log.info("Signin -- signin button was clicked");
		test.log(LogStatus.PASS, "enter username, password and click sign in");
	}
	
} 

package bjss.test.browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
	
	public static WebDriver setup(){
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver.exe");//setting up the path to the chrome driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();// setting the window to full screen 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// wait for the web page to load
		return driver;
		
	}
}

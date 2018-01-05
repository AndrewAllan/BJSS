package bjss.test.testCase;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Utilities.ExtentFactory;
import Utilities.Screenshots;
import bjss.test.browsers.Chrome;
import bjss.test.pages.MyAccount;
import bjss.test.pages.OrderHistory;
import bjss.test.pages.Signin;

public class TestCase3 {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void before() {
		report = ExtentFactory.getInstance();
		test = report.startTest("Test 3", "to cover the steps from the third test");
		driver = Chrome.setup();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		Signin signin = new Signin(driver, test);
		signin.signin("andy@BJSSTest.com", "BJSSTest");
		// TestAutomation@BJSSTest.com

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test3() throws InterruptedException {
		MyAccount myAccount = new MyAccount(driver,test);
		myAccount.clickOrderHistory();
		Thread.sleep(2000);
		OrderHistory orderHistory = new OrderHistory(driver, test);
		orderHistory.findOrderByDate("12/27/2017");
		orderHistory.checkItemSize("X"); 
	}

	@AfterMethod
	public void tearDown(ITestResult testResults) throws IOException {
		if (testResults.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshots(driver, testResults.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "the test has failed", imagePath);
		}
		report.endTest(test);
		report.flush();
	}
	

	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
	}
}

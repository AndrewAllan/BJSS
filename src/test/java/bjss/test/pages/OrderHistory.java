package bjss.test.pages;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OrderHistory {
	WebDriver driver;
	ExtentTest test;
	static Logger log = LogManager.getLogger(OrderHistory.class);

	public OrderHistory(WebDriver driverIn, ExtentTest testIn) {
		driver = driverIn;
		PageFactory.initElements(driver, this);
		test = testIn;
	}

	@FindBy(xpath = ".//*[@id='order-list']/tbody//td[2]")
	List<WebElement> webElements;

	@FindBy(xpath = ".//*[@id='sendOrderMessage']/p[2]/select")
	WebElement dropDownItem;

	@FindBy(xpath = ".//*[@id='sendOrderMessage']/p[3]/textarea")
	WebElement WEsendMessage;

	@FindBy(xpath = ".//*[@id='sendOrderMessage']/div/button")
	WebElement WEbtnSendMessage;

	@FindBy(xpath = ".//*[@id='block-order-detail']/p")
	WebElement WEMessageSentConfirmation;

	@FindBy(xpath = ".//*[@id='block-order-detail']/div[5]/table/tbody//td[1]")
	List<WebElement> messageList;

	@FindBy(xpath = ".//*[@id='block-order-detail']/div[5]/table/tbody/tr[1]/td[2]")
	WebElement latestMessage;

	@FindBy(xpath = ".//*[@id='order-detail-content']/table/tbody/tr[1]/td[2]")
	WebElement item1;

	// finds the order by date then clicks the corresponding details button
	public void findOrderByDate(String dateIn) {
		int counter = 1;
		for (WebElement element : webElements) {
			if (element.getText().equalsIgnoreCase(dateIn)) {
				driver.findElement(By.xpath(".//*[@id='order-list']/tbody/tr[" + counter + "]/td[7]//span")).click();
				test.log(LogStatus.PASS, "click the details button for the order");
				log.info("order details button pressed");
				break;
			}
			counter += 1;
		}
	}

	// selects an item from the dropdown list by index
	public void selectItem(int indexIn) {
		Select dropdownList = new Select(dropDownItem);
		dropdownList.selectByIndex(indexIn);
		test.log(LogStatus.PASS, "item selected from dropdown list");
		log.info("Item is selected by index postion" + indexIn);
	}

	// enters a message in the meesage box
	public void sendMessage(String messageIn) {
		WEsendMessage.sendKeys(messageIn);
		test.log(LogStatus.PASS, "Enter message in the message field");
		log.info("Message " + messageIn + " has been entered in the message box");
	}

	// clicks the send message button
	public void clickSendMessage() {
		WEbtnSendMessage.click();
		test.log(LogStatus.PASS, "click the send message button");
		log.info("Send message button has been clicked");
	}

	// this method checks the send message confirmation is displayed
	public void messageSentConfirmation() {
		Boolean messageVisible = false;
		if (WEMessageSentConfirmation.isDisplayed()) {
			messageVisible = true;
		}
		Assert.assertEquals(messageVisible.booleanValue(), true);
		test.log(LogStatus.PASS, "message sent confirmation message is visible");
		log.info("Message sent confirmation message is visible");
	}

	// checks the message entered is visible in the message list
	public void messageVisible(String messageIn) {
		Assert.assertEquals(messageIn, latestMessage.getText());
		test.log(LogStatus.PASS, "new message is displayed in message list");
		log.info("New message is visible in message list");
	}

	// chekcs the item size for the first item
	public void checkItemSize(String sizeIn) {
		Assert.assertEquals(sizeIn, item1.getText().substring(item1.getText().length() - 1));
		test.log(LogStatus.PASS, "check the size is as expected");
		log.info("size of item has been checked " + " " + sizeIn);
	}

}

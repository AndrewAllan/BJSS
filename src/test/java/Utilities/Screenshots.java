package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	public static String takeScreenshots(WebDriver driverIn,String fileNameIn) throws IOException	{
	fileNameIn = fileNameIn +".png";
	String directory ="E:/Development/Selenium2/Expedia.co.uk/Screenshots";
	File sourceFile =((TakesScreenshot)driverIn).getScreenshotAs(OutputType.FILE);
	String destination = directory+fileNameIn;
	FileUtils.copyFile(sourceFile, new File(destination));
	return destination;}
}

package Utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
	public static ExtentReports getInstance(){
		ExtentReports extent;
		String path ="Reports/BJSS.html";
		extent = new ExtentReports(path, false);
		extent.addSystemInfo("selenium Version", "3.0")
		.addSystemInfo("Platform","Windows 10");		
		return extent;	
	}
	

}

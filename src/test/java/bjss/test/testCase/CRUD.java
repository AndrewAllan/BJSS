package bjss.test.testCase;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Utilities.ExtentFactory;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CRUD {
	static Logger log = LogManager.getLogger(CRUD.class);
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void before(){
		report = ExtentFactory.getInstance();
		test = report.startTest("Test 4", "to check the post,put,get and delete rest methods");
	}
	@Test
	public void Get(){
		System.out.println(get("https://reqres.in/api/users/2").toString());
		get("https://reqres.in/api/users/2").then().assertThat().body("data.first_name", equalTo("Janet"));	
		log.info("using get to checked that user returned with id 2 is Janet");
		test.log(LogStatus.PASS, "use get to check that user returned with id 2 is Janet");
	}
	
	@Test
	public void postExample()
	{
		String myJson = "{\"name\":\"Andrew\", \"job\":\"TA\"}";
		given()
    	.contentType("application/json").
    	body(myJson).
        when().
        post("https://reqres.in/api/users").
        then().
        assertThat().
        body("name", equalTo("Andrew"), "job", equalTo("TA"));
		test.log(LogStatus.PASS, "use post to post name and job and check that the returned info has the name of Andrew and job as TA");
		log.info("using post and checking that the returned info has the name of Andrew and job as TA");
	}
	
	@Test
	public void putExample()
	{
		String myJson = "{\"name\":\"Andrew\", \"job\":\"TA\"}";
		given()
    	.contentType("application/json").
    	body(myJson).
        when().
        put("https://reqres.in/api/users/2").
        then().
        assertThat().
        body("name", equalTo("Andrew"), "job", equalTo("TA"));
		test.log(LogStatus.PASS, "use put to update name and job and check that the returned info has the name of Andrew and job as TA");	
		log.info("using post and checking that the returned info has the name of Andrew and job as TA");
	}
	
	@Test
	public void deleteExample()
	{	
		given()
    	.contentType("application/json"). 
        when().
        delete("https://reqres.in/api/users/2").
        then().
        assertThat().statusCode(204);
		test.log(LogStatus.PASS, "use delete to delete user at id 2 then check the response code is 204");		
		log.info("using delete and checking the return code is 204(nothing)");
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResults) throws IOException{
		if(testResults.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "the test has failed");
		}
		report.endTest(test);
		report.flush();
		}
	
}

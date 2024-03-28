package ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest()
	{
		String dir = System.getProperty("user.dir");   // Getting the path to store the Extent Reports
		String path = dir+"\\Reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); //Creating SparkReporter with Path
		reporter.config().setReportName("Login Site Report");
		reporter.config().setDocumentTitle("Test Reports");
		
		extent = new ExtentReports();   //Creating ExtentReport and attach the reporter to it
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Gokul");
	
	}
	
	@Test
	public void login()
	{
		ExtentTest test = extent.createTest("LogIn");   //Extent Test objects are created with the test
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println(driver.getTitle());
		if(ITestResult.SUCCESS==1)
		{
			test.log(Status.PASS, MarkupHelper.createLabel("The Test got Passed", ExtentColor.GREEN));
		}
		else {
			test.log(Status.FAIL, MarkupHelper.createLabel("The Test is Failed", ExtentColor.RED));
		}
		//test.fail("The Test got Failed");	// Failing the test and ExtentTest will send the 
											// report as the TestMethod is failed and updates in ExtentReport
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
		extent.flush();  // End the listening of Reports into the script
	}

}

package testNG_OOPS;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Parent_Class {
	
	static WebDriver driver;
	
	public static void inherit() {
		System.out.println("This is TestRun");
	}
	
	@BeforeTest
	public void beforeTest(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("It will run at last");
		driver.quit();
	}

}

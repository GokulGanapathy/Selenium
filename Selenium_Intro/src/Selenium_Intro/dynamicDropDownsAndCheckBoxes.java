package Selenium_Intro;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class dynamicDropDownsAndCheckBoxes {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='MAA']")).click();
		
		//driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
		
		
		/*//Calendar Automation
		 * On this instance Calendar is opened automatically
		 * Once we have given source and Destination its opened 
		 * We can directly interact with dates in calendar
		 */
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();   //Selecting Current Date
		
		SimpleDateFormat sdf= new SimpleDateFormat("E, MMM dd YYYY");
		String dt = sdf.format(new Date());
		System.out.println(dt);
		 
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='view_fulldate_id_1']")).getText(), dt);
		
		//Checking the Date2 is enabled or not
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		
		//The X mark in date2 Calendar
		System.out.println(driver.findElement(By.id("spclearDate")).isDisplayed());
		
		if(driver.findElement(By.xpath("//div[@class='picker-second']")).getAttribute("style").contains("0.5"))
		{
			System.out.println("Dates is Not Enabled and opacity is 0.5");
		}
		
		driver.findElement(By.xpath("//input[@value='RoundTrip']")).click();
		
		//Checking after clicking the round trip
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		System.out.println(driver.findElement(By.id("spclearDate")).isDisplayed());
		
		
		System.out.println(driver.findElement(By.xpath("//div[@class='picker-second']")).getAttribute("style"));
		
		if(driver.findElement(By.xpath("//div[@class='picker-second']")).getAttribute("style").contains("1"))
		{
			System.out.println("Dates is Enabled");
			
		}
		else
		{
			System.out.println("Dates is still not Enabled");
		}
		
		
		
		//CheckBoxes Automation
		
		driver.findElement(By.cssSelector("input[id*='chk_IndArm']")).click();	//Clicking on TextBox
		driver.findElement(By.xpath("//label[contains(@for,'chk_SeniorCitizenDiscount')]")).click();  //Clicking on Text
		
		//System.out.println(driver.findElement(By.xpath("//input[contains(@id,'chk_IndArm')]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'chk_IndArm')]")).isSelected());
		
		//System.out.println(driver.findElement(By.cssSelector("input[id*='chk_SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='chk_SeniorCitizenDiscount']")).isSelected());
		
		//System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		
		
	}

}

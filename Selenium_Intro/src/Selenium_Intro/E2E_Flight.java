package Selenium_Intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E_Flight {

	public static void main(String[] args) {

		System.setProperty("webdriver.chorome.driver","C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.cssSelector("input[name='ctl00$mainContent$rbtnl_Trip']")).click();
		
		driver.findElement(By.xpath("//input[contains(@name,'originStation1')][1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'DEL')]")).click();
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[contains(text(),'MAA')]")).click();
		
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
		
		Assert.assertTrue(driver.findElement(By.className("picker-second")).getAttribute("style").contains("0.5"));

		
		driver.findElement(By.id("divpaxinfo")).click();
		int noOfPassengers=5;
		for(int i=1;i<noOfPassengers;++i)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='paxinfo']")).getText(),noOfPassengers+" Adult");
		
		driver.findElement(By.xpath("//input[contains(@id,'chk_friendsandfamily')]")).click();
		
		Select currency = new Select(driver.findElement(By.cssSelector("select[name*='DropDownList']:nth-child(2)")));
	
		currency.selectByValue("USD");
		
		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();
		
		driver.quit();
	}

}

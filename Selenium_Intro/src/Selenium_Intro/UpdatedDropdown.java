package Selenium_Intro;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\geckodriver.exe");
		WebDriver driver =  new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		System.out.println("Enter Number of Adults : ");
		int adults = sc.nextInt();
		int x=adults;
		driver.findElement(By.cssSelector("div#divpaxinfo")).click();
		
		while(adults>1)
		{
			driver.findElement(By.xpath("//span[contains(@class,'pax-add')][2]")).click();
			adults--;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),x+" Adult");
		

	}

}

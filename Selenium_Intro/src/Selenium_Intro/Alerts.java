package Selenium_Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String name = "Gokul";
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(5000);
		//driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(name+"anand");
		
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().accept();
		//driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(name+"anand");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().dismiss();

	}

}

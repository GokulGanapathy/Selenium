package Selenium_Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//Cross Browser Testing
//		System.setProperty("Webdriver.edge.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
//		System.setProperty("Webdriver.gecko.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\geckodriver.exe");
//		WebDriver driver= new FirefoxDriver();
		
		
		String name="Gokul";
		String password = getPassword(driver); 
		System.out.println(password);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'User')]")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//div/span/input[@id='chkboxOne']")).click();
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.quit();

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[2]")).click();
		//button[text()='Reset Login'] -- Button text kind of Locator
		String passwordText = driver.findElement(By.cssSelector("p[class='infoMsg']")).getText();
		System.out.println(passwordText);
		String arr[]=passwordText.split("'");
		
		for(String str:arr)
		{
			System.out.println(str);
		}
		String password =  arr[1];
		return password;
		
	}

}

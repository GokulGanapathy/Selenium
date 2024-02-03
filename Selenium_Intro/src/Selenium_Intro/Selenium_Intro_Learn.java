package Selenium_Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Intro_Learn {

	public static void main(String[] args) {
		/*
		 * We can Invoke Browsers in 2 ways 
		 * 1.Selenium Manager - That will take care of all driver.exe file downloading and all other process.
		 * 2.Calling Manually by Setting Global System Properties - we have to specify the path of Driver according to our Browser version and set the value in Global Properties
		 */
		
		//1. Chrome Driver for Chrome Browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");  //Setting Global Properties Value of driver
		WebDriver driver = new ChromeDriver();
		
		//2.Gecko Driver for FireFox Browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\geckodriver.exe");
		//WebDriver driver =new FirefoxDriver();
		
		//3. Edge Driver for Edge Browser
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/");
		String title=driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getCurrentUrl());
		
		//driver.close();
		driver.quit();
		

	} 

}

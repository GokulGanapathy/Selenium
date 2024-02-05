package Selenium_4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class newTabAndWindows {

	public static void main(String args[]) {
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		//driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String homeUrl = itr.next();
		String newTab = itr.next();
		driver.switchTo().window(newTab);
		driver.get("https://rahulshettyacademy.com/");
		
		String firstLink = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(homeUrl);
		driver.findElement(By.name("name")).sendKeys(firstLink);
		driver.quit();
		
	}
}

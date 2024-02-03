package RealTimeScenarios;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LimitDriverScopeAndLinks {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr[1]/td/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());	
		
		for(int i=1;i<columnDriver.findElements(By.tagName("a")).size();++i)
		{
			String newTab =Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(newTab);
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext())
		{
			Thread.sleep(5000);
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}

}

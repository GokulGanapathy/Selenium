package RealTimeScenarios;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

public class LinksAndDriverScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1.Total Num of links in the page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int noOfLinks = links.size();
		System.out.println(noOfLinks);
		
		//2.Links in Footer section 
		
		System.out.println(driver.findElements(By.xpath("//li/a")).size());
		// the above way will find all the links in the footer that is "//li/a" but if that same xpath applies
		// for other elements of the page then it will fetch those also
		
		//--Limiting WebDriver Scope to a ParticularArea
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//3.Links in a single column of a Footer -- Limiting the scope further to the column levels
		WebElement column1Driver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		int linksCountCol1 = column1Driver.findElements(By.tagName("a")).size();
		System.out.println(linksCountCol1);
		
		//4.Opening each link available
		for(int i=1;i<linksCountCol1;++i)
		{
			System.out.println(column1Driver.findElement(By.xpath("//li["+i+"]")).getText());
			
			/*
			 * column1Driver.findElements(By.tagName("a")).get(i).click(); 	// generic Way of locating elements
			 
			 * Since the links are opening in the same page the Driver is not able to find the element 
			 * and its throws StaleElementReferenceException
			 *		
			 * column1Driver.findElements(By.tagName("a")).get(i).click();
			   System.out.println(driver.getTitle());
			   driver.navigate().back();
			 */
			//column1Driver.findElement(By.xpath("//li["+i+"]/a")).click(); // More of a Static way
			
			WebElement link = column1Driver.findElements(By.tagName("a")).get(i);
			
			String newtabclick = Keys.chord(Keys.CONTROL,Keys.ENTER);  //For multiple Keys selection
			link.sendKeys(newtabclick);
			
			//Same using action class
			//Actions action = new Actions(driver);
			//action.moveToElement(link).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
			
		}
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> itr = tabs.iterator();
		while(itr.hasNext()) {
			String tab = itr.next();
			driver.switchTo().window(tab);
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}

}

package RealTimeScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class eBay_Automation {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		System.out.println("The links count in the page :"+driver.findElements(By.tagName("a")).size());
		
		WebElement footerDriver = driver.findElement(By.id("glbfooter"));
		System.out.println("The links count in the footer :"+footerDriver.findElements(By.tagName("a")).size());
		
		WebElement columnDriver = footerDriver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[2]"));
		System.out.println("The links count in the footer's Column :"+columnDriver.findElements(By.tagName("a")).size());
		
		int n = columnDriver.findElements(By.tagName("a")).size();
		
		String beforeClick=null;
		String afterClick;
		
		for(int i=0;i<n;++i) {
			String link=columnDriver.findElements(By.tagName("a")).get(i).getText();
			if(link.contains("Site map"))
			{
				beforeClick=driver.getTitle();
				
				columnDriver.findElements(By.tagName("a")).get(i).click();
				break;
			}
			
		}
		afterClick=driver.getTitle();
		
		if(!beforeClick.equals(afterClick)) 
		{
			if(driver.getPageSource().contains("sitemap")) {
				System.out.println("TC Passed : Site Map page opened");
			}
		}
		else
		{
			System.out.println("TC Failed : Site Map page not opened");
		}
	}

}

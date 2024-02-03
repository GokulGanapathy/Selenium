package Selenium_Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildParentSiblingLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.driver.chromedriver","C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/*Getting the Sibling of a Element 
			-- 2 Ways of getting 
		 *  Next One - Following-sibling::Tagname
		 *  Preceding One - Preceding-sibling::Tagname
		 */ 
		//driver.findElement(By.xpath("//section/div/div[1]/a[1]/following-sibling::a[1]")).click(); -- For diff page and diff element
		String buttonText = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(buttonText);
		System.out.println(driver.findElement(By.xpath("//header/div/a/following-sibling::button[3]")).getText());
		driver.findElement(By.xpath("//header/div/button[1]/preceding-sibling::a")).click();		
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		/* Parent Element from Child Using xPath
		 * Parent::Tagname
		 * Can use multiple instances like //Xpath/Parent::Tag/Parent:Tag
		 */
		System.out.println(driver.findElement(By.xpath("//header/div/button[2]/parent::div/parent::header/a[2]")).getText());
		
		System.out.println(driver.findElement(By.xpath("//div/a/parent::div/button[2]")).getText());

	}

}

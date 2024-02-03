package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment8_autoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("unit");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul[id='ui-id-1'] li")));
		
		List<WebElement> autoSuggestions = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));
		System.out.println(autoSuggestions);
		
		for(int i=0;i<autoSuggestions.size();++i)
		{
			String suggest = autoSuggestions.get(i).getText();
			System.out.println(suggest);
			if(suggest.equals("United Arab Emirates"))
			{
				autoSuggestions.get(i).click();
				break;
			}
		}
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("autocomplete"))).doubleClick().perform();
		
		
		//Getting the text on the editBox using getAttribute method -- 
		//This is generic even if attribute value is not there in HTML DOM,we can use this
		
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// The Return type is Object and we are type casting it to String, - We should use return in the JS Statement
		String value = (String) js.executeScript("return document.getElementById('autocomplete').value");
		System.out.println(value);
		driver.quit();
	} 

}

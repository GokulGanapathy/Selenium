package AdvancedElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actions_ajaxMethods {

	public static void main(String[] args) {
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		
		Actions action = new Actions(driver); //Created a Object of action class 
												//and passing driver instance to the constructor
		
		WebElement accountAndList = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		
		action.moveToElement(accountAndList).build().perform();
		
		WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		
		action.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("redmi")
						.keyUp(Keys.SHIFT).sendKeys("note").doubleClick().build().perform();
		
		action.moveToElement(driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")))
						.contextClick().build().perform();
		
		action.moveToElement(accountAndList).keyDown(Keys.SHIFT).click().build().perform(); //Open the link in the new Window
		
		driver.quit();
		
	}

}

package Selenium_Intro;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggestionBox {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		amazonSuggestion(driver);

		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		// Thread.sleep(1000);
		List<WebElement> suggestions = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));

		for (WebElement suggest : suggestions) {
			System.out.println(suggest.getText());
			if ((suggest.getText()).equalsIgnoreCase("India")) {
				suggest.click();
				break;
			}
		}
		driver.quit();

	}

	public static void amazonSuggestion(WebDriver driver) throws InterruptedException {
		/*
		 * Amazon Site Tried
		 * 
		 * 
		 */
		driver.get("https://www.amazon.in/ref=nav_logo");

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("boat");
		Thread.sleep(5000);
		List<WebElement> suggestions = driver
				.findElements(By.xpath("//div/div/div[@class='s-suggestion s-suggestion-ellipsis-direction']/span"));

		for (WebElement suggest : suggestions) {
			if ((suggest.getText()).contains("smart watch")) {
				suggest.click();
				break;
			}
		}
	}

}

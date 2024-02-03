package FunctionalTesting;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenCart_ADDTOCART {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Implicit Wait: 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] itemsToBuy = { "Beans", "Cucumber", "Pumpkin", "Corn", "Potato", "Strawberry", "Mushroom","Water Melon" };

		addItemsToCart(driver, itemsToBuy);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click(); //also use : //button[contains(text(),'PROCEED TO CHECKOUT')]
		
		//Explicit Wait
		/*
		 * Calling and Instantiating WebDriverWait class's Object
		 * Then we can use the wait method to perform specific operation of wait 
		 * we can use the wait again and again in our script
		 */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		/*
		 * Let's Use Explicit Fluent wait here
		 */
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		fluentWait.until(new Function<WebDriver, WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				
				return driver.findElement(By.className("promoInfo"));
			}
		});
		
		System.out.println(driver.findElement(By.className("promoInfo")).getText( ));
		
	
	}

	public static void addItemsToCart(WebDriver driver, String itemsToBuy[]) {
		List<String> list = Arrays.asList(itemsToBuy);

		List<WebElement> products1 = driver.findElements(By.xpath("//h4[@class='product-name']"));

		int count = 0;
		for (int i = 0; i < products1.size(); ++i) {
			String item = products1.get(i).getText();

			String itemName = (item.split("-"))[0].trim(); // We Just want the name of that element so splitting and
														   // getting 0th Index

			if (list.contains(itemName)) {
				
				String loc = "//h4[@class='product-name']/parent::div/parent::div/div[" + (i + 1)+ "]/div/button[@type='button']";

				driver.findElement(By.xpath(loc)).click();
				count++;
				if (count == list.size()) {
					break;
				}
			}
			//System.out.println(list.size());
		}
		
	}

}

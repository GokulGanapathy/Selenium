package FunctionalTesting;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

public class fluentwait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		//Fluent Wait
		
		//Method 1 : 
		//Using until and ExpectedConditions with Fluent wait
		
		 /*Wait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(20)) // Maximum wait time
	                .pollingEvery(Duration.ofSeconds(2)) // Polling interval
	                .ignoring(NoSuchElementException.class);

	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish h4")));*/
	    
	    //Method 2 :
	    //Calling Fluent Wait Class and Method
	    
		/*FluentWait fwait = new FluentWait(driver);
		fwait.withTimeout(Duration.ofSeconds(4));
		fwait.pollingEvery(Duration.ofSeconds(4));
		fwait.ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish h4")));*/
		
		//Method 3 :
		//Using Function Interface
		
		Wait<WebDriver> fleuwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		fleuwait.until(new Function<WebDriver, WebElement>(){
			
			public WebElement apply(WebDriver driver)
			{
				if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
				{
					return driver.findElement(By.cssSelector("#finish h4"));
				}
				else
				{
					return null;
				}
				
			}
		});
		
		System.out.println(driver.findElement(By.cssSelector("#finish h4")).getText());
		
		
		
		/*
		 * Fluent Wait using LKM Site
		 */
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/login.htm");
		driver.findElement(By.id("userName")).sendKeys("gg12345");
		driver.findElement(By.id("password")).sendKeys("gokul95");
		driver.findElement(By.name("Login")).click();
		driver.findElement(By.id("myInput")).sendKeys("Headphone");
		//driver.findElement(By.xpath("//div[@id='myInputautocomplete-list']")).click();
		driver.findElement(By.cssSelector("input[value='FIND DETAILS']")).click();
		driver.findElement(By.cssSelector(".btn.btn.btn-success.btn-product")).click();
		
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		wait2.until(new Function<WebDriver, WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.xpath("//div/h3")).isDisplayed())
				{
					return driver.findElement(By.xpath("//div/h3"));
				}
				else
				{
					return null;
				}
			}
		});
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
	}

}

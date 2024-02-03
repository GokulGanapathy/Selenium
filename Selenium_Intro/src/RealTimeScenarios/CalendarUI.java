package RealTimeScenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarUI {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webDriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		pathToUs(driver);
		
		String month = "May";
		String date = "9";
		driver.get("https://www.airindia.com/");
		driver.findElement(By.cssSelector(".btn.bi.bi-calendar3")).click();
		
		while(!driver.findElement(By.xpath("//*[@id='homePageNew']/ngb-datepicker/div[2]/div[1]/div")).getText().contains(month))
		{
			System.out.println(driver.findElement(By.xpath("//*[@id='homePageNew']/ngb-datepicker/div[2]/div[1]/div")).getText());
			driver.findElement(By.cssSelector("div[class='ngb-dp-arrow right'] button[title='Next month']")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.cssSelector(".ngb-dp-day"));
		for(int i=0;i<dates.size();++i)
		{
			if(dates.get(i).getText().equals(date))
			{
				dates.get(i).click();
				break;
			}
		}
		
		
		
	}
	
	public static void pathToUs(WebDriver driver) throws InterruptedException {
		driver.get("https://www.path2usa.com/travel-companion/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1300)");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input[placeholder='Date of travel']")).click();
		
		while(!driver.findElement(By.cssSelector("span[class='cur-month']")).getText().contains("April")) {
			driver.findElement(By.cssSelector("span[class='flatpickr-next-month'] svg")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.xpath("//span[contains(@class,'flatpickr-day')]"));
		for(int i=0;i<dates.size();++i)
		{
			String date = driver.findElements(By.xpath("//span[contains(@class,'flatpickr-day')]")).get(i).getText();
			if(date.equalsIgnoreCase("30"))
			{
				driver.findElements(By.xpath("//span[contains(@class,'flatpickr-day')]")).get(i).click();
				break;
			}
		}
	}

}

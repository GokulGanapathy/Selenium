package testNG_OOPS;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_Class extends Parent_Class{

	@BeforeMethod
	public static void beforeMethod() {	
		driver.get("https://www.makemytrip.com/");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[title*='notification-frame']")));
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[name*='notification-frame']")));
		//driver.findElement(By.cssSelector("a[id*='webklipper-publisher']")).click();
		//driver.switchTo().defaultContent();
	
	}
	
	
	@Test
	public static void testRun() throws InterruptedException
	{
		inherit();
		System.out.println("This is Test Part");
		driver.findElement(By.xpath("//li[@class='menu_Hotels']")).click();
		Thread.sleep(3000);
	}

}

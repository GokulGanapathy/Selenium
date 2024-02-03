package Assignments;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4_WindowHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		//driver.findElement(By.xpath("//li/a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentId = itr.next();
		String childId = itr.next();
		
		driver.switchTo().window(childId);
		String childText = driver.findElement(By.xpath("//h3")).getText();
		System.out.println(childText);
		
		driver.switchTo().window(parentId);
		String parentText = driver.findElement(By.xpath("//h3")).getText();
		System.out.println(parentText);
		
	}

}

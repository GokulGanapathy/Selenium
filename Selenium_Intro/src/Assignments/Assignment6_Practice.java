package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6_Practice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//label[@for='honda']/input")).click();
		String label = driver.findElement(By.xpath("//label[@for='honda']/input")).getAttribute("value");
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByValue(label);
		
		driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys(label);
		
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		String alertText = driver.switchTo().alert().getText();
		if(alertText.contains(label))
		{
			System.out.println(alertText);
			driver.switchTo().alert().accept();
		}
		else
		{
			System.err.print("The "+label+" is not present in alert Text");
		}
	}

}

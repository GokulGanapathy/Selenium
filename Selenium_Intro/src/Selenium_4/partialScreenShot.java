package Selenium_4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class partialScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("Gokul");
		File screenShot = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("ScreenShots//PartialScreenshot//nameSS.jpg"));
		
		WebElement email =driver.findElement(By.cssSelector("input[name='email']"));
		email.sendKeys("gokul@aksg.com");
		File screenShot1 = email.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot1, new File("ScreenShots/PartialScreenshot/emailSS.jpg"));

	}

}

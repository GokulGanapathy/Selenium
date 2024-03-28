package FileUploadAndDownload;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class uploadFile {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void broswerSetUp() {
		
	System.setProperty("WebDriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	}
	
	@Test(priority=1)
	public void uploadFile() {
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("File Upload")).click();
		File file = new File("ScreenShots\\js1.jpg");
		System.out.println(file.getAbsolutePath());
		driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys(file.getAbsolutePath());
		driver.findElement(By.cssSelector("input[value='Upload']")).click();
		Assert.assertEquals("File Uploaded!", driver.findElement(By.cssSelector(".example h3")).getText());
		assertTrue(driver.findElement(By.cssSelector(".example div")).getText().contains("js1.jpg"));
	
		
	}
	
	@Test(priority=2)
	public void downloadFile() throws InterruptedException {
		driver.navigate().to("https://the-internet.herokuapp.com/download");
		driver.findElement(By.cssSelector(".example a:nth-child(8)")).click();
		Thread.sleep(5000);
	}
	
}

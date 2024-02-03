package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2_AngularSite_E2E {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.findElement(By.name("name")).sendKeys("Gokul");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gokul@gokul.com");
		driver.findElement(By.cssSelector("input#exampleInputPassword1")).sendKeys("Gokul123");
		driver.findElement(By.id("exampleCheck1")).click();

		Select gender = new Select(driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")));
		gender.selectByIndex(0);

		driver.findElement(By.cssSelector("input#inlineRadio2")).click();

		driver.findElement(By.name("bday")).sendKeys("09-05-1998");
		driver.findElement(By.cssSelector(".btn.btn-success")).click();

		String msg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println(msg);

		driver.quit();
	}

}

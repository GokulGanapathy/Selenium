package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3_Wait_LoginSite {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).sendKeys("learning");
		driver.findElement(By.xpath("//label/span[contains(text(),'User')]")).click();
		
		//Explicit Wait of 5 Seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		/*System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();*/
		
		Select dropDown = new Select(driver.findElement(By.cssSelector("select[data-style='btn-info']")));
		dropDown.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@name='terms']"));
		
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Shop Name']")));
		
		List<WebElement> productName = driver.findElements(By.xpath("h4[class='card-title']"));
		for(int i=0;i<productName.size();++i)
		{
			System.out.println(productName.get(i).getText());
		}
		
		List<WebElement> products = driver.findElements(By.xpath("//button[contains(text(),'Add')]"));
		
		for(int i=0;i<products.size();++i)
		{
			products.get(i).click();
		}
		
		String carts = driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).getText();
		if(carts.contains(Integer.toString(products.size())))
		{
			System.out.println("All products were added to the cart");
		}
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		driver.quit();
	}
}

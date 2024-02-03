package AdvancedElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Frames {

	public static void main(String[] args) {
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println("Number of frames are : "+driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0); //-- Using Frame Index
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"))); //--Using Frame WebElement
		System.out.println(driver.findElement(By.id("draggable")).getText());
		
		
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, target).build().perform();  // --Using DragAndDrop Method 
		
		//--Using Click and Hold then move to target then release so we mimic the same actions
		//action.clickAndHold(source).moveToElement(target).release().build().perform();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='droppable']/p")).getText(), "Dropped!");
		
		driver.switchTo().defaultContent();  // --Switching to Normal HTML page 
		driver.findElement(By.linkText("Accept")).click();
	}

}

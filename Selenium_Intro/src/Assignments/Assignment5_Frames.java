package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5_Frames {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Nested Frames")).click();
		
		driver.switchTo().frame("frame-top"); //1st Frame
		driver.switchTo().frame("frame-middle"); //Another Frame inside the 1st Frame
		
		String middle = driver.findElement(By.cssSelector("div[id='content']")).getText();
		System.out.println(middle);
		
		//Switching again 
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.name("frame-top")).getAttribute("src"));
		
		driver.switchTo().defaultContent();
		driver.quit();
		
	}

}

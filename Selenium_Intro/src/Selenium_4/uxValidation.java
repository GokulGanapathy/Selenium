package Selenium_4;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class uxValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		//Specifying the dimension
		//Dimension dim = new Dimension(100,1000);
		//driver.manage().window().setSize(dim);
		
		WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
		
		System.out.println(name.getSize().getHeight());
		System.out.println(name.getSize().getWidth());
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		System.out.println(name.getRect().getX());
		System.out.println(name.getRect().getY());
		System.out.println(name.getSize());
		System.out.println(name.getRect().getDimension());
		
		// getRect().getDimension() and getSize() both are doing the same function only.
		driver.quit();
		
	}

}

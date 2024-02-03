package Selenium_Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//Chrome Browser will get Instantiated by Selenium Manager
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		/*
		 * Dropdown with Select tag are Static Dropdowns
		 * We have to Instantiate Select Class object with WebElement of that Select Tag
		 */
		
		WebElement currencyDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select currency = new Select(currencyDropDown);
		
		currency.selectByIndex(3);
		System.out.println(currency.getFirstSelectedOption().getText());
		
		currency.selectByValue("INR");
		System.out.println(currency.getFirstSelectedOption().getText());
		
		currency.selectByVisibleText("AED");
		System.out.println(currency.getFirstSelectedOption().getText());
	}

}

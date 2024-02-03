package Other_IMP_Essentials;

import java.util.*;

import javax.net.ssl.HttpsURLConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Broken_Links {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		SoftAssert s = new SoftAssert();
		
		//This is a Single Link in Page
		String hrefLink = driver.findElement(By.linkText("Broken Link")).getAttribute("href");
		
		/*
		 * Using Various Classes and methods of Java.net to make headless connection with URLs
		 * 1.First we need to instantiate URL object and pass our link as a parameter
		 * 2.Then we can make use of openConnection() method in URL object for making a connection
		 *  	- url.OpenConnection() will return URLConnection object
		 *  	- We can either use URLConnection/HttpURLConnection/HttpsURLConnection (SSL ones)
		 *  	- URLConnection is not having much methods like setRequestMethod and getResponseCode 
		 *  	- So we are making use of HTTpURLCoonection and type casting our url.openConnection() with HTTpURLConnection
		 *  	- HttpsURLConnection can be used only for https:// links, otherwise it will throw typeCasting error.
		 *		- Then we can connect to the URL by using connect() method and get the ResponseCode() 
		 *		- If we use ResponseCode() without connect() its Okay, the connect() will be implicitly Called
		 */
		 
		URL url = new URL(hrefLink);
		HttpsURLConnection connect =  (HttpsURLConnection) url.openConnection();
		//connect.setRequestMethod("HEAD");
		//connect.connect(); // We don't need these actually because if we use any methods like getResponseCode 
		// connect() will be called implicitly
		int statusCode = connect.getResponseCode();
		System.out.println(statusCode);
		
		
		WebElement footer = driver.findElement(By.id("gf-BIG")); //Limiting WebDriver scope to footer
		List<WebElement>footerLinks = footer.findElements(By.cssSelector("li[class='gf-li'] a"));
		Iterator<WebElement> itr = footerLinks.iterator();
		while(itr.hasNext())
		{
			WebElement link = itr.next();
			String hrefLink1 = link.getAttribute("href");
			String linkText = link.getText();
			URL url1 = new URL(hrefLink1);
			
			HttpURLConnection connect1 =(HttpURLConnection) url1.openConnection();
			connect1.connect(); // This will be Implicitly Called
			int statusCode1 = connect1.getResponseCode();
			
			System.out.println("The Link : "+linkText+" Status Code : "+statusCode1);
			s.assertTrue(statusCode1<400,"The "+linkText+" is Broken | Status Code : "+statusCode1);
		}
		s.assertAll(); // Its Mandatory and it will throw all the Assertions at the end
		
	}

}

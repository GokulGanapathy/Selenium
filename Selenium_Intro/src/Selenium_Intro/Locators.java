package Selenium_Intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
			
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); // To Maximize the Driver-Browser Window
		//Defining Implicit Time wait 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Conventional Methods like Id,Name,Classname etc
		
		String name="Gokul";
	    driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("Hellopassword");
		driver.findElement(By.className("signInBtn")).click();
	 
		
		//Using the same with CSSSelectors/Xpath
		//driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Gokul");
		//driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("hello123");
		//driver.findElement(By.cssSelector("button.signInBtn")).click();  // button[class='submit signInBtn']
		
		/*
		Thread.sleep(1000);  // This Thread.sleep()method applies only for this step of the code
		*/
		
		String errMsg = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errMsg);
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Gokul");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("gokul@agscom");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("gokul@gmail.com");
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("+91 9876054321");  //Relative Xpath
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();				// CSSSelector .classname
		
		String infoTxt = driver.findElement(By.cssSelector("form p")).getText();	//CSS traversing
		System.out.println(infoTxt);
		
		
		//Using RegEx for Dynamic HTML Attributes
		driver.findElement(By.xpath("//button[contains(@class,'go-to')]"));
		//More complex Way of writing Xpath : //ParentTag/ChildTag
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[@class='go-to-login-btn']")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");  //CSS RegEx
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.name("chkboxTwo")).click();
		
		//driver.findElement(By.cssSelector("button[class*='signInBtn']")).click(); 	-- CSS(RegEx) for signIn
		driver.findElement(By.xpath("//button[contains(@class,'signInBtn')]")).click();	//XPath(RegEx) for SignIn
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.quit();
		
	}

}

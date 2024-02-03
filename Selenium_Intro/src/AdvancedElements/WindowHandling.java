package AdvancedElements;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import net.bytebuddy.dynamic.scaffold.RecordComponentRegistry.Default;

public class WindowHandling {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		System.out.println(driver.getWindowHandle());
		
		Set <String> windows = driver.getWindowHandles(); //Getting all WindowID instances
		Iterator<String> itr = windows.iterator();
		String parentId = itr.next();
		String childId = itr.next();
		
		driver.switchTo().window(childId);
		/*while(itr.hasNext()) {
			String window=itr.next();
			driver.switchTo().window(window);
		}
		*/
		//Alternate way by using For Loop
		/*for(String window :windows) {
			System.out.println(window);
			driver.switchTo().window(window);
		}*/
		
		String msg =driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(msg);
		System.out.println(msg.split(" ")[4]);
		String arr[]=msg.split(" ");
		String emailId=null;
		for(String val:arr) {
			if(val.contains("@") && val.contains(".com"))
			{
				emailId = val;
			}
		}
		System.out.println(emailId);
		driver.switchTo().window(parentId);
		//driver.switchTo().defaultContent();  //-- Its for Frames
		driver.findElement(By.name("username")).sendKeys(emailId);
		 
	}

}

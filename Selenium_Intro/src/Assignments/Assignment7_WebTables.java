package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment7_WebTables {

	public static void main(String[] args) {

		System.setProperty("WebDriver.gecko.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
		int colCount = driver.findElements(By.cssSelector("table[name='courses'] tr th")).size();
		System.out.println(colCount);
		
		List<WebElement> row2 = rows.get(2).findElements(By.tagName("td"));
		for(int i=0;i<row2.size();++i)
		{
			//WebElement col =row2.get(i); //Getting that specific column from that row
			System.out.println(row2.get(i).getText());
		}
		driver.quit();
	}

}

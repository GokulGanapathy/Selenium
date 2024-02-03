package RealTimeScenarios;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class javascriptexecutor {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/*JavascriptExecutor is a Selenium class that is used to perform the actions on a page
		 *  like scrolling finding the elements etc.
		 */
		JavascriptExecutor js = (JavascriptExecutor)driver;  // Casting the driver to Java Script Executor.
		js.executeScript("window.scrollBy(0,750)");
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File("ScreenShots/js1.jpg"));
		
		Thread.sleep(5000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=200");
		
		File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1, new File("ScreenShots/js2.jpg"));
		
		//Handling Table in Selenium
		//Limiting WebDriver scope to table
		WebElement table1 = driver.findElement(By.className("tableFixHead"));
		
		List<WebElement> rows = table1.findElements(By.cssSelector("tr"));
		for(int i=0;i<rows.size();++i)
		{
			List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<col.size();++j)
			{
				System.out.print(col.get(j).getText()+" ");
			}
			System.out.println();
		}
		
		//List<WebElement> amount = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		int sum=0;
		List<WebElement> amount = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		Iterator<WebElement> itr = amount.iterator();
		while(itr.hasNext())
		{
			sum=sum+Integer.parseInt(itr.next().getText());
		}
		System.out.println(sum);
	
		String text = driver.findElement(By.cssSelector(".totalAmount")).getText();
		int total = Integer.parseInt(text.split(":")[1].trim());
		Assert.assertEquals(total, sum);
		
		List<WebElement> data= driver.findElements(By.cssSelector("table[class='table-display'] td:nth-child(3)"));
		int sum1=0;
		for(int i=0;i<data.size();++i)
		{
			sum1=sum1+ Integer.parseInt(data.get(i).getText());
		}
		System.out.println(sum1);
	}

}

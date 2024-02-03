package FunctionalTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenCartSite {

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		String browser = sc.nextLine();
		String itemToBuy = sc.nextLine();
		DriverUtils browserDriver = new DriverUtils();
		WebDriver driver = browserDriver.browserInvoke(browser);
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		/*
		 * This is Static method Generates X-path using Parent/child-Sibling
		 * Relationship But if there is any changes in the text it might fail to locate
		 * the element and throws NoSuchElementException
		 */

		driver.findElement(By.xpath("//div/h4[text()='"+ itemToBuy +" - 1 Kg']/following-sibling::div/button[text()='ADD TO CART']")).click();
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//a[@class='product-remove'][1]")).click();
		driver.navigate().refresh();
		Thread.sleep(3000);

		/*
		 * The more Dynamic way is
		 */
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));

		for (int i = 0; i < products.size(); ++i) {
			WebElement prod = products.get(i);
			String product = prod.getText();
			if (product.contains(itemToBuy)) {
				int index = i + 1;
				String locator = "//h4[@class='product-name']/parent::div/parent::div/div[" + index+ "]/div/button[@type='button']";
				/*
				 * using sibling relationship
				 * //h4[@class='product-name']/following-sibling::div[@class='product-action']/button
				 */
				
				driver.findElement(By.xpath(locator)).click();
				break;
			}
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		/*
		 * Rahul Shetty's Way and add one or more elements in cart
		 * 
		 * Adding two or more Products into Cart using List.
		 * -By taking the List of product and searching whether the products are available in List 
		 * 		if yes we select the product else continue and removing that product from list
		 */
		driver.navigate().refresh();
		Thread.sleep(5000);

		String[] itemsToBuy = { "Beans", "Cucumber", "Pumpkin", "Corn", "Potato", "Strawberry", "Mushroom" };

		List<String> list = Arrays.asList(itemsToBuy);

		List<WebElement> products1 = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		int count=0;
		for (int i = 0; i < products1.size(); ++i) 
		{
			String item = products1.get(i).getText();
			
			String itemName = (item.split("-"))[0].trim(); // We Just want the name of that element so splitting and getting 0th Index
			if (list.contains(itemName))
			{
				System.out.println("true");
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				String loc= "//h4[@class='product-name']/parent::div/parent::div/div["+(i+1)+"]/div/button[@type='button']";
				System.out.println(loc);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc)));
				
				driver.findElement(By.xpath(loc)).click();
				//driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				count++;
				if(count==list.size())
				{
					break;
				}
			}
			System.out.println(list.size());
		}
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
	}

}

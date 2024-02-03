package Other_IMP_Essentials;

import java.util.*;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class options_certificates {

	public static void main(String[] args) {
		
		/*
		 * We Can tweak the behavior of Chrome Browser like handling Certificates and Proxy etc using this 
		 * Chrome Options and it has lot of methods inside it, we need to pass options as arguments in driver
		 More available at : https://chromedriver.chromium.org/capabilities
		 https://chromedriver.chromium.org/capabilities#h.p_ID_40
		 */
		 
		ChromeOptions option = new ChromeOptions();
		
		option.setAcceptInsecureCerts(true);
		
		/*** Proxy for sites
		 * 
		 *   Proxy proxy = new Proxy();
			 proxy.setHttpProxy("ProxyServerLink");
			 option.setProxy(proxy);
		 */
		
		//Extension
		//option.addExtensions(Extension path);
		
		//Pop_Up Blocking
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		//Download Location Specifying
		Map<String,Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", "C:\\Users\\dell\\Documents");
		option.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}

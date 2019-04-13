/**
 * 
 */
package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author user
 *
 */
public class browser {
	
	static WebDriver driver;
	
	public static WebDriver startbrowser(String browserName,String url){
		
		if (browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\Downloads\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//			WebDriverWait wait=new WebDriverWait(driver, 20);
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
		}
		driver.get(url);
		return driver;
		
	}

}

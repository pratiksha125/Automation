package Helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	static WebDriver ldriver;
	public static WebDriver startBrowser(String browserName,String url){
		ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\Downloads\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
		}
		driver.get(url);
		return driver;
	}
	


}

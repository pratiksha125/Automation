/**
 * 
 */
package verifytestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.POM.pages.Login;
import com.POM.pages.explore;

/**
 * @author user
 *
 */
public class VerifyLoginTest_cases {
	
	@Test
	public void verifylogin(){
		System.setProperty("webdriver.gecko.driver","D:\\Downloads\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://labs2.cut2it.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Login login=new Login(driver);
		
		login.typesignin();
		
		login.typeusername();
		
		login.typepass();
		
		login.typelogin();
		
		explore explore=new explore(driver);
		
		explore.channel();
		
		explore.org();
	}
	

}

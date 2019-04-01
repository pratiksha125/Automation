package first;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class First_class {
	WebDriver driver;
	
	@BeforeTest
	public void fbLogin(){
		System.setProperty("webdriver.gecko.driver","D:\\Downloads\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
	}
	
	@Test(priority=1)
	public void verifyPageTitle(){
		String title=driver.getTitle();
		System.out.println("Title of page is:"+title);
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	
	@Test(priority=2)
	public void verifyLogo(){
		boolean flag=driver.findElement(By.xpath("//*[@id='blueBarDOMInspector']/div/div/div/div[1]/h1/a/i")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void signUp(){
		WebElement username=driver.findElement(By.name("firstname"));
		username.sendKeys("Test");
		driver.findElement(By.name("lastname")).sendKeys("Selenium");
		driver.findElement(By.name("reg_email__")).sendKeys("1234567890");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Pratiksha@123");
		
		Select day=new Select(driver.findElement(By.xpath("//*[@id='day']")));
		day.selectByIndex(3);
		
		Select month=new Select(driver.findElement(By.xpath("//*[@id='month']")));
		month.selectByVisibleText("Apr");
		
		Select year=new Select(driver.findElement(By.xpath("//*[@id='year']")));
		year.selectByIndex(1);
		
		driver.findElement(By.name("sex")).click();
		driver.findElement(By.name("websubmit")).click();
	}
	
//	@Test(priority=4)
//	public void Login(){
//		driver.findElement(By.id("email")).click();
////		driver.findElement(By.id("loginbutton")).click();
////		Thread.sleep(2000);
//		String actual_result=driver.findElement(By.name("email")).getText();
//		String expected_result= "The email address or phone number that you've entered doesn't match any account. ";
////		Assert.assertEquals(actual_result, expected_result);
//		Assert.assertTrue(actual_result.contains("The email address or phone number that you've entered doesn't match any account."));
//	}

	@Test(priority=4)
	public void Login(){
		driver.findElement(By.id("email")).sendKeys("pratikshakature77@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("1771996123");
		driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
//		driver.findElement(By.id("loginbutton")).click();
	}
	

	@Test(priority=5)
		public void Friends(){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id='navItem_100005683844111']/a")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Friends")).click();
		}
	
	
//	@AfterTest
//	public void quit(){
//		driver.quit();
//	}
}

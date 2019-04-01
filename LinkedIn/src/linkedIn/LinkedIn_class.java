package linkedIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LinkedIn_class{
	 WebDriver driver;
	String actualErrorMessage;
	String expectedErrorMessage="Please enter your first name";
	
	@Test(priority=1)
	public void launch_browser(){
		System.setProperty("webdriver.gecko.driver","D:\\Downloads\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.linkedin.com");
	}
	
	@Test(priority=2)
	public void Firstname(){
		driver.findElement(By.name("firstName")).sendKeys("ABC");
		driver.findElement(By.id("registration-submit")).click();
		actualErrorMessage=driver.findElement(By.cssSelector(".reg-alert")).getText();
		Assert.assertTrue(actualErrorMessage.contains("Please enter your last name"));
	}

	@Test(priority=3)
	public void Lastname(){
		driver.findElement(By.name("lastName")).sendKeys("ABC");
		driver.findElement(By.id("registration-submit")).click();
		actualErrorMessage=driver.findElement(By.cssSelector(".reg-alert")).getText();
		Assert.assertTrue(actualErrorMessage.contains("Please enter your email address or mobile number"));
	}
	
//	@Test(priority=4)
//	public void Email(){
//		driver.findElement(By.name("session_key")).sendKeys("aa");
//		driver.findElement(By.id("registration-submit")).click();
//		actualErrorMessage=driver.findElement(By.cssSelector(".reg-alert")).getText();
//		Assert.assertTrue(actualErrorMessage.contains("Please enter a valid email address or mobile number"));
//	}
	
	@Test(priority=4)
	public void Valid_Email(){
		driver.findElement(By.id("reg-email")).sendKeys("aa@gmail.com");
		driver.findElement(By.id("registration-submit")).click();
		actualErrorMessage=driver.findElement(By.cssSelector(".reg-alert")).getText();
		Assert.assertTrue(actualErrorMessage.contains("Please enter a valid email address or mobile number"));
	}
	
	@Test(priority=5)
	public void Password(){
		driver.findElement(By.id("reg-password")).sendKeys("aaaa@1234");
		driver.findElement(By.id("registration-submit")).click();
		actualErrorMessage=driver.findElement(By.cssSelector(".reg-alert")).getText();
		Assert.assertTrue(actualErrorMessage.contains("Please enter your password"));
	}
}

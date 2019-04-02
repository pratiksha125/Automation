package mercury_Tour;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Mercury_Tour {
	WebDriver driver;
	
	@Test(priority=1)
	public void A(){
		 System.setProperty("webdriver.gecko.driver","D:\\Downloads\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	}
	
	@Test(priority=2)
	public void support(){
		driver.findElement(By.linkText("SUPPORT")).click();
		driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td/a")).click();
	}
	
	@Test(priority=3)
	public void Resgister(){
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("ABC");
		driver.findElement(By.name("lastName")).sendKeys("XYZ");
		driver.findElement(By.name("phone")).sendKeys("88888890555");
		driver.findElement(By.name("userName")).sendKeys("abc@mailinator.com");
		
		//Mailing information
		driver.findElement(By.name("address1")).sendKeys("Bhekarai Nagar");
		driver.findElement(By.name("city")).sendKeys("pune");
		driver.findElement(By.name("state")).sendKeys("Maharastra");
		driver.findElement(By.name("postalCode")).sendKeys("412308");
		
		//for dropdown
		Select country=new Select(driver.findElement(By.name("country")));
		country.selectByIndex(92);
		
		//user information
		driver.findElement(By.name("email")).sendKeys("abc@mailinator.com");
		driver.findElement(By.name("password")).sendKeys("pratiksha123");
		driver.findElement(By.name("confirmPassword")).sendKeys("pratiksha123");
		driver.findElement(By.name("register")).click();
	}
	
	@Test(priority=4)
	public void Sign_on(){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("abc@mailinator.com");
		driver.findElement(By.name("password")).sendKeys("pratiksha123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	}

	@Test(priority=5)
	public void Flight_finder(){
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 30);
		//Flight details
		driver.findElement(By.name("tripType")).click();
		//for dropdown
		Select passenger=new Select(driver.findElement(By.name("passCount")));
		passenger.selectByIndex(2);
		
		Select depart=new Select(driver.findElement(By.name("fromPort")));
		depart.selectByIndex(3);
		
		Select month=new Select(driver.findElement(By.name("fromMonth")));
		month.selectByVisibleText("March");
		
		Select date=new Select(driver.findElement(By.name("toDay")));
		date.selectByIndex(3);
		
		Select port=new Select(driver.findElement(By.name("toPort")));
		port.selectByIndex(3);
		
		Select Return=new Select(driver.findElement(By.name("toMonth")));
		Return.selectByVisibleText("May");
		
		Select Return_date=new Select(driver.findElement(By.name("toDay")));
		Return_date.selectByIndex(3);
	}
	
	@Test(priority=6)
	public void preferences(){
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 40);
//		driver.findElement(By.cssSelector("input[value='oneway']")).click();
		
		Select airline=new Select(driver.findElement(By.name("airline")));
		airline.selectByIndex(2);
		
		driver.findElement(By.name("findFlights")).click();
	}
}

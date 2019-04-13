/**
 * 
 */
package com.cut2it.pages;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author user
 *
 */
public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/nav/ul/li[5]")
	@CacheLookup
	WebElement signin;
	
	@FindBy(id="txtUserNameLoginId")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="txtPasswordId")
	@CacheLookup
	WebElement password;
	
//	@FindBy(name="submit")
//	@CacheLookup
//	WebElement login;
	
	public void Login_page(String uid,String pass){
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		signin.click();
		username.sendKeys(uid);
		password.sendKeys(pass);
		password.sendKeys(Keys.ENTER);
	}
}

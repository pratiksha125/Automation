/**
 * 
 */
package com.cut2it.Testcases;

//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cut2it.pages.LoginPage;

import helper.browser;

/**
 * @author user
 *
 */
@Test
public class Cut2it_Testcases {
	
	public void main_testcase(){
	
	WebDriver driver=browser.startbrowser("firefox","https://labs2.cut2it.com");
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	LoginPage landing_page=PageFactory.initElements(driver, LoginPage.class);
	
	landing_page.Login_page("superadmin@cut2it.com","The best paths are new and untried.");

	}
}

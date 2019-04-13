package com.Wordpress.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Wordpress.Page.LoginPageNew;
import com.Wordpress.Page.PostPage;

import Helper.BrowserFactory;

public class VerifyValidLogin {
	
	@Test
	public void checkValidUser(){
		
		WebDriver driver=BrowserFactory.startBrowser("firefox", "http://demosite.center/wordpress/wp-login.php");
		
		LoginPageNew login_page=PageFactory.initElements(driver, LoginPageNew.class);
		
		login_page.login_wordpress("admin", "demo123");
		
		PostPage post_Page=PageFactory.initElements(driver, PostPage.class);
		
		post_Page.Post_link();
	}

}

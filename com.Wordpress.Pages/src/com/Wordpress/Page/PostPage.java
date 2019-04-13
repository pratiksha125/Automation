package com.Wordpress.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage {
	
	WebDriver driver;
	public PostPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@id='menu-posts']/a/div[3]")
	WebElement post;
	
	public void Post_link(){
		post.click();
	}

}

package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	// Page Objects,Object Repository
	@FindBy(name = "user-name")
	WebElement name;
	
	 
	
	@FindBy(name = "password")
	WebElement password; 
	
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@class=\"error-message-container error\"]")
	WebElement errorsign;
	
	@FindBy(xpath = "//div[@class=\"bot_column\"]")
	WebElement logo;
	
	// initializing the Page Object
	
	public LoginPage ()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	// Actions 
	
	public WebElement getErrorsign() {
		return errorsign;
	}

	public boolean logookay()
	{
		return logo.isDisplayed();
		
	}
	
	public HomePage login(String login, String pw)
	{
		name.sendKeys(login);
		password.sendKeys(pw);
		loginbtn.click();
		
		return new HomePage();
	}
	
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	

}

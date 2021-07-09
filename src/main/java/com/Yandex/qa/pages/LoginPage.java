package com.Yandex.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Yandex.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	// Page Objects,Object Repository
	@FindBy(name = "user-name")
	WebElement name;
	
	 
	
	@FindBy(name = "password")
	WebElement password; 
	
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div[1]/div/form/input")
	WebElement loginbtn;
	
	
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div[2]")
	WebElement logo;
	
	// initializing the Page Object
	
	public LoginPage ()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	// Actions 
	
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

package com.Saucedemo.qa.testcases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		//super();
	}
	
	// Testcase should be seperated -- independant of each other
	// before each TestCase -- Launch the Browser and Login
	// Test -- execute the Test case
	// after each Test Case -- close the browser

	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage=new LoginPage();
	}
	
	
	@Test(priority=1,expectedExceptions = NoSuchElementException.class,
			 description = "Testcase 1 : Login validation using correct credentials")

	public void loginTest()
	{
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(loginPage.getErrorsign().isDisplayed(),false,"Error Message should not be displayed with correct credentials");
		Assert.assertEquals(driver.getTitle()=="https://www.saucedemo.com/inventory.html", true, "User is unable to go to the Home Page");
		
		
	}
	
	@Test(priority=2,description = "Testcase 2 : Login validation using incorrect credentials")
	public void loginFailTest()
	{
		homePage = loginPage.login("user","pass");
		Assert.assertEquals(loginPage.getErrorsign().isDisplayed(),true,"Error Message not displayed with wrong credentials");
	}
	
	
	
	
	@Test(priority=2, description = "Testcase 3 : Page title Validation (LoginPage) ")
	public void loginPageTitleTest()
	{
	String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	
	
	@Test(priority=3, description = "Testcase 4 : Validation of Logo display status (expected TRUE)")
	public void logoPresent()
	{
		Assert.assertEquals(loginPage.logookay(),true);
		
	}


	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

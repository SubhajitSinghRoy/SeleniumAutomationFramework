package com.Yandex.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Yandex.qa.base.TestBase;
import com.Yandex.qa.pages.HomePage;
import com.Yandex.qa.pages.LoginPage;

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
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
	String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Test(priority=2)
	public void logoPresent()
	{
		Assert.assertEquals(loginPage.logookay(),true);
		
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

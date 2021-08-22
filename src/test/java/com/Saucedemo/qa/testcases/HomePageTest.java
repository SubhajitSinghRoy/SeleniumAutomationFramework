package com.Saucedemo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.CartPage;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	@BeforeMethod
public void setUp() {
		
		initialization();
		loginPage=new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=2,description = "Testcase 5 : ")
	public void homePageTitleTest() throws InterruptedException
	{
		Assert.assertEquals(driver.getTitle(),"Swag Labs", "title did not match");
		Thread.sleep(4000);
	}
	
	@Test(priority=1,description = "Testcase 4 : URL Validation(HomePage)")
	public void cartLinkCheck()
	{
	
		cartPage= homePage.goToCart();
	Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html","Link did not match");
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}	

}

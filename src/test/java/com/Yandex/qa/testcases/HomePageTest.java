package com.Yandex.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Yandex.qa.base.TestBase;
import com.Yandex.qa.pages.CartPage;
import com.Yandex.qa.pages.HomePage;
import com.Yandex.qa.pages.LoginPage;

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
	@Test
	public void homePageTitleTest() throws InterruptedException
	{
		Assert.assertEquals(driver.getTitle(),"Swag Labs", "title did not match");
		Thread.sleep(4000);
	}
	
	@Test
	public void cartLinkCheck()
	{
	
		cartPage= homePage.addToCart();
	Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html","Link did not match");
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}	

}

package com.Saucedemo.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.CartPage;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;

public class CartPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	String itemName;

	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage=new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password")); 	
	}	
	
	@Test
	@Parameters({("itemName")})
	public void cartListCheck(String itemName) throws InterruptedException
	{
		homePage.addItemstoCart(itemName); 
		cartPage= homePage.goToCart();
		 
		 
 assertEquals(cartPage.getCartItemList().size(), 1,"Number of items in cart didnot match");
	
   }
	
	@Test
	@Parameters({("itemName")})
	public void itemLinkisPresent(String itemName) {
		
		homePage.addItemstoCart(itemName); 
		cartPage= homePage.goToCart();
		Assert.assertTrue(cartPage.itemLinkExists(itemName));
	}
	
	@Test
	@Parameters({("itemName")})
	public void itemDescisPresent(String itemName)
	{
		homePage.addItemstoCart(itemName); 
		cartPage= homePage.goToCart();
		Assert.assertTrue(cartPage.itemDescPresent(itemName));
	}
	
	
	@Test
	@Parameters({("itemName")})
	public void itemPriceBarisPresent(String itemName)
	{
		homePage.addItemstoCart(itemName); 
		cartPage= homePage.goToCart();
		Assert.assertTrue(cartPage.itemPriceBarExists(itemName));
	}

	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}	

}

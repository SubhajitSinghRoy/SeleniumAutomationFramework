package com.Saucedemo.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.CartPage;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;

public class CartPageTestByDataProvider extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	
	 @BeforeMethod
      public void setUp() {
		
		initialization();
		loginPage=new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		}
	
	 @DataProvider (name = "itemName")
	 public static Object[] dpMethod(){
	 return new Object[] {"Sauce Labs Backpack", 
	 		"Sauce Labs Bike Light", 
	 		"Sauce Labs Bolt T-Shirt",
	 		"Sauce Labs Fleece Jacket", 
	 		"Sauce Labs Onesie",
	 		"Test.allTheThings() T-Shirt (Red)"
	 		}   ;
	 }

	
	
	
	@Test
	(dataProvider = "itemName")
	public void itemLinkisPresent(String itemName) {
		
		homePage.addItemstoCart(itemName);
		cartPage= homePage.goToCart();
		//homePage.getProductname();
		cartPage.itemDescPresent(itemName);
		cartPage.itemLinkExists(itemName);
		cartPage.itemPriceBarExists(itemName);
		
		Assert.assertTrue(cartPage.itemLinkExists(itemName));
	}
	
	@Test
	(dataProvider = "itemName")
	public void itemDescisPresent(String itemName)
	{
		homePage.addItemstoCart(itemName);
		cartPage= homePage.goToCart();
		homePage.getProductname();
		cartPage.itemDescPresent(itemName);
		cartPage.itemLinkExists(itemName);
		cartPage.itemPriceBarExists(itemName);
		Assert.assertTrue(cartPage.itemDescPresent(itemName));
	}
	
	
	@Test
	(dataProvider = "itemName")
	public void itemPriceBarisPresent(String itemName)
	{homePage.addItemstoCart(itemName);
	cartPage= homePage.goToCart();
	homePage.getProductname();
	cartPage.itemDescPresent(itemName);
	cartPage.itemLinkExists(itemName);
	cartPage.itemPriceBarExists(itemName);
		
		Assert.assertTrue(cartPage.itemPriceBarExists(itemName));
	}
	
	@Test
	(dataProvider = "itemName")
	public void cartListCheck(String itemName) throws InterruptedException
	{
		homePage.addItemstoCart(itemName);
		cartPage= homePage.goToCart();
		homePage.getProductname();
		cartPage.itemDescPresent(itemName);
		cartPage.itemLinkExists(itemName);
		
 assertEquals(cartPage.getCartItemList().size(), 1,"Number of items in cart didnot match");
	
   }

	@AfterMethod
	void teardown()
	{
		driver.close();
	}
	

}

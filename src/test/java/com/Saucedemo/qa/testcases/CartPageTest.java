package com.Saucedemo.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
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
	
	
	@Test(priority=1, 
				  description = "TestCase 18 : Validation of number of items in Cart Page as per selection in Home Page(data from xml file)") 
	@Parameters({("itemName")})
	public void cartListCheck(String itemName) throws InterruptedException
	{
		homePage.addItemstoCart(itemName); 
		cartPage= homePage.goToCart();
		 
		 
 assertEquals(cartPage.getCartItemList().size(), 1,"Number of items in cart didnot match");
	
   }
	
	
	
	  @Test
		(priority=2, 
		description = "TestCase 19 : Validation of appearance of detail links of items present in the Cart Page(data from xml file)")
	@Parameters({("itemName")})
	public void itemLinkisPresent(String itemName) {
		
		homePage.addItemstoCart(itemName); 
		cartPage= homePage.goToCart();
		Assert.assertTrue(cartPage.itemLinkExists(itemName));
	}
	
	  
	  @Test  
		(priority=3, 
				description = "TestCase 20 : Validation of appearance of price details of items present in the Cart Page(data from xml file)")
		@Parameters({("itemName")})
		public void itemPriceBarisPresent(String itemName)
		{
			homePage.addItemstoCart(itemName); 
			cartPage= homePage.goToCart();
			Assert.assertTrue(cartPage.itemPriceBarExists(itemName));
		}

	  
	  @Test
		(priority=4, 
				description = "TestCase 21 : Validation of presence of item Description in the Cart Page(data from xml file)")  
	@Parameters({("itemName")})
	public void itemDescisPresent(String itemName)
	{
		homePage.addItemstoCart(itemName); 
		cartPage= homePage.goToCart();
		Assert.assertTrue(cartPage.itemDescPresent(itemName));
	}
	
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}	

}

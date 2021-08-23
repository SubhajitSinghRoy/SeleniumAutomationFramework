package com.Saucedemo.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.CartPage;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;

public class CartPageTestByMultipleItem extends TestBase {
	
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
	 public static Object[] dpMethod(){ return new Object[][] {
		  
		  
		  {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Onesie"},
		  {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Onesie"},
		  {"Sauce Labs Bolt T-Shirt","Sauce Labs Onesie"},
		  {"Sauce Labs Backpack","Sauce Labs Bolt T-Shirt","Sauce Labs Onesie"},
		  {"Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Onesie"},
		  {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt"
		  ,"Sauce Labs Onesie"}, {"Sauce Labs Fleece Jacket","Sauce Labs Onesie"},
		  {"Sauce Labs Backpack","Sauce Labs Fleece Jacket","Sauce Labs Onesie"},
		  {"Sauce Labs Bike Light","Sauce Labs Fleece Jacket","Sauce Labs Onesie"},
		  {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Fleece Jacket"
		  ,"Sauce Labs Onesie"}};
		  
		  
		  }
	 
	 @Test(dataProvider = "itemName", priority=1, 
			  description = "TestCase 15 : Validation of number of items in Cart Page as per selection in Home Page(data from same file)") 
			public void cartListCheck(String[] itemName) throws InterruptedException
			{
				int len=itemName.length;
				
				while (len>=1) {
				homePage.addItemstoCart(itemName[len-1]);
				len--;
				}
				cartPage= homePage.goToCart();
			len=itemName.length;
			

			
			Assert.assertEquals(cartPage.getCartItemList().size(), len,"Number of items in cart didnot match");
		   }
	 
	 
	
	 @Test(dataProvider = "itemName" , priority=2, 
		description = "TestCase 16 : Validation of appearance of detail links of items present in the Cart Page(data from same file)")
	public void itemLinkisPresent(String[] itemName) {
		
		
		int len=itemName.length;
		boolean flag= false;
		
		while (len>=1) {
		homePage.addItemstoCart(itemName[len-1]);
		len--;
		}
	cartPage= homePage.goToCart();
	len=itemName.length;
		
		while (len>=1 ) {
		flag = cartPage.itemLinkExists(itemName[len-1]);
		if (flag==false) break;
		else len--;}
		
		Assert.assertTrue(flag);
	}
	
	 
	
	
	@Test  
	(dataProvider = "itemName" , priority=3, 
			description = "TestCase 17 : Validation of appearance of price details of items present in the Cart Page(data from same file)")
public void itemPriceBarisPresent(String[] itemName)
	{
	
		
		int len=itemName.length;
		boolean flag= false;
		
	while (len>=1) {
	homePage.addItemstoCart(itemName[len-1]);
	len--;
		}
		cartPage= homePage.goToCart();
		len=itemName.length;
		
		while (len>=1 ) {
		flag = cartPage.itemPriceBarExists(itemName[len-1]);
		if (flag==false) break;
	    else len--;}
		
		Assert.assertTrue(flag);
	}
	
	
	@Test
	(dataProvider = "itemName" , priority=4, 
			description = "TestCase 18 : Validation of presence of item Description in the Cart Page(data from same file)")
public void itemDescisPresent(String[] itemName)
{
	
	
int len=itemName.length;
	boolean flag= false;
	
	while (len>=1) {
	homePage.addItemstoCart(itemName[len-1]);
	len--;
	}
	cartPage= homePage.goToCart();
	len=itemName.length;
	
	while (len>=1 ) {
	flag = cartPage.itemDescPresent(itemName[len-1]);
	if (flag==false) break;
else len--;}
	
	Assert.assertTrue(flag);
}
	

	@AfterMethod
	void teardown()
	{
		while (!driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
			driver.navigate().back();
		
		for (int i=0;i<cartPage.getCartItemList().size();i++)
		{
			
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
			
		}
		driver.quit();
	}
	

}


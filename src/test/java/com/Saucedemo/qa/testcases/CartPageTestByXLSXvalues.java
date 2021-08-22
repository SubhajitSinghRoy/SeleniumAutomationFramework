package com.Saucedemo.qa.testcases;

import java.io.IOException;

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
import com.saucedemo.qa.util.TestUtil;

public class CartPageTestByXLSXvalues extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	static String sheetName="cartItemNames";
	static String TEST_DATA_PATH="C:\\Users\\User\\Eclipse workspace 2019\\SeleniumAutomationFramework\\"
			+ "src\\main\\java\\com\\saucedemo\\qa\\testData\\ProductNames.xlsx";
	
	
	  @BeforeMethod public void setUp() {
	  
	  initialization(); loginPage=new LoginPage(); homePage=
	  loginPage.login(prop.getProperty("username"),prop.getProperty("password")); }
	
	 
	 @DataProvider
		public Object[][] getdata() throws IOException
		{
		 Object[][] data= TestUtil.getProductName(sheetName,TEST_DATA_PATH);
			return data;
		}
	 
	
	// Test case to verify the presence of all the item links
	@Test
	(dataProvider = "getdata")
	public void itemLinkisPresent(String[] itemName) {
		
	int len=itemName.length;
	boolean flag= false;
	int track=0;
	
	while (track<len ) 
	{
		if (itemName[track]==null) break; 
	homePage.addItemstoCart(itemName[track]);
		track++;
	}
cartPage= homePage.goToCart();
  track=0;
	
	while (track<len) {
		if (itemName[track]==null) break; 
	flag = cartPage.itemLinkExists(itemName[track]);
	if (flag==false) break;
	else track++;}
	
	Assert.assertTrue(flag);}
	
	// Test case to verify the presence of all the item description
	@Test
	(dataProvider = "getdata")
	  public void itemDescisPresent(String[] itemName) {
	  
	  
	  int len=itemName.length; 
	  boolean flag= false;
	  int track=0;
	  
	  while (track<len) { 
		  if (itemName[track]==null) break;
		  homePage.addItemstoCart(itemName[track]); 
		  track++; 
		  }
	  cartPage=homePage.goToCart(); 
		  
		  track=0;
	  
	  while (len>=1 ) {
		  if (itemName[track]==null) break;
		  flag = cartPage.itemDescPresent(itemName[track]);
		  
	  if
	  (flag==false) break; else track++;}
	  
	  Assert.assertTrue(flag); }
	  
	  
	 
	  
	  
	  @Test (dataProvider = "getdata") 
	  public void itemPriceBarisPresent(String[] itemName) {
	  
	  
	  int len=itemName.length; 
	  boolean flag= false;
	  int track=0;
	  
	  while (track<len) { 
		  if (itemName[track]==null) break; 
		  homePage.addItemstoCart(itemName[track]); 
      track++; 
       } 
	  cartPage= homePage.goToCart(); 
	  track=0;
	  
	  while (len>track ) {
		  if (itemName[track]==null) break;
		  flag = cartPage.itemPriceBarExists(itemName[track]); 
		  if (flag==false) break; 
		  else track++;
		  }
	  
	  Assert.assertTrue(flag); 
	  }
	  
	  // Check the presence of accurate number in the Cart List
	
	  @Test (dataProvider = "getdata") public void cartListCheck(String[] itemName)
	  throws InterruptedException {
	  
	  int len=itemName.length; 
	  int track=0; 
	  while (track<len) 
	  {
	  if(itemName[track]==null) break;
	  
	  homePage.addItemstoCart(itemName[track]);
	  track++; 
	  } 
	  cartPage= homePage.goToCart();
	  
	  Assert.assertEquals(cartPage.getCartItemList().size(),(track),"Number of items in cart didnot match");
	  }
	  
	 
	  @AfterMethod void teardown() 
	  { 
		  while
	  (!driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
	  driver.navigate().back();
	  
	  for (int i=0;i<cartPage.getCartItemList().size();i++) {
	  
	  driver.findElement(By.xpath("//button[text()='Remove']")).click();
	  
	  } driver.quit(); 
	  
	  }
	 
	

}


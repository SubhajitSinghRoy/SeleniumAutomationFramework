package com.Yandex.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Yandex.qa.base.TestBase;
import com.Yandex.qa.pages.CartPage;
import com.Yandex.qa.pages.CheckOut;
import com.Yandex.qa.pages.HomePage;
import com.Yandex.qa.pages.LoginPage;
import com.Yandex.qa.util.TestUtil;

public class CheckoutPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOut checkOut;
 String sheetName = "CheckoutInfo";
	
	@BeforeMethod
	void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		cartPage= homePage.addToCart();
		checkOut=cartPage.gotoCheckoutPage();
		
	}
	@Test
	public void validateContinueBtn()
	{
		Assert.assertTrue(checkOut.presentContinue());
	}
	
	@DataProvider
	public Object[][] getdata() throws IOException
	{
		Object[][] data= TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	// 
	@Test(dataProvider = "getdata")
	public void checkoutSuccess(String fname,String lname,String zcode)
	{
	checkOut.addCheckoutInfo(fname, lname, zcode);
	checkOut.clickContinue();
	Assert.assertTrue((driver.getCurrentUrl().contentEquals("https://www.saucedemo.com/checkout-step-two.html")),"url did not match");
	}
	
	@AfterMethod
	void tearDown()
	{
		driver.close();
	}

}

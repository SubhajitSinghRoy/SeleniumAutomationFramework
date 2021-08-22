package com.Saucedemo.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.CartPage;
import com.saucedemo.qa.pages.CheckOut;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.util.TestUtil;

public class CheckoutPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOut checkOut;
 String sheetName = "CheckoutInfo";
 public static String TEST_DATA_PATH = "C:\\Users\\User\\Eclipse workspace 2019\\SeleniumAutomationFramework\\"
			+ "src\\main\\java\\com\\Yandex\\qa\\testData\\TestData.xlsx";
	
	@BeforeMethod
	void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage.addBackPackToCart();
		homePage.addBikeLightToCart();
		cartPage= homePage.goToCart();
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
		Object[][] data= TestUtil.getTestData(sheetName,TEST_DATA_PATH);
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

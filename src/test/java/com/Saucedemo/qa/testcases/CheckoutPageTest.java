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
 public static String TEST_DATA_PATH = System.getProperty("user.dir")+
			"\\src\\main\\java\\com\\saucedemo\\qa\\testData\\TestData.xlsx";
	
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
	
	@Test(description = "TestCase 7 : Continue Button is displayed")
	public void validateContinueBtn()
	{
		Assert.assertTrue(checkOut.getContinueBtn().isDisplayed());
	}
	
	@Test(description = "TestCase 8 : Cancel Button is displayed")
	public void validateCancelBtn()
	{
		Assert.assertTrue(checkOut.getCancelBtn().isDisplayed());
	}
	
	@DataProvider
	public Object[][] getdata() throws IOException
	{
		Object[][] data= TestUtil.getTestData(sheetName,TEST_DATA_PATH);
		return data;
	}
	
	
	@Test(dataProvider = "getdata",
			description = "TestCase 9 : Validate page flow after entering user details and clicking Continue")
	public void checkoutSuccess(String fname,String lname,String zcode)
	{
	checkOut.addCheckoutInfo(fname, lname, zcode);
	checkOut.clickContinue();
	Assert.assertTrue((driver.getCurrentUrl().contentEquals("https://www.saucedemo.com/checkout-step-two.html")),"url did not match");
	}
	
	
	@Test(description = "TestCase 10 : Validate movement to previous page after clicking Cancel")
	public void cancelBtnWorking()
	{
	checkOut.getCancelBtn().click();
	Assert.assertTrue((driver.getCurrentUrl().contentEquals("https://www.saucedemo.com/cart.html")),"url did not match");
	}
	
	@AfterMethod
	void tearDown()
	{
		driver.close();
	}

}

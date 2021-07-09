package com.Yandex.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Yandex.qa.base.TestBase;

public class CartPage extends TestBase {

	
	public CartPage ()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "checkout")
	WebElement checkOutLink;
	
	public CheckOut gotoCheckoutPage()
	{
		
		Actions action=new Actions(driver);
		action.moveToElement(checkOutLink);
		action.perform();
		checkOutLink.click();
		return new CheckOut();
	}


}

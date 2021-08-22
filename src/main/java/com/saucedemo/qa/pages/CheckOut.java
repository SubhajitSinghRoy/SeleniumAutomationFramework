package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class CheckOut extends TestBase {
	
	@FindBy(id = "first-name")
	WebElement firstName;
	
	@FindBy(id ="last-name")
	WebElement lastName;
	
	@FindBy(id ="postal-code")
	WebElement postalCode;
	
	@FindBy(id ="continue")
	WebElement continueBtn;
	
	@FindBy(id="cancel")
	WebElement cancelBtn;
	
	public WebElement getContinueBtn() {
		return continueBtn;
	}



	public WebElement getCancelBtn() {
		return cancelBtn;
	}



	public ContinuePage clickContinue()
	{

		continueBtn.click();
		return new ContinuePage();
	}
	

	
	public CheckOut()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void addCheckoutInfo(String fn,String ln,String pc)
	{
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		postalCode.sendKeys(pc);
	}
}

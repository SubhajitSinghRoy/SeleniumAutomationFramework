package com.Yandex.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Yandex.qa.base.TestBase;

public class CheckOut extends TestBase {
	
	@FindBy(id = "first-name")
	WebElement firstName;
	
	@FindBy(id ="last-name")
	WebElement lastName;
	
	@FindBy(id ="postal-code")
	WebElement postalCode;
	
	@FindBy(id ="continue")
	WebElement continueBtn;
	
	public ContinuePage clickContinue()
	{
		Actions action=new Actions(driver);
		action.moveToElement(continueBtn);
		action.perform();
		continueBtn.click();
		return new ContinuePage();
	}
	
	public boolean presentContinue()
	{
		Actions action=new Actions(driver);
		action.moveToElement(continueBtn);
		action.perform();
		return continueBtn.isDisplayed();
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

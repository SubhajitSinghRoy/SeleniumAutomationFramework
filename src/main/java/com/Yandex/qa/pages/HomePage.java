package com.Yandex.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Yandex.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")
	WebElement addBackPack;
	
	@FindBy(xpath="/html/body/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/button")
	WebElement addBikeLight ;
	
	
	@FindBy(xpath="/html/body/div/div/div/div[1]/div[1]/div[3]/a")
	WebElement cartLink ;
	
	@FindBy(xpath="/html/body/div/div/div/div[2]/div/div/div/div[1]/div[1]/a/img")
	WebElement backPackLink ;

	public CartPage addToCart()
	{
		cartLink.click();
		return new CartPage();
	}
	
	public void addBackPackToCart()
	{
		addBackPack.click();
	}
	
	public void addBikeLightToCart()
	{
		addBikeLight.click();
	}
	
	public backPackPage backPackPageDetails()
	{
		return new backPackPage();
	}
	
	public HomePage ()
	{
		PageFactory.initElements(driver, this);
		
	}
	
}

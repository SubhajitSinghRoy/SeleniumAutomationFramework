package com.saucedemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.saucedemo.qa.base.TestBase;

public class HomePage extends TestBase {
	
	String Productname = prop.getProperty("item");
	
	public String getProductname() {
		return Productname;
	}

	@FindBy(xpath="//button[@name=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement addBackPack;
	
	@FindBy(xpath="//button[@name=\"add-to-cart-sauce-labs-bike-light\"]")
	WebElement addBikeLight ;
	
	
	@FindBy(xpath="//a[@class=\"shopping_cart_link\"]")
	WebElement cartLink ;
	
	@FindBy(xpath="//img[@alt=\"Sauce Labs Backpack\"]")
	WebElement backPackLink ;


	public CartPage goToCart()
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
	
	
	public void addItemstoCart(String itemname)
	{
		
		
		String thexpath= "//div[text()=\""
				+ itemname
				+ "\"]//parent::a//parent::div//following-sibling::div[@class=\"pricebar\"]//button[text()=\"Add to cart\"]";
		
		driver.findElement(By.xpath(thexpath)).click();
		
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

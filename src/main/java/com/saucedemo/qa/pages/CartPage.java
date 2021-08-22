package com.saucedemo.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class CartPage extends TestBase {
	
	
	@FindBy(id = "checkout")
	WebElement checkOutLink;
	
	@FindBy(xpath = "//div[@class=\"cart_item\"]")
	List<WebElement> cartItemList;
	
		
	public CartPage ()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean itemDescPresent(String itemname ) {
		
		WebElement itemDesc=driver.findElement(By.xpath("//div[text()=\""
				+ itemname
				+ "\"]//parent::a//following-sibling::div"));
		
		
		return itemDesc.isDisplayed();
		
		
	}
	
	
	public boolean itemPriceBarExists(String itemname)
	{
		WebElement itemPriceBar=driver.findElement(By.xpath("//div[text()=\""
                +itemname
				+ "\"]//parent::a//parent::div//following-sibling::div[@class=\"item_pricebar\"]"));
		
		
		return itemPriceBar.isDisplayed();	
	}
	
	
	
	public boolean itemLinkExists(String itemname ) {
		
		WebElement itemLinkExists=driver.findElement(By.xpath("//div[text()=\""
				+ itemname
				+ "\"]//parent::a"));
	return itemLinkExists.isDisplayed();
	}
	
	public List<WebElement> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<WebElement> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public CheckOut gotoCheckoutPage()
	{
		
		Actions action=new Actions(driver);
		action.moveToElement(checkOutLink);
		action.perform();
		checkOutLink.click();
		return new CheckOut();
	}



}

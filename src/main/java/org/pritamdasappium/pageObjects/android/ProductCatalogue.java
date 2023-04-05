package org.pritamdasappium.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pritamdasappium.utils.AndroidActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions{
	
AppiumDriver driver;
	
	public ProductCatalogue(AppiumDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	
	
	public void addItemToCartByIndex(int index) {
		addToCart.get(index).click();
	}
	
	public void goToCartPage() throws InterruptedException {
		cart.click();
		Thread.sleep(3000);
	}

}

package org.pritamdasappium.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pritamdasappium.utils.AndroidActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{

AppiumDriver driver;
	
	public  CartPage(AppiumDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement terms;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement acceptButton;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;
	
	public List<WebElement> getProductList(){
		return productList;
	}
	
	public double getProductsSum() {
		int count  = productList.size();
		double totalSum = 0;
		for(int i =0; i < count; i++) {
			String amountString = productList.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;
		}
		return totalSum;
	}

	public double getFormattedAmount(String amountString) {
		// TODO Auto-generated method stub
		double price = Double.parseDouble(amountString.substring(1));
		return price;
	}
	
	public double getTotalAmountDisplayed() {
		return getFormattedAmount(totalAmount.getText());
	}
	
	public void acceptTermsConditions() {
		longPressAction(terms);
		acceptButton.click();
	}
	
	public void submitOrder() {
		checkBox.click();
		proceed.click();
	}

}

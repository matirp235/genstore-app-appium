package org.pritamdasappium;

import org.pritamdasappium.pageObjects.android.CartPage;
import org.pritamdasappium.pageObjects.android.FormPage;
import org.pritamdasappium.pageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerceTestCaseThree  extends BaseTest {
	
	@Test
	public void FillForm() throws InterruptedException {
		
		FormPage formPage = new FormPage(driver);
		formPage.setNameField("Pritam Das");
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		formPage.submitForm();
		Thread.sleep(3000);
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.goToCartPage();
		
		//explicit wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		Thread.sleep(2000);
		
		CartPage cartPage = new CartPage(driver);
		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	}

}

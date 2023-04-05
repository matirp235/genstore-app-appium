package org.pritamdasappium.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pritamdasappium.utils.AndroidActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	
	AppiumDriver driver;
	
	public FormPage(AppiumDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pritam Das");
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
//	driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	@AndroidFindBy(id = "android:id/text1")
	private WebElement clickCountrySelection;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
	}
	
	public void setGender(String gender) {
		if(gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}
	
	public void setCountry(String country) {
		clickCountrySelection.click();
		
	}
	public void setCountrySelection(String countryName) {
		clickCountrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("android.widget.TextView[@text='"+countryName+"']")).click();
	}
	public void submitForm() {
		shopButton.click();
	}
	
	
	
	

}

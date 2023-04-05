package org.pritamdasappium.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class AndroidActions {
	
	AppiumDriver driver;
	
	public void AndroidAction(AppiumDriver driver) {
		this.driver = driver;
	}
	
	
	 public void longPressAction(WebElement ele) {
	        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
	                "elementId", ((RemoteWebElement) ele).getId(),
	                "duration", 2000
	        ));
	 }
	 
	 public void scrollToText(String text) {
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+ text+"\"))"));
	 }

}

package org.pritamdasappium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AppiumDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, InterruptedException {
	
//	code to start the server
	AppiumDriverLocalService service = new AppiumServiceBuilder()
			.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
			.withIPAddress("0.0.0.0")
			.usingPort(4724)
			.build();
//	service.start();

	UiAutomator2Options options = new UiAutomator2Options();
	options.setDeviceName("Pixel5");
	options.setApp("//Users//pritamdas//Work//Learning//Appium//eCommerceApp//src//test//java//resources//General-Store.apk");
	//Android driver
	 driver = new AndroidDriver(new URL("http://0.0.0.0:4724"), options);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 Thread.sleep(5000); // to manually grant permission
	 System.out.println("Initial setup done!!");
	}
	
	//for converting the amount with dollar to calculate
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
//		service.stop();
	}
}
	

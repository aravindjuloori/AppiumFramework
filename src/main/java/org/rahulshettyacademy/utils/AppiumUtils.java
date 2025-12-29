package org.rahulshettyacademy.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {
	
AppiumDriver driver;
	
	public AppiumUtils(AppiumDriver driver) {
		this.driver=driver;
	}
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;

	}
	
	public void waitForElementtoAppear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.attributeContains
				 (driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
	}
	

}

package org.rahulshettyacademy.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	public AppiumDriverLocalService service;
	

	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;

	}

	public void waitForElementtoAppear(WebElement ele,AppiumDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
	}

	public AppiumDriverLocalService startAppiumServer(String ipAddress,int port) {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Aravind\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();

		service.start(); // To start appium server
		return service;
	}
	
	public String getScreenshotPath(String testCaseName,AppiumDriver driver) throws IOException {
		
	File source=driver.getScreenshotAs(OutputType.FILE);
	
	String destinationFile=System.getProperty("user.dir")+"//reports"+testCaseName+".png";
	
	FileUtils.copyFile(source, new File (destinationFile));
	return destinationFile;
	
	//1.capture the screenshot in the folder 2.
	}
	
	
	

}

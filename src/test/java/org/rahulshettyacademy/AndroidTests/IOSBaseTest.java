package org.rahulshettyacademy.AndroidTests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.rahulshettyacademy.PageObjects.iOS.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {
	
	public AppiumDriverLocalService service;
	public IOSDriver driver;
	public HomePage homePage;
	
	@BeforeClass
	public void IosconfigureAppium() throws MalformedURLException {
		
		 service=new AppiumServiceBuilder().
				withAppiumJS(new File("C:\\Users\\Aravind\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		service.start();
		
		XCUITestOptions options=new XCUITestOptions();
		options.setDeviceName("iPhone 13 Pro");
		options.setApp("");
		options.setPlatformName("iOS");
		options.setPlatformVersion("15.5");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		
		URL appiumServerurl=URI.create("http://127.0.0.1:4723").toURL();		
		 driver=new IOSDriver(appiumServerurl,options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage=new HomePage(driver);
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		service.stop();
		
	}

}

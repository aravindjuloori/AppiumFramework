package org.rahulshettyacademy.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.rahulshettyacademy.PageObjects.iOS.HomePage;
import org.rahulshettyacademy.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest extends AppiumUtils {
	
	public AppiumDriverLocalService service;
	public IOSDriver driver;
	public HomePage homePage;
	
	@BeforeClass
	public void IosconfigureAppium() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//rahulshettyacademy//resources//data.properties");
		prop.load(fis);
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		
		service=startAppiumServer(ipAddress,Integer.parseInt(port));
		
		XCUITestOptions options=new XCUITestOptions();
		options.setDeviceName("iPhone 13 Pro");
		options.setApp("");
		options.setPlatformName("iOS");
		options.setPlatformVersion("15.5");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		
		URL appiumServerurl=service.getUrl();		
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

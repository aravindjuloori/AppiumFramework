package org.rahulshettyacademy.utils;

import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils{
	
IOSDriver driver;
	
	public IOSActions(IOSDriver driver) {
		super(driver);
		this.driver=driver;
	}
	

}

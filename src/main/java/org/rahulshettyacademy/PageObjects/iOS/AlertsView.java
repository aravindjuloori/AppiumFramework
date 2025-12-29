package org.rahulshettyacademy.PageObjects.iOS;

import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.IOSActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AlertsView extends IOSActions {

IOSDriver driver;
	
	public AlertsView(IOSDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
}

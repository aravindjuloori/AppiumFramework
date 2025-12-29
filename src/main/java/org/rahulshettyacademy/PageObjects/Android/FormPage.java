package org.rahulshettyacademy.PageObjects.Android;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Aravind Juloori");
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement userNameField;
	
	
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleRadioButton;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleRadioButton;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
		
	public void setActivity() {
		Activity activity=new Activity("com.androidsample.generalstore","com.androidsample.generalstore.SplashActivity");
		 ((JavascriptExecutor) driver).executeScript("mobile: startActivity" ,
				  ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
		
	}
	public void setNameField(String name) {
		userNameField.sendKeys(name);
		driver.hideKeyboard();	
	}
	
	public void setGender(String gender) {
		
		if(gender.contains("female")) 
			femaleRadioButton.click();
			else
				maleRadioButton.click();
		
	}
	
	public void setCountrySelection(String countryName) {
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	public ProductCatalogPage submitForm() {
		shopButton.click();
		return new ProductCatalogPage(driver);
		
	}
	

}

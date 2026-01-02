package org.rahulshettyacademy.AndroidTests;


import org.openqa.selenium.JavascriptExecutor;
import org.rahulshettyacademy.PageObjects.Android.CartPage;
import org.rahulshettyacademy.PageObjects.Android.ProductCatalogPage;
import org.rahulshettyacademy.TestUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;

public class Ecommerce_tc3_hybrid extends AndroidBaseTest {
	
	
	@Test(dataProvider="getData" ,groups={"Smoke"})
	public void fillform(String name,String Gender,String country) throws InterruptedException {
			
		formPage.setNameField(name);
		formPage.setGender(Gender);
		formPage.setCountrySelection(country);
		ProductCatalogPage productcatalog=formPage.submitForm();
		
		productcatalog.addItemToCartByIndex(0);
		productcatalog.addItemToCartByIndex(0);
		CartPage cartPage=productcatalog.goToCartPage();
		
		
		double totalSum= cartPage.getProductSum();
		double displayFormattedsum=cartPage.getTotalAmountDisplayed();
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.attributeContains(
		 * driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),
		 * "text", "Cart"));
		 */
		Assert.assertEquals(totalSum, displayFormattedsum);
		
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	}
	
	
	@BeforeMethod
	public void preSetup() {
		formPage.setActivity();
	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		return new Object[][] {{"Aravind ","female","Argentina"}};
		
	}
}

package org.rahulshettyacademy.AndroidTests;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.rahulshettyacademy.PageObjects.Android.CartPage;
import org.rahulshettyacademy.PageObjects.Android.FormPage;
import org.rahulshettyacademy.PageObjects.Android.ProductCatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecommerce_tc3_hybrid extends BaseTest {

	@Test
	public void fillform() throws InterruptedException {
		
		//FormPage formPage=new FormPage(driver);
		
		/*
		 * driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).
		 * sendKeys("Aravind Juloori"); driver.hideKeyboard();
		 * driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		 * driver.findElement(By.id("android:id/text1")).click();
		 * driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
				driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		 */
		
		formPage.setNameField("Aravind Juloori");
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		ProductCatalogPage productcatalog=formPage.submitForm();
		
		productcatalog.addItemToCartByIndex(0);
		productcatalog.addItemToCartByIndex(0);
		CartPage cartPage=productcatalog.goToCartPage();
		
		

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.attributeContains(
		 * driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),
		 * "text", "Cart"));
		 */
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));

		int count = productPrices.size();
		double totalSum = 0;
		for (int i = 0; i < count; i++) {

			String amountString = productPrices.get(i).getText();
			// $160.00
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;
		}

		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

		Double displayFormattedsum = getFormattedAmount(displaySum);

		Assert.assertEquals(totalSum, displayFormattedsum);
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);

		String alertTitle = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "Terms Of Conditions");

		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		/*
		 * Thread.sleep(6000);
		 * 
		 * Set<String> contexts=driver.getContextHandles();
		 * 
		 * for(String ContextName:contexts) { System.out.println(ContextName); }
		 * 
		 * driver.context("WEBVIEW_com.androidsample.generalstore");
		 * driver.findElement(By.name("q")).sendKeys("Rahul shetty Academy");
		 * driver.findElement(By.name("q")).sendKeys(Keys.ENTER); driver.pressKey(new
		 * KeyEvent(AndroidKey.BACK));
		 * 
		 */

	}
}

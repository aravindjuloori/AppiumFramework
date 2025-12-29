package org.rahulshettyacademy.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.rahulshettyacademy.PageObjects.Android.FormPage;
import org.rahulshettyacademy.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumUtils {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;

	@BeforeClass
	public void configureAppium() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//org//rahulshettyacademy//resources//data.properties");
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");

		service = startAppiumServer(ipAddress, Integer.parseInt(port));

		// Setting the Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		// options.setDeviceName("10BE1Y0BZM0012Y");
		options.setDeviceName("AravindEmulator");
		options.setPlatformName("Android");
		// options.setChromedriverExecutable("C:\\Users\\Aravind\\git\\Appium\\Appium\\src\\test\\java\\resources\\chromedriver.exe");

		// options.setApp(System.getProperty("user.dir")+"//src//test//java//org//rahulshettyacademy//resources//ApiDemos-debug.apk");
		options.setApp(System.getProperty("user.dir")+"//src//test//java//org//rahulshettyacademy//resources//General-Store.apk");

		options.setAutoGrantPermissions(true);
		options.setNoReset(false);

		// Android device or ios device
		// appium code --> appium server
		URL appiumServerUrl = service.getUrl();
		driver = new AndroidDriver(appiumServerUrl, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		formPage = new FormPage(driver);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop(); // to stop the appium server

	}

}

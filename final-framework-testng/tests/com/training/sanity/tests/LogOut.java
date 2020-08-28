package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LogOutPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LogOut {

	private WebDriver driver;
	private String baseUrl;
	private LogOutPOM logoutPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		logoutPOM = new LogOutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		
	}
	
	/*@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/
		
	@Test
	public void verifyCourseList() throws InterruptedException {
		logoutPOM.sendUserName("tambi");
		logoutPOM.sendPassword("tambi123");
		logoutPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		Thread.sleep(2000);
		logoutPOM.clickUser(); 
		Thread.sleep(1000);
		logoutPOM.clickLogOut(); 
						
		
	    }
				
}

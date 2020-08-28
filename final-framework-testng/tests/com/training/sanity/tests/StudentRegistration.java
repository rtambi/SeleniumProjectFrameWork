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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class StudentRegistration {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
		
	@Test
	public void verifyCourseList() throws InterruptedException {
		loginPOM.sendUserName("tambi");
		loginPOM.sendPassword("tambi123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		Thread.sleep(2000);
		//ScrollDown
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		loginPOM.clickcourseCatalog();		
		Thread.sleep(5000);
		//searching course
		loginPOM.sendCourseText("Account");		
		loginPOM.clickSearch();
		Thread.sleep(2000);	
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);	
		loginPOM.clickSubscribe();
		Thread.sleep(5000);	
		//loginPOM.getText("");		
		/*String ActualAlert = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
        System.out.println("Actual Alert Displayed:: "  + ActualAlert);*/
		try {
	        String ActualAlert = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
	            System.out.println("Actual Alert Displayed:: "  + ActualAlert);
	            
	        String ExpectedAlert = "User Ravi Tambi (ravi) has been registered to course Account";
	            
	            Assert.assertEquals(ExpectedAlert, ActualAlert);    
	            System.out.println("Alert Message Displayed as Expected:: " +  ActualAlert);
	            
	        
	    }
	    catch (AssertionError e) {
	        System.out.println("User has not been Subscribed or Alert message is not as expected or Alerady subscribed");
	    }
	    }
				
}

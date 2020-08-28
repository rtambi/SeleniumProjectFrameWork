package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MyCoursePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MyCourse {

	private WebDriver driver;
	private String baseUrl;
	private MyCoursePOM myCoursePOM;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		myCoursePOM = new MyCoursePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
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
		myCoursePOM.sendUserName("tambi");
		myCoursePOM.sendPassword("tambi123");
		myCoursePOM.clickLoginBtn(); 
		//myCoursePOM.clickMycourse();
		Actions act = new Actions(driver);
		WebElement Mycourse=driver.findElement(By.xpath("//a[@title='My courses']"));
        act.moveToElement(Mycourse).click().build().perform();
		Thread.sleep(2000);
		//myCoursePOM.clickSbcourse();
    	WebElement sbcourse=driver.findElement(By.xpath("//h4[@class='course-items-title']//a[contains(text(),'123testing')]"));
        act.moveToElement(sbcourse).click().perform();           
		Thread.sleep(2000);
		//myCoursePOM.clickDescription();		
		WebElement Description=driver.findElement(By.xpath("//a[@id='tooldesc_1742']"));
        act.moveToElement(Description).click().perform();
		//screenShot.captureScreenShot("First");
		Thread.sleep(2000);				
		
	    }
				
}

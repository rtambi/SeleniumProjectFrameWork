package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCoursePOM {
	public MyCoursePOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
		
	@FindBy(xpath="(//a[@title='My courses']")
	private WebElement Mycourse;
		
	@FindBy(xpath="(//h4[@class='course-items-title'])[1]")
	private WebElement Sbcourse;
	
	@FindBy(xpath="(//*[@id='istooldesc_23208']")
	private WebElement Description;
			
	public void clickMycourse() {
		this.Mycourse.click();
	}
	public void clickSbcourse() {
		this.Sbcourse.click();
	}
	public void clickDescription() {
		this.Description.click();
	}
		
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}	
		
	/*public void alert() {
		this.courseCatalog.getText();
	}*/
	
}

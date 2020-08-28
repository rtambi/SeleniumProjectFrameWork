package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	public LoginPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(linkText="Course catalog")
	private WebElement courseCatalog;
	
	@FindBy(className="form-control")
	private WebElement courseText;
	
	@FindBy(xpath="//button[contains(@class, 'btn btn-default')]")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[@title='Subscribe']")
	private WebElement SubscribeBtn;
	
	/*@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement alert;*/
	
		
	public void clickSubscribe() {
		this.SubscribeBtn.click();
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
	
	public void clickcourseCatalog() {
		this.courseCatalog.click();
	}
	public void sendCourseText(String text)
	{
		this.courseText.clear();
		this.courseText.sendKeys(text);
		
	}
	public void clickSearch() {
		this.searchBtn.click();
	}

	/*public void alert() {
		this.courseCatalog.getText();
	}*/
	
}

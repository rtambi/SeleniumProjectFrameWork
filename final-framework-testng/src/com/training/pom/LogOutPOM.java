package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPOM {
	public LogOutPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
		
	@FindBy(xpath="(//img[@class='img-circle'])[1]")
	private WebElement user;
	
	@FindBy(xpath="//*[@id=\"logout_button\"]")	
			
	private WebElement logoutBtn;		
		
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
	public void clickUser() {
		this.user.click(); 
	}
	public void clickLogOut() {
		this.logoutBtn.click(); 
	}
	}

	
	


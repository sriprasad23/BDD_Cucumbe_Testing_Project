package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//1. By Locators
	
	private By emailId = By.xpath("//input[@name='uid']");
	private By password = By.xpath("//input[@name='password']");
	private By signInButton = By.xpath("//input[@name='btnLogin']");
	private By forgotPwdLink = By.xpath("//input[@name='btnReset']");
	
	// 2. Constructor of the page class
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	// 3. Page actions: features(behavior) of the page the form of methods:
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();                                       // isDisplayed();
		
	}
	
	 public void enterUserName(String username) {
		 driver.findElement(emailId).sendKeys(username);
	 }
	 
	 public void enterPassword(String pwd) {
		 driver.findElement(password).sendKeys(pwd);
	 }
	 
	 public void clickOnLogin() {
		 driver.findElement(signInButton).click();
	 }
	
public ManagerPage doLogin(String un, String pwd) {
		 
		 System.out.println("login with: "+un + "and" +pwd);
		 driver.findElement(emailId).sendKeys(un);
		 driver.findElement(password).sendKeys(pwd);
		 driver.findElement(signInButton).click();
		 return new ManagerPage(driver);
	 }
	
	
}

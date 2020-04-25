package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModel {
	
	public WebDriver driver;
	
	@FindBy(xpath="//*[@title=\"Log in to your customer account\"]")
	WebElement LoginPage;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="passwd")
	WebElement Password;
	
	@FindBy(id="SubmitLogin")
	WebElement Submit;
	
	public PageObjectModel(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void setLoginPage() {
		LoginPage.click();
	}
	
	public void setUsername(String email) {
		Email.sendKeys(email);
	}
	
	public void setPassword(String password) {
		Password.sendKeys(password);
	}
	
	public void clickSubmit() {
		Submit.click();
	}
}
package com.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver ldriver;
	
	public Loginpage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="uid")
	WebElement Username;
	@FindBy(name="password")
	WebElement Password;
	@FindBy(name="btnLogin")
	WebElement Loginbtn;
	@FindBy(name="btnReset")
	WebElement Reset;
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logout;
	
	
	public void setusername(String uname)
	{
		Username.sendKeys(uname);
	}
	public void setpassword(String pwd) {
		Password.sendKeys(pwd);
	}
	public void clicksubmit() {
		Loginbtn.click();
	}
	public void clcklogout() {
		logout.click();
	}

}

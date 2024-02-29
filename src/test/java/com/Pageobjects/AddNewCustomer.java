package com.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	WebDriver ldriver;
	
	public AddNewCustomer(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(how=How.XPATH, using="//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkAddcustomer;
	
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement txtcustomername;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdbGender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement txtpincode;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txttelephonenumber;
	
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement btnsubmit;
	
	@FindBy(how=How.NAME,using="res")
	@CacheLookup
	WebElement btnreset;
	
	
	public void clickAddcustomer() {
		lnkAddcustomer.click();
	}
	
	public void custname(String name) {
		txtcustomername.sendKeys(name);
	}
	
	public void custgender(String gender) {
		rdbGender.click();
	}
	public void custdob(String dd,String mm,String yy) {
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String address) {
		txtaddress.sendKeys(address);
	}
	
	public void custcity(String city) {
		txtcity.sendKeys(city);
	}
	 
	public void custstate(String state) {
		txtstate.sendKeys(state);
	}
	
	public void custpincode(String pincode) {
		txtpincode.sendKeys(String.valueOf(pincode));
	}
	
	public void custtelephoneno(String teleno) {
		txttelephonenumber.sendKeys(String.valueOf(teleno));
	}
	
	public void custemaiid(String email) {
		txtemailid.sendKeys(email);
	}
	
	public void custpassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void submit() {
		btnsubmit.click();
	}

}

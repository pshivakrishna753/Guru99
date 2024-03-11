package com.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Pageobjects.AddNewCustomer;
import com.Pageobjects.Loginpage;

public class TC_AddNewCustomer_003 extends Base {
	
	@Test
	public void addnewcustomer() throws  IOException {
		Loginpage lp=new Loginpage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clicksubmit();
		
		logger.info("login completed");
		
		//Thread.sleep(3000);
		
		AddNewCustomer addcust=new AddNewCustomer(driver);
		addcust.clickAddcustomer();
		addcust.custname("shiva");
		addcust.custgender("male");
		addcust.custdob("26","04","1993");
		//Thread.sleep(3000);
		addcust.custaddress("warangal");
		addcust.custcity("Warangal");
		addcust.custstate("Telanagana");
		addcust.custpincode("506002");
		addcust.custtelephoneno("9876543212");
		String email=randomstring()+"@gmail.com";
		addcust.custemaiid(email);
		addcust.custpassword("abcd@123");
		addcust.submit();
		
		//Thread.sleep(3000);
		
		boolean result=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result==true) {
			Assert.assertTrue(true);
		}
		else {
			capturedscreen(driver,"addnewcustomer");
			Assert.assertTrue(false);
		}
		
	}

}

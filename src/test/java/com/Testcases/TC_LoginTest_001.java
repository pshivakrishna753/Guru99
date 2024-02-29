package com.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Pageobjects.Loginpage;

public class TC_LoginTest_001 extends Base {
	
	@Test
	public void logintest() throws IOException {
		
		logger.info("URL Opened");
		
		Loginpage lp=new Loginpage(driver);
		lp.setusername(username);
		logger.info("Username entered");
		lp.setpassword(password);
		logger.info("Password enetered");
		lp.clicksubmit();
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}else {
			capturedscreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}

}

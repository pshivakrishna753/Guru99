package com.Testcases;




import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Pageobjects.Loginpage;
import com.Utility.XLUtility;

public class TC_LoginDDT_002 extends Base {
	
	@Test(dataProvider="Logindata")
	public void loginDDT(String user,String pwd) throws InterruptedException {
		
		Loginpage lp=new Loginpage(driver);
		lp.setusername(user);
		logger.info("Username is entered");
		lp.setpassword(pwd);
		logger.info("password is entered");
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		if(IsAlertPresent()==true) {
			Thread.sleep(3000);
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login test failed");
		}
		else
		{
			Assert.assertTrue(true);
			lp.clcklogout();
			Thread.sleep(8000);
			
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("login passed");
			
		}
	}
	
	public boolean IsAlertPresent() {   // user defined method is use to check Alert is present or not
		
		try{
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	@DataProvider(name="Logindata")
	public String[][] getdata() throws IOException {
		
		String pt=System.getProperty("user.dir")+"/src/test/java/Testdata/Logindata.xlsx";
		int rownum=XLUtility.getRowCount(pt,"Sheet1");
		int cellnum=XLUtility.getCellCount(pt, "Sheet1", 1);
		String logindata[][]=new String[rownum][cellnum];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<cellnum;j++) {
				logindata[i-1][j]=XLUtility.getCellData(pt,"Sheet1", i,j);
			}
		}
		
		return logindata;
	}

}

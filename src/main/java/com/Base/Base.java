package com.Base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Utility.Readconfig;

public class Base {
	
	Readconfig readconfig=new Readconfig();
	
	public String Baseurl=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br) throws Exception {
		
				
		logger=Logger.getLogger("Gkartgreen");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver=new FirefoxDriver();
		}else if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver=new ChromeDriver();
		}else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIepath());
			driver=new InternetExplorerDriver();
		}else if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getedgepath());
			EdgeOptions opt=new EdgeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver=new EdgeDriver(opt);
		}
		driver.get(Baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@AfterClass
	public void TearDown() {
		// quite is used close the automation executoin
		driver.quit();
	}
	public void capturedscreen(WebDriver driver,String tname)throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot Taken");
	}
	
	public String randomstring() {
		String randomstring=RandomStringUtils.randomAlphabetic(8);
		return randomstring;
	}
	
	public String randomnumber() {
		String randomno=RandomStringUtils.randomNumeric(10);
		return randomno;
	}

}

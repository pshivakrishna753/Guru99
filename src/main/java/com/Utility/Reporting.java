package com.Utility;

//Listener class used to generate reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext)

	{

	String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String repNane="Test-Report-"+timestamp+".html";
	htmlreporter=new ExtentHtmlReporter("C:\\Users\\shiva\\eclipse-workspace\\SeleniumPOMGkartgreen"+"/reports/"+repNane);
	htmlreporter.loadXMLConfig("C:\\Users\\shiva\\eclipse-workspace\\SeleniumPOMGkartgreen" + "/extent-config.xml");

	 

	extent=new ExtentReports();

	extent.attachReporter(htmlreporter);
	extent.setSystemInfo("Host Name", "LocalHost");
	extent.setSystemInfo("Environment","QA");
	extent.setSystemInfo("User Name", "shiva");

	 

	htmlreporter.config().setDocumentTitle("Gkartgreen"); // Tile of report
	htmlreporter.config().setReportName("Functional Test Report"); // name of the report
	htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
	htmlreporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onTestSuccess(ITestResult tr)
	{

	logger=extent .createTest(tr.getName()); // create new entry in th report
	logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); 
	}


	public void onTestFailure1(ITestResult tr)
	{

	logger=extent.createTest(tr.getName()); // create new entry in th report
	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information |

	 
	String screenshotPath = "C:\\Users\\shiva\\eclipse-workspace\\SeleniumPOMGkartgreen\\Screenshots\\"+tr.getName()+".png";

	File f = new File(screenshotPath);
	
	if(f.exists())
	{
		try {
		
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));

	 
		}
		catch (IOException e) {
		
			e.printStackTrace();
		}
	}	

	}


	public void onTestSkipped(ITestResult tr)

	{
	logger=extent .createTest(tr.getName()); // create new entry in the report
	logger.log(Status.SKIP,MarkupHelper.createLabel (tr.getName(),ExtentColor.ORANGE) );

	}
	@Override
	public void onTestFailure(ITestResult tr)
	{
	logger=extent .createTest(tr.getName()); // create new entry in the report
	logger.log(Status.FAIL,MarkupHelper.createLabel (tr.getName(),ExtentColor.RED)); // send the passed information

	   

	String screenshotPath="C:\\Users\\shiva\\eclipse-workspace\\SeleniumPOMGkartgreen"+ "\\Screenshots\\" + tr.getName()+ ".png";
	File f = new File(screenshotPath);
	if (f.exists())
	{
	try {
	logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
	}
	catch (IOException e) {
		e.printStackTrace();
	}

	}
	}
	}
	



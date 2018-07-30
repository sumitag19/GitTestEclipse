package testCases;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

//import H2DB.ExtentReportsClass;
import applicationModules.ApplicationFunctions;
import config.Config;
import reporting.ExtentReportsClass;
//import driver.Driver;
import reporting.Logs;
import testData.TestData;
import utility.Utils;
//import utility.Utilss;

public class ExtentReport3_0 extends ExtentReportsClass {
//	public class TestCases {	
	
	public ExtentReports extent;
	public ExtentTest logger;
	public ExtentHtmlReporter htmlReporter;
	
	WebDriver oDriver;
	
	public ExtentReport3_0(WebDriver driver){
		this.oDriver=driver;
	}
	
	public ExtentReport3_0(){
			}

//*************************************************	
	@BeforeTest
	public void startReport(){
		Logs logs=new Logs();
		try {
			logs.IntializeLog();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyExtentReport.html");
		//extent.addSystemInfo("Environment","Environment Name")
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", System.getProperty("os.name"));
		extent.setSystemInfo("Environment", System.getProperty("os.version"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
//         extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
        htmlReporter.config().setDocumentTitle("Selenium Test Report");
        htmlReporter.config().setReportName("My Customized Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	}
//*************************************************	
@Test
@Parameters("TESTCASE0001")
//This Test Case will launch Flight application and sign on on Flight application
//public void TESTCASE0001(String str){
public void TESTCASE0001(String str){
	
	Utils utls=new Utils();
	Logs logo=new Logs();
	
	TestData tds=new TestData();
	//ApplicationFunctions afs=new ApplicationFunctions();
	//logger=extent.attachReporter(htmlReporter);
	
	logger = extent.createTest("TESTCASE0001");
	WebDriver oDriver= utls.CreateChromeDriver();
	ApplicationFunctions afs = new 	ApplicationFunctions(oDriver);
	try {
		afs.launchPage("http://newtours.demoaut.com/",oDriver);
		//oDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		} catch (Throwable e) {
		e.printStackTrace();
		}
	
	try {
		//logger.log(LogStatus.PASS, "Browser Launched successfully");
		String imagepath=logo.CaptureScreenShots(oDriver,Config.imagefolderpath);
		logger.log(Status.PASS, "Browser Launched successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + imagepath));
		logo.reportLog("TC001","ST0001","PASSED",oDriver);
	} catch (Exception e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	WebElement signon=utls.CreateElement("signon","ObjectRepository",oDriver);
	System.out.println("Sign On Click issue");
	signon.click();
	
	WebElement uname=utls.CreateElement("username","ObjectRepository",oDriver);
	//TC0001	User_Id
	String temp=tds.fetchdata("TC0001","User_Id");
	uname.sendKeys(temp);
	try {
		logo.reportLog("TC001","ST0002","PASSED",oDriver);
		logger.log(Status.INFO, "User ID entered successfully");
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement pwd=utls.CreateElement("password","ObjectRepository",oDriver);
	//TC0001	User_Id
	temp=tds.fetchdata("TC0001","pwd");
	pwd.sendKeys(temp);
	
	try {
		logger.log(Status.INFO, "Password entered successfully");
		logo.reportLog("TC001","ST0003","FAILED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement login=utls.CreateElement("login","ObjectRepository",oDriver);
	try {
		logger.log(Status.INFO, "Login Button Clicked successfully");
		logo.reportLog("TC001","ST0004","PASSED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	login.click();
	
	try {
		boolean result=utls.findElement("Preference","ObjectRepository",oDriver);
		if(result)
		{
//			String imagepath=logo.CaptureScreenShots(oDriver,Config.imagefolderpath);
			logger.log(Status.PASS, "TESTCASE001 Passed successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
//			logger.log(LogStatus.PASS, "TESTCASE001 Passed successfully");
			logo.reportLog("TC001","ST0005","PASSED",oDriver);
			System.out.println("TC Passed");
		}
		else
		{
			logo.reportLog("TC001","ST0005","FAILED",oDriver);
			System.out.println("TC Failed");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	oDriver.close();
}

@Test
@Parameters("TESTCASE0002")
//public void TESTCASE0002(String str){
	public void TESTCASE0002(String str){
	Utils utls=new Utils();
	Logs logo=new Logs();
	TestData tds=new TestData();
	
	logger = extent.createTest("TESTCASE0002","Wahi Kaam Test 02 mein kar rhe");
	WebDriver oDriver= utls.CreateChromeDriver();
	ApplicationFunctions afs= new ApplicationFunctions();
	try {
		afs.launchPage("http://newtours.demoaut.com/",oDriver);
		//oDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		} catch (Throwable e) {
		e.printStackTrace();
		}
	
	try {
		logger.log(Status.PASS, "Browser Launched Successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
		logo.reportLog("TC001","ST0001","PASSED",oDriver);
	} catch (Exception e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	WebElement signon=utls.CreateElement("signon","ObjectRepository",oDriver);
	System.out.println("Sign On Click issue");
	signon.click();
	
	WebElement uname=utls.CreateElement("username","ObjectRepository",oDriver);
	//TC0001	User_Id
	String temp=tds.fetchdata("TC0001","User_Id");
	uname.sendKeys(temp);
	try {
		logo.reportLog("TC001","ST0002","PASSED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement pwd=utls.CreateElement("password","ObjectRepository",oDriver);
	//TC0001	User_Id
	temp=tds.fetchdata("TC0001","pwd");
	pwd.sendKeys(temp);
	
	try {
		logo.reportLog("TC001","ST0003","FAILED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement login=utls.CreateElement("login","ObjectRepository",oDriver);
	try {
		logo.reportLog("TC001","ST0004","PASSED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	login.click();
	
	try {
		boolean result=utls.findElement("Preference","ObjectRepository",oDriver);
		if(result)
		{
			//logger.log(LogStatus.PASS, "TESTCASE002 Passed successfully");
			logger.log(Status.PASS, "TESTCASE002 Passed successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
			logo.reportLog("TC001","ST0005","PASSED",oDriver);
			System.out.println("TC Passed");
		}
		else
		{
			logo.reportLog("TC001","ST0005","FAILED",oDriver);
			System.out.println("TC Failed");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	oDriver.close();
}
@Test
@Parameters("TESTCASE0003")
//public void TESTCASE0003(String str){
	public void TESTCASE0003(String str){
	Utils utls=new Utils();
	Logs logo=new Logs();
	TestData tds=new TestData();
	
	logger = extent.createTest("TESTCASE0003","Third Test Starts Here");
	WebDriver oDriver= utls.CreateChromeDriver();
	ApplicationFunctions afs= new ApplicationFunctions();
	try {
		afs.launchPage("http://newtours.demoaut.com/",oDriver);
		//oDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		} catch (Throwable e) {
		e.printStackTrace();
		}
	
	try {
		logo.reportLog("TC001","ST0001","PASSED",oDriver);
	} catch (Exception e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	WebElement signon=utls.CreateElement("signon","ObjectRepository",oDriver);
	System.out.println("Sign On Click issue");
	signon.click();
	
	WebElement uname=utls.CreateElement("username","ObjectRepository",oDriver);
	//TC0001	User_Id
	String temp=tds.fetchdata("TC0001","User_Id");
	uname.sendKeys(temp);
	try {
		logo.reportLog("TC001","ST0002","PASSED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement pwd=utls.CreateElement("password","ObjectRepository",oDriver);
	//TC0001	User_Id
	temp=tds.fetchdata("TC0001","pwd");
	pwd.sendKeys(temp);
	
	try {
		logo.reportLog("TC001","ST0003","FAILED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement login=utls.CreateElement("login","ObjectRepository",oDriver);
	try {
		logo.reportLog("TC001","ST0004","PASSED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	login.click();
	
	try {
		boolean result=utls.findElement("Preference","ObjectRepository",oDriver);
		if(result)
		{
		//	Config.logger.log(LogStatus.PASS, "TESTCASE003 Passed successfully");
			logo.reportLog("TC001","ST0005","PASSED",oDriver);
			System.out.println("TC Passed");
			logger.log(Status.PASS, "TESTCASE003 Passed successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
		}
		else
		{
			logo.reportLog("TC001","ST0005","FAILED",oDriver);
			System.out.println("TC Failed");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	oDriver.close();
}
@Test
@Parameters("TESTCASE0004")
//public void TESTCASE0004(String str){
public void TESTCASE0004(String str){
	
	Utils utls=new Utils();
	Logs logo=new Logs();
	TestData tds=new TestData();
	
	logger = extent.createTest("TESTCASE0004");
	WebDriver oDriver= utls.CreateChromeDriver();
	ApplicationFunctions afs= new ApplicationFunctions();
	try {
		afs.launchPage("http://newtours.demoaut.com/",oDriver);
		//oDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		} catch (Throwable e) {
		e.printStackTrace();
		}
	
	try {
		logo.reportLog("TC001","ST0001","PASSED",oDriver);
	} catch (Exception e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	WebElement signon=utls.CreateElement("signon","ObjectRepository",oDriver);
	System.out.println("Sign On Click issue");
	signon.click();
	
	WebElement uname=utls.CreateElement("username","ObjectRepository",oDriver);
	//TC0001	User_Id
	String temp=tds.fetchdata("TC0001","User_Id");
	uname.sendKeys(temp);
	try {
		logo.reportLog("TC001","ST0002","PASSED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement pwd=utls.CreateElement("password","ObjectRepository",oDriver);
	//TC0001	User_Id
	temp=tds.fetchdata("TC0001","pwd");
	pwd.sendKeys(temp);
	
	try {
		logo.reportLog("TC001","ST0003","FAILED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement login=utls.CreateElement("login","ObjectRepository",oDriver);
	try {
		logo.reportLog("TC001","ST0004","PASSED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	login.click();
	
	try {
		boolean result=utls.findElement("Preference","ObjectRepository",oDriver);
		if(result)
		{
		//	Config.logger.log(LogStatus.PASS, "TESTCASE004 Passed successfully");
			logo.reportLog("TC001","ST0005","PASSED",oDriver);
			logger.log(Status.PASS, "TESTCASE004 Passed successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
			System.out.println("TC Passed");
		}
		else
		{
			logo.reportLog("TC001","ST0005","FAILED",oDriver);
			System.out.println("TC Failed");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	oDriver.close();
}
@Test
@Parameters("TESTCASE0005")
public void TESTCASE0005(String str){
//public void TESTCASE0005(String str){
	Utils utls=new Utils();
	Logs logo=new Logs();
	TestData tds=new TestData();
	
	logger = extent.createTest("TESTCASE0005");
	WebDriver oDriver= utls.CreateChromeDriver();
	ApplicationFunctions afs= new ApplicationFunctions();
	try {
		afs.launchPage("http://newtours.demoaut.com/",oDriver);
		//oDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		} catch (Throwable e) {
		e.printStackTrace();
		}
	
	try {
		logo.reportLog("TC001","ST0001","PASSED",oDriver);
	} catch (Exception e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	WebElement signon=utls.CreateElement("signon","ObjectRepository",oDriver);
	System.out.println("Sign On Click issue");
	signon.click();
	
	WebElement uname=utls.CreateElement("username","ObjectRepository",oDriver);
	//TC0001	User_Id
	String temp=tds.fetchdata("TC0001","User_Id");
	uname.sendKeys(temp);
	try {
		logo.reportLog("TC001","ST0002","PASSED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement pwd=utls.CreateElement("password","ObjectRepository",oDriver);
	//TC0001	User_Id
	temp=tds.fetchdata("TC0001","pwd");
	pwd.sendKeys(temp);
	
	try {
		logo.reportLog("TC001","ST0003","FAILED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement login=utls.CreateElement("login","ObjectRepository",oDriver);
	try {
		logo.reportLog("TC001","ST0004","PASSED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	login.click();
	
	try {
		boolean result=utls.findElement("Preference","ObjectRepository",oDriver);
		if(result)
		{
			logo.reportLog("TC001","ST0005","PASSED",oDriver);
	//		Config.logger.log(LogStatus.PASS, "TESTCASE005 Passed successfully");
			System.out.println("TC Passed");
			logger.log(Status.PASS, "TESTCASE005 Passed successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
		}
		else
		{
			logo.reportLog("TC001","ST0005","FAILED",oDriver);
			System.out.println("TC Failed");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	oDriver.close();
}
@AfterMethod
public void getResult(ITestResult result){
	if(result.getStatus() == ITestResult.FAILURE){
		logger.log(Status.FAIL, "Reason for failure");
		logger.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
	}else if(result.getStatus() == ITestResult.SUCCESS){
		logger.log(Status.PASS,"Result is failure");
	}
	// ending test
	//endTest(logger) : It ends the current test and prepares to create HTML report
	//extent.endTest(logger);
} 
@AfterTest
public void endReport(){
	// writing everything to document
	//flush() - to write or update test information to your report. 
            extent.flush();
            //Call close() at the very end of your session to clear all resources. 
            //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
            //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
            //Once this method is called, calling any Extent method will throw an error.
            //close() - To close all the operation
           // extent.close();
}
}

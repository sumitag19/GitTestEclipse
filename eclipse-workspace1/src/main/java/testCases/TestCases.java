package testCases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import applicationModules.ApplicationFunctions;
import config.Config;
//import reporting.ExtentReportsClass;
//import driver.Driver;
import reporting.Logs;
import testData.TestData;
import utility.Utils;
//import utility.Utilss;

public class TestCases {
//	public class TestCases {	
	WebDriver oDriver;
	
	public TestCases(WebDriver driver){
		this.oDriver=driver;
	}
	
	public TestCases(){
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
	
	//logger = extent.createTest("TESTCASE0001");
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
		//logger.log(Status.PASS, "Browser Launched successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + imagepath));
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
		//logger.log(Status.INFO, "User ID entered successfully");
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement pwd=utls.CreateElement("password","ObjectRepository",oDriver);
	//TC0001	User_Id
	temp=tds.fetchdata("TC0001","pwd");
	pwd.sendKeys(temp);
	
	try {
		//logger.log(Status.INFO, "Password entered successfully");
		logo.reportLog("TC001","ST0003","FAILED",oDriver);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	WebElement login=utls.CreateElement("login","ObjectRepository",oDriver);
	try {
		//logger.log(Status.INFO, "Login Button Clicked successfully");
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
			//logger.log(Status.PASS, "TESTCASE001 Passed successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
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
	
//	logger = extent.createTest("TESTCASE0002","Wahi Kaam Test 02 mein kar rhe");
	WebDriver oDriver= utls.CreateChromeDriver();
	ApplicationFunctions afs= new ApplicationFunctions();
	try {
		afs.launchPage("http://newtours.demoaut.com/",oDriver);
		//oDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		} catch (Throwable e) {
		e.printStackTrace();
		}
	
	try {
	//	logger.log(Status.PASS, "Browser Launched Successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
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
		//	logger.log(Status.PASS, "TESTCASE002 Passed successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
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
	
//	logger = extent.createTest("TESTCASE0003","Third Test Starts Here");
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
	//		logger.log(Status.PASS, "TESTCASE003 Passed successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
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
	
//	logger = extent.createTest("TESTCASE0004");
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
	//		logger.log(Status.PASS, "TESTCASE004 Passed successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
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
	
	//logger = extent.createTest("TESTCASE0005");
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
		//	logger.log(Status.PASS, "TESTCASE005 Passed successfully" + logger.addScreenCaptureFromPath(Config.project_path+Config.imagefolderpath + logo.CaptureScreenShots(oDriver,Config.imagefolderpath)));
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
}

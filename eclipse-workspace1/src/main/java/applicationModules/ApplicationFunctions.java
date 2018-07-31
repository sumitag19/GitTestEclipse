package applicationModules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import config.Config;
//import reporting.ExtentReportsClass;
import reporting.Logs;
import testCases.TestCases;
import testData.TestData;
import utility.Utils;
//import utility.Utilss;
//import java.lang.reflect.*;
//import java.io.*;
import java.lang.reflect.Method;

public class ApplicationFunctions {
	
	WebDriver oDriver;
	String temp;
	String testDesc[]=new String[1];
	Utils utls=new Utils(oDriver);
	Logs logs=new Logs(oDriver);
	TestData tds=new TestData();
	TestCases tcs=new TestCases();
	
	public ApplicationFunctions(WebDriver driver){
		this.oDriver=driver;
	}
	
	public ApplicationFunctions(){
}
	
@Test
	public void exe(){
		
		TestData tdc=new TestData();
		System.out.println(tdc.getCount());
		System.out.println("Reverting This Change from SVN");
		int n=tdc.getCount();
		ApplicationFunctions afs=new ApplicationFunctions();
		//int []abc=new int[n];
		String []abc=tdc.getRecords(n);
		Logs logs=new Logs();
		try {
			logs.IntializeLog();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(abc[1]);
		for(int i=0;i<n;i++)
		{
			String ans=tdc.isToBeExecuted(abc[i]);
			System.out.println(ans);
			
			Class[] paramString = new Class[1];
			paramString[0] = String.class;		
			
			if(ans.equals("YES"))
			{
			//***************************
			try{
		        //load the AppTest at runtime
			Class cls = Class.forName("testCases.TestCases");
			Object obj = cls.newInstance();

			//call the printItString method, pass a String param
			Method method = cls.getDeclaredMethod(abc[i], paramString);
			method.invoke(obj, abc[i]);

		}catch(Exception ex){
			ex.printStackTrace();
		}
			//****************************
			}
		}		
		try {
			logs.logfooter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void launchBrowser(WebDriver driver) throws Throwable {
	  
		//logs.IntializeLog(oDriver);
		System.out.println("Folder name is "+Config.logFolderPath);
		int recordnum=tds.getCount();
		System.out.println(recordnum);
		String abc[]=tds.getRecords(recordnum);
		//String execute=null;

		//oDriver=utls.CreateChromeDriver();
		temp=utls.fetchdata("TC0001","url");
		//utls.LoginPage(temp, oDriver);
		//launchPage(temp,driver);
  
		 Boolean isPresent = utls.findElement("username","Sheet2",driver);
		 Thread.sleep(5000); 
		  if(isPresent==true)
		  {
			  System.out.println("Element Mil gya");
			 logs.reportLog("TC001","ST0001","PASSED",driver);
		  }
		  else
		  {
			  System.out.println("Element nhi mila");
			 logs.reportLog("TC001","ST0001","FAILED",driver);
		  }
		  
		  logs.reportLog("TC001","ST0001","PASSED",driver);
		  
		  logs.logfooter();
		  testDesc=tds.fetchTestStep("TC001","ST0001");
		  System.out.println(testDesc[0]);
		  System.out.println(testDesc[1]);		 
	}

	//WebDriver
	public void LoginPage(String url,WebDriver oDriver)
	{		
		//"http://newtours.demoaut.com/"
		oDriver.get(url);
		oDriver.manage().window().maximize();
		//return oDriver;
	}
	
	public void launchPage(String link,WebDriver driver) throws Throwable {
		  //temp=utls.fetchdata("TC0001","url");
		  //oDriver=utls.CreateChromeDriver();
		  //ApplicationFunctions afs=new ApplicationFunctions();
		  ApplicationFunctions afs = new ApplicationFunctions(driver);
		  afs.LoginPage(link, driver);
		  oDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public void click(WebElement webEle) throws Throwable {
		webEle.click();
	}

	public void setText(WebElement webEle,String text) throws Throwable {
		webEle.sendKeys(text);
	}
 
}

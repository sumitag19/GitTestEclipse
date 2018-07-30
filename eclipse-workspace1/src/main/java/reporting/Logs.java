package reporting;

// Function names in below File
//IntializeLog(WebDriver driver)
//LogFolderPath(WebDriver driver)
//creatLogFolder()
//logHeader(WebDriver driver)
//logfooter()
//reportLog(String testId,String stepId, String stepResult)

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import config.Config;
import testCases.TestCases;
import testData.TestData;
	 
public class Logs {
		
	WebDriver oDriver;
	
	public Logs(WebDriver driver){
		this.oDriver=driver;		
	}
	
	public Logs(){
	}
	//Utils utls=new Utils(oDriver);
	/*
	****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : IntializeLog(WebDriver driver)
	Author : Sumit Agrawal
	Description : This function will initialize the initial parameters and create new folder at
	the start of execution
	Date of creation : 12-May-17
	Input Parameters: Webdriver Name
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/			
		
	public void IntializeLog() throws Exception
	 {
	// Below function will create different paths and set it into global parameters
		 LogFolderPath();
	// Below function will create all the required folders before start of execution	 
		 creatLogFolder();
	// Below function will create the header for HTML report
		 logHeader();
	// To calculate the overall execution time in execution	 
		 Config.tStart = System.currentTimeMillis();
	 }
	 
	/*
	 ****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : Logs()
	Author : Sumit Agrawal
	Description : This function will create the unique result folder path along with image folder and 
	save it in global configurat
	ion file(Constants)
	Date of creation : 12-May-17
	Input Parameters:
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/		 
		
	 public void LogFolderPath() throws Exception 
	 	{
		 Config.TCPassed = 0;
		 Config.TCFailed = 0;
		 Config.TCTotal = 0;
		//below line will generate unique string to create folder
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh_mm_ss");
		String time = dateFormat.format(now);
		//String uuid = UUID.randomUUID().toString();
		System.out.println(time);
		//To create a new folder with newly generated name in Results folder
		String fldr="./Results/"+time;
		//Constant class will contain all global parameters
		Config.logFolderPath= fldr;
		//Below lines will generate image folder in results folder	
		String imgfldr=fldr+"/image/";
		//Configuration file will contain name of image folder in global parameter
		Config.imagefolderpath=imgfldr;
		Config.htmlreportLogFile=fldr+"/ReportLog.html";	
		}
	
	 /*
	 ****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : creatLogFolder()
	Author : Sumit Agrawal
	Description : This function will create all the required folder before start of execution
	Date of creation : 12-May-17
	Input Parameters:
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/
	 
	public void creatLogFolder()
	  {
		new File(Config.logFolderPath).mkdirs();
		new File(Config.imagefolderpath).mkdirs();
	  }
	
	/*
	****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : logHeader(WebDriver driver)
	Author : Sumit Agrawal
	Description : This function will create Header for HTML based reporting at the start of execution
	Input Parameters:
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/
	
	public void logHeader() throws Exception
	  {	
		//Below lines are written to create HTML based reporting header 	   
		String report="<html><head><title>Selenium Framework Results</title></head><body><table width=1270 height=40 border=1><tr><th scope=col><h1 align=center><font color=#0000FF>SELENIUM FRAMEWORK TEST EXECUTION REPORT</font></h1></th></tr></table><table width=1270 border=1><tr><th scope=col><p><font color=#0000FF>Selenium Automation Execution</p><p><font color=#0000FF>User ID:= "+InetAddress.getLocalHost().getHostName()+"</p><p><font color=#0000FF>Execution Start Time="+new Date()+"</p></th></tr></table><table width=1270 border=1><tr><th width=120 scope=col>Test Case ID</th><th width=120 scope=col>Step ID</th><th width=400 scope=col>Script Description</th><th width=450 scope=col>Expected Results</th><th width=200 scope=col>Actual Results</th><th width=120 scope=col>Screen Shot</th></tr>";   
		//End of Header file
				   
		FileWriter fWriter = new FileWriter(Config.htmlreportLogFile); 
		BufferedWriter writer = new BufferedWriter(fWriter);
		writer.write(report);
	    writer.newLine();
		writer.close();
		}

	/*
	****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : logfooter()
	Author : Sumit Agrawal
	Description : This function will create footer log at the end of execution to summarise the report
	Input Parameters:
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/	
	
	public void logfooter() throws Exception
	{
	 //int perc=(Config.TCPassed/Config.TCTotal)*100;	
	 Config.tEnd = System.currentTimeMillis();
	 Config.tDelta = Config.tEnd - Config.tStart;
	 Config.TCTotal=Config.TCPassed+Config.TCFailed;
	 float tcperc= ((float)Config.TCPassed/(float)Config.TCTotal)*100;
	 Config.elapsedSeconds = Config.tDelta / 1000.0;	  
	 // long estimatedTime = System.nanoTime() - startTime;
	 //	System.out.println(elapsedSeconds+" seconds");		
	String sTable="<Table width=1270 border=1><tr><th scope=col><p><font color=#0000FF>Execution End Time :"+new Date()+"</p></th></tr><table width=1270 border=1><tr><th width=290 scope=col><font color=#0000FF>Total Elapsed time :<b>"+Config.elapsedSeconds+" seconds</b></th><th width=130 scope=col><font color=#0000FF>Total Steps :<b>"+Config.TCTotal+"</b></th><th width=150 scope=col><font color=#008000>Total Passed Steps :<b>"+Config.TCPassed+"</b></th><th width=150 scope=col><font color=#FF0000>Total Failed Steps :<b>"+Config.TCFailed+"</b></th><th width=200 scope=col>Passed Percentage :<b>"+tcperc+"</b></th><tr>";
		
	File htmlReport = new File(Config.htmlreportLogFile);
	if(htmlReport.exists())
		{
		System.out.println("File Already exists");
		FileWriter fWriter = new FileWriter(htmlReport,true); 
	    BufferedWriter writer = new BufferedWriter(fWriter);
		PrintWriter out=new PrintWriter(writer);
		out.println();
		out.print(sTable);
		out.close();
		}
	else
		{
		System.out.println("File Doesnot exists");
		}
	}
	
	// Report log function to log report
	public void reportLog(String testId,String stepId, String stepResult,WebDriver driver) throws Exception
	{
//		String logs=Constants.htmlreportLogFile;
		String stepSummary;
		String color="000000";
		String[] testDesc=new String[2];
		TestCases tcases=new TestCases();
		TestData tds=new TestData();
		String imagepath=CaptureScreenShots(driver,Config.imagefolderpath);
		String imagepathref="<a href=image/"+imagepath+">Screen Shot</a>";
		   //String stepDesc="Test case pass hona chahiye";
		   //String expectedResult="Test case pass ho gya hai";
		//Utils utls=new Utils();
		testDesc=tds.fetchTestStep(testId,stepId);
		String stepDesc=(testDesc[0]);
		String expectedResult=(testDesc[1]);
		System.out.println(stepDesc);
		System.out.println(expectedResult);
		if(stepResult=="PASSED")
		   {
			 Config.TCPassed = Config.TCPassed+1;
			   color="#008000";
			   stepSummary="Test case is passed";
		   }
		else if(stepResult=="FAILED")
		   {
			Config.TCFailed = Config.TCFailed+1;
			   color="FF0000";
		       stepSummary="Test case in failed";	
		   }
		else
		   {
			   color="000000";
			   stepSummary="Incorrect Results, please check manually";
		   }
		String sCompstr="<TR><TD align=center><font color="+color+">"+testId+"</font><TD align=center><font color="+color+"> "+stepId+"</font></TD></TD><TD align=center><font color="+color+">"+stepDesc+"</font></TD><TD align=center><font color="+color+"> "+expectedResult+"</font></TD><TD align=center><font color="+color+"> "+stepSummary+"</font></TD><TD align=center><font color="+color+"> "+imagepathref+"</font></TD></TR>";

		File htmlReport = new File(Config.htmlreportLogFile);
		if(htmlReport.exists())
			{
				FileWriter fWriter = new FileWriter(htmlReport,true); 
				  BufferedWriter writer = new BufferedWriter(fWriter);
				  PrintWriter out=new PrintWriter(writer);
				  out.println();
				  out.print(sCompstr);
				  out.close();
			}
		else
			{
				IntializeLog();
				FileWriter fWriter = new FileWriter(htmlReport,true); 
				  BufferedWriter writer = new BufferedWriter(fWriter);
				  PrintWriter out=new PrintWriter(writer);
				  out.println();
				  out.print(sCompstr);
				  out.close();
		}
	}
	
	/*
	****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : CaptureScreenShots(WebDriver driver,String folderpath)
	Author : Sumit Agrawal
	Description : Below Line of code written to take the screenshot @ any given time
	Input Parameters: WebDriver and Path of image folder in results to save the screen
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/
	//Below Line of code written to take the screenshot @ any given time
	//Here Folderpath is name of the image folder where all the images will be kept during the execution
	public String CaptureScreenShots(WebDriver driver,String folderpath) throws Exception {
		// TODO Auto-generated method stub
		//String uuid = UUID.randomUUID().toString();
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh_mm_ss");
		String time = dateFormat.format(now);
	//try {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./"+folderpath+"/"+time+".png"));
		System.out.println("Screen shot captured successfully");
		//String imagepaths="./"+uuid+".png";
		String imagepaths=time+".png";
//	} catch (Exception e) {
		// TODO Auto-generated catch block
//		System.out.println("Screen shot has some issues "+ e.getMessage());
//	}
		System.out.println(imagepaths);
		return imagepaths;
}
	}
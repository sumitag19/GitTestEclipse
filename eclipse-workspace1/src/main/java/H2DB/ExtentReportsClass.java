//package H2DB;

/*
package H2DB;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

import reporting.Logs;

public class ExtentReportsClass{
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlReporter;
	
	@BeforeTest
	public void startReport(){
		Logs logs=new Logs();
		try {
			logs.IntializeLog();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ExtentReports(String filePath,Boolean replaceExisting) 
		//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		// Below code is applicable for Version 2.0
		//		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/MyExtentReport.html", false);
		//Below code is applicable for version 3.0
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
/*		
	@Test
	public void FirstTest(){
		//extent.startTest("TestCaseName", "Description")
		//TestCaseName – Name of the test
		//Description – Description of the test
		//Starting test
		logger = extent.startTest("FirstTest");
		Assert.assertTrue(true);
		//To generate the log when the test case is passed
		logger.log(LogStatus.FAIL, "Test Case Passed is First Test");
	}
	
	@Test
	public void failTest(){
		logger = extent.startTest("Second Test");
		Assert.assertTrue(true);
		logger.log(LogStatus.FAIL, "Test Case (failTest) Status is passed");
		logger.log(LogStatus.FAIL, "Snapshot below: " + logger.addScreenCapture(System.getProperty("user.dir") +"/test-output/STMExtentReport.png"));
	}
	
	@Test
	public void skipTest(){
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	*/
/*
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(Status.FAIL, MarkupHelper.createLabel("Test Case Failed is "+result.getName(),ExtentColor.RED));
			logger.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SUCCESS){
			logger.log(Status.PASS,MarkupHelper.createLabel("Test Case Skipped Passed "+result.getName(),ExtentColor.GREEN));
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
*/
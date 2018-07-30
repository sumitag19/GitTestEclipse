package utility;

//import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
import java.util.UUID;
//import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import config.Constants;

public class Utils {
	
	WebDriver oDriver;
	
	public Utils(WebDriver driver){
		this.oDriver=driver;
	}
	
	public Utils()
	{
			}
		
	/*
	****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : CreateChromeDriver()
	Author : Sumit Agrawal
	Description : Below line of code will launch the Driver for Chrome Browser and disable any open extension with Chrome
	Input Parameters: 
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/		
	public WebDriver CreateChromeDriver()
	{
		ChromeOptions options = new ChromeOptions();
		// To disable the extension message coming after launching the Chrome 
		options.addArguments("--disable-extensions");
		// To disable the Chrome being controlled by automated software message coming after launching the Chrome 
		options.addArguments("disable-infobars");
		// To Launch the Chrome Driver, you need to install this .exe file and place it somewhere
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sumit\\Desktop\\chromedriver_win32\\chromedriver.exe");
		// Pass the options parametere to define the parameter while launching chrome
		WebDriver oDriver = new ChromeDriver(options);
	return oDriver;
	}

	/*
	****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : CreateChromeDriver()
	Author : Sumit Agrawal
	Description : Below Function is prepared to create a new Internet explorer Driver
	Input Parameters: 
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/		
		public WebDriver CreateInternetDriver()
		{	
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Sumit\\Desktop\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
		WebDriver oDriver = new InternetExplorerDriver();
		return oDriver;
		}

		/*
		****************************************************************
		Project Name : Hybrid - Selenium Framework
		Function Name : CreateElement(String webelName,String dBname)
		Author : Sumit Agrawal
		Description : Below Function is prepared to create a new Internet explorer Driver
		Input Parameters: Name of web element and DB name where you kept the definition of web element
		Name of person modifying: NA
		Date of modification: NA 
		******************************************************************
		*/		
		
	  public WebElement CreateElement(String webelName,String dBname,WebDriver oDriver){
			String IndetifierType = null;
			String Identvalue = null;
			WebElement webelName1 = null;
			Statement st=null;
			Connection con=null;
			ResultSet rsa=null;
			  try 
				{
				//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//con = DriverManager.getConnection("jdbc:odbc:Selenium","","");
				//st = con.createStatement();
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//				String msAccDB = "D:/Selenium/version01/src/test/resources/TestDataRepository.accdb";
				String msAccDB = "C:\\Users\\sumit\\eclipse-workspace1\\src\\main\\resources\\TestDataRepository.accdb";
			    String dbURL = "jdbc:ucanaccess://" + msAccDB;
			     con = DriverManager.getConnection(dbURL);
			     st = con.createStatement();
//				rsa = st.executeQuery("Select IdentifierType,IdentifierValue from ["+dBname+"$] where ObjectName='"+webelName+"'");
				rsa = st.executeQuery("Select IdentifierType,IdentifierValue from ["+dBname+"] where ObjectName='"+webelName+"'");
				while (rsa.next())
				{	
					IndetifierType=rsa.getString("IdentifierType");
					System.out.println(IndetifierType);
					Identvalue=rsa.getString("IdentifierValue");
					System.out.println(Identvalue);
				}
				}
				catch (Exception e) {e.printStackTrace();}  
			  
			  switch (IndetifierType) 
			  {
		      case "xpath":  
		    	  webelName1=oDriver.findElement(By.xpath(Identvalue));
		    	  break;
		    	  //return webelName1;
		      case "name":
		    	  webelName1=oDriver.findElement(By.name(Identvalue));
		    	  break;
		    	  //return webelName1;
		      case "id": 
		    	  //IndetifierType = "March";
		          webelName1=oDriver.findElement(By.id(Identvalue));
		          break;
		          //return webelName1;
		      default:
		    	  break;
			  }
			  try {
					con.close();
					rsa.close();
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return webelName1;
		  }
	  
		/*
		****************************************************************
		Project Name : Hybrid - Selenium Framework
		Function Name : findElement(String webelName,String dBname,WebDriver driver)
		Author : Sumit Agrawal
		Description : To Verify if Web Element is present or not
		Input Parameters: 
		Name of person modifying: NA
		Date of modification: NA 
		******************************************************************
		*/
	  
	  public boolean findElement(String webelName,String dBname,WebDriver driver) throws Exception{
			String IndetifierType = null;
			String Identvalue = null;
			boolean elePresent = false;
			Statement st=null;
			Connection con=null;
			ResultSet rsa=null;
			
			  try 
				{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//					String msAccDB = "D:/Selenium/version01/src/test/resources/TestDataRepository.accdb";
					String msAccDB = "C:\\Users\\sumit\\eclipse-workspace1\\src\\main\\resources\\TestDataRepository.accdb";
				    String dbURL = "jdbc:ucanaccess://" + msAccDB;
				     con = DriverManager.getConnection(dbURL);
				     st = con.createStatement();
				//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//Connection con = DriverManager.getConnection("jdbc:odbc:Selenium","","");
				//Statement st = con.createStatement();
				//ResultSet rsa = st.executeQuery("Select IdentifierType,IdentifierValue from ["+dBname+"$] where ObjectName='"+webelName+"'");
				rsa = st.executeQuery("Select IdentifierType,IdentifierValue from ["+dBname+"] where ObjectName='"+webelName+"'");
				while (rsa.next())
				{	
					IndetifierType=rsa.getString("IdentifierType");
					System.out.println(IndetifierType);
					Identvalue=rsa.getString("IdentifierValue");
					System.out.println(Identvalue);
				}
				}
				catch (Exception e) {e.printStackTrace();}  
			  
			  switch (IndetifierType) 
			  {
		      case "xpath":  
		    	 // webelName1=oDriver.findElement(By.xpath(Identvalue));
		    	  
		    	  elePresent = driver.findElements(By.xpath(Identvalue)).size() > 0;
		    	  //Thread.sleep(4000);
		    	 // elePresent = driver.findElements(By.xpath("//input[@name='userName']")).size() > 0;
		    	  //Boolean isPresent = oDriver.findElements(By.xpath("//input[@name='userName']")).size() > 0;
		    	  break;
		    	  //return webelName1;
		      case "name":
		    	  //webelName1=oDriver.findElement(By.name(Identvalue));
		    	  elePresent = driver.findElements(By.name(Identvalue)).size() > 0;
		    	  break;
		    	  //return webelName1;
		      case "id": 
		    	  //IndetifierType = "March";
		          //webelName1=oDriver.findElement(By.id(Identvalue));
		          elePresent = driver.findElements(By.id(Identvalue)).size() > 0;
		          break;
		          //return webelName1;
		      default:
		    	  break;
			  }
			  try {
					con.close();
					rsa.close();
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return elePresent;
		  }
	  
		/*
		****************************************************************
		Project Name : Hybrid - Selenium Framework
		Function Name : fetchdata(String objectID,String ObjectProp)
		Author : Sumit Agrawal
		Description : To fetch the data from Data repository
		Input Parameters: Object ID and Object property to fetch the data for corresponding scenario
		Name of person modifying: NA
		Date of modification: NA 
		******************************************************************
		*/
	  
	  public String fetchdata(String objectID,String ObjectProp)
		{
		String data = null;
		Statement st=null;
		Connection con=null;
		ResultSet rsa=null;
		try 
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//			String msAccDB = "D:/Selenium/version01/src/test/resources/TestDataRepository.accdb";
			String msAccDB = "C:\\Users\\sumit\\eclipse-workspace1\\src\\main\\resources\\TestDataRepository.accdb";
			
			
		    String dbURL = "jdbc:ucanaccess://" + msAccDB;
		     con = DriverManager.getConnection(dbURL);
		     st = con.createStatement();
//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//	Connection con = DriverManager.getConnection("jdbc:odbc:Selenium","","");
		//Statement st = con.createStatement();
		//String squery="Select Data from [Sheet1$] where Test_Case_Name='"+tcid+"'";
		
		//******************************************
		//ResultSet rs = st.executeQuery("Select count(*) as bc from [Sheet1$]");	
		//while (rs.next())
		//{
		//num=rs.getInt("bc");
		//System.out.println("Count is "+num);
		//}
		//rs.close();
		//***********************************************************
		
		//ResultSet rsa = st.executeQuery("Select Data from [Sheet1$] where Test_Case_Name='"+tcid+"'");
	//	ResultSet rsa = st.executeQuery("Select Data from [Sheet1$] where Test_Case_Name='"+objectID+"' and TestObjectID='"+ObjectProp+"'");
		rsa = st.executeQuery("Select Data from [TestDataRepository] where Test_Case_Name='"+objectID+"' and TestObjectID='"+ObjectProp+"'");		
		//ResultSet rs = st.executeQuery("Select Data from [Sheet1$] where Test_Case_Name='TC0001'");
		
		//System.out.println("Query is: "+squery);
		while (rsa.next())
		{
		//for(int i=0;i<=num;i++)
		//{
		//System.out.println(rsa.getString("Data"));
		data=rsa.getString("Data");
		//	System.out.println(data[i]);
			//System.out.println(rs.getString("Data"));
		//.getString("Data");
			//System.out.println(rs.getString("Object_Description"));
		System.out.println("-------");
		//}
		}
		}
		catch (Exception e) {e.printStackTrace();}
		 try {
				con.close();
				rsa.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return data;
		}
	  
//**************************************************************************************************************
		  // WAIT CONDITION WAIT CONDITION WAIT CONDITION WAIT CONDITION WAIT CONDITION
			// Below line of code for Wai conditions in Selenium
			//	WebDriverWait wait = new WebDriverWait(oDriver, 10);
			//	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
			//  Below line of code will wait for 
			//	oDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//*************************************************************************************************************		  
		  
}
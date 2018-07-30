package testData;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.WebDriver;

public class TestData {
	
	WebDriver oDriver;
	
	public TestData(WebDriver driver){
		this.oDriver=driver;
	}
	
	public TestData(){
			}
	
	/*
	 ****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : fetchTestStep(String TCID,String STEPID)
	Author : Sumit Agrawal
	Description : To fetch the test step and description from test case sheet and use it for HTML report formation
	Date of creation : 12-May-17
	Input Parameters: Test Case ID and Step ID for particular test case
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/
	
public String[] fetchTestStep(String TCID,String STEPID)
	{
	String data[] = new String[2];
	Connection con=null;
	Statement st=null;
	ResultSet rsa=null;
//	int num=0;
	try 
	{
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	
//	String msAccDB = "D:/Selenium/version01/src/test/resources/TestDataRepository.accdb";
	String msAccDB = "C:\\Users\\sumit\\eclipse-workspace1\\src\\main\\resources\\TestDataRepository.accdb";
    String dbURL = "jdbc:ucanaccess://" + msAccDB;
    con = DriverManager.getConnection(dbURL);
	//Connection con = DriverManager.getConnection("jdbc:odbc:Selenium","","");
	st = con.createStatement();
	//System.out.println("Select * from [Sheet3$] where TCID='"+TCID+"' and STEPID='"+STEPID+"'");
	//ResultSet rsa = st.executeQuery("Select STEPDESC,EXPECTED from [Sheet3$] where TCID='"+TCID+"' and STEPID='"+STEPID+"'");
	rsa = st.executeQuery("Select STEPDESC,EXPECTED from [TestCaseRepository] where TCID='"+TCID+"' and STEPID='"+STEPID+"'");
	//	ResultSet rsa = st.executeQuery("Select * from [Sheet3$] where STEPID='ST0001'");
	//ResultSet rsa = st.executeQuery("Select Data from [Sheet1$] where Test_Case_Name='TC0001'");
	
	//System.out.println("Query is: "+squery);
	while (rsa.next())
	{
	data[0]=rsa.getString("STEPDESC");
	data[1]=rsa.getString("EXPECTED");
	System.out.println("-------");
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
	
	/*
	 ****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : isToBeExecuted(String tcName)
	Author : Sumit Agrawal
	Description : To Verify if you want to execute particular test case in current run or not
	Date of creation : 12-May-17
	Input Parameters: Test Case name you want to execute
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/
	public String isToBeExecuted(String tcName)
	{		
		String tobeExecute=null;
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
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Connection con = DriverManager.getConnection("jdbc:odbc:TestRepository","","");
		 st = con.createStatement();
	//	ResultSet rsa = st.executeQuery("Select TobeExecuted from [Sheet1$] where Test_Case_Name='"+tcName+"'");
		 rsa = st.executeQuery("Select TobeExecuted from [TobeExecuted] where Test_Case_Name='"+tcName+"'");
		// PreparedStatement pstmt = connection.prepareStatement(sql);
		 while (rsa.next())
		{	
			tobeExecute=rsa.getString("TobeExecuted");	
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
	return tobeExecute;
	}

	/*
	 ****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : fetchScriptName(String tcName)
	Author : Sumit Agrawal
	Description : To Fetch the script to be executed to execute any scenario, based on the output of IstobeExecuted function, If IstobeExecuted returns
	Date of creation : 12-May-17
	Input Parameters: Test Case name you want to execute
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/
	public String fetchScriptName(String tcName)
	{		
		String scriptName=null;
		Statement st=null;
		Connection con=null;
		ResultSet rsa=null;
	
		try 
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			//String msAccDB = "D:/Selenium/version01/src/test/resources/TestDataRepository.accdb";
			String msAccDB = "C:\\Users\\sumit\\eclipse-workspace1\\src\\main\\resources\\TestDataRepository.accdb";
		    String dbURL = "jdbc:ucanaccess://" + msAccDB;
		     con = DriverManager.getConnection(dbURL);			
	//	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//	Connection con = DriverManager.getConnection("jdbc:odbc:TestRepository","","");
		st = con.createStatement();
//		ResultSet rsa = st.executeQuery("Select ScriptName from [Sheet1$] where Test_Case_Name='"+tcName+"'");
		rsa = st.executeQuery("Select ScriptName from Sheet1 where Test_Case_Name='"+tcName+"'");
		while (rsa.next())
		{	
			scriptName=rsa.getString("ScriptName");
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
	return scriptName;
	}

	/*
	 ****************************************************************
	Project Name : Hybrid - Selenium Framework
	Function Name : fetchdata(String tcID,String tcObjID)
	Author : Sumit Agrawal
	Description : To Fetch the data to perform the execution of partucular test
	Date of creation : 12-May-17
	Input Parameters: Test Case name and object ID in that particular test
	Name of person modifying: NA
	Date of modification: NA 
	******************************************************************
	*/
	
	  public String fetchdata(String tcID,String tcObjID)
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
//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//	Connection con = DriverManager.getConnection("jdbc:odbc:Selenium","","");
		 st = con.createStatement();
		//ResultSet rsa = st.executeQuery("Select Data from [Sheet1$] where Test_Case_Name='"+tcid+"'");
//		ResultSet rsa = st.executeQuery("Select Data from [Sheet1$] where Test_Case_Name='"+tcID+"' and TestObjectID='"+tcObjID+"'");
		 rsa = st.executeQuery("Select Data from [TestDataRepository] where Test_Case_Name='"+tcID+"' and TestObjectID='"+tcObjID+"'");
		
		//ResultSet rs = st.executeQuery("Select Data from [Sheet1$] where Test_Case_Name='TC0001'");
		
		while (rsa.next())
		{
		data=rsa.getString("Data");
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


		/*
		 ****************************************************************
		Project Name : Hybrid - Selenium Framework
		Function Name : getCount()
		Author : Sumit Agrawal
		Description : To get the count of total test cases in execution sheet
		Date of creation : 12-May-17
		Input Parameters: 
		Name of person modifying: NA
		Date of modification: NA 
		******************************************************************
		*/
	  
	  public int getCount()
	  {
		  int recordCount=0;
			Statement st=null;
			Connection con=null;
			ResultSet rsa=null;
		  try 
		  {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");	  
		System.out.println("Yahan In hai");
//		String msAccDB = "D:/Selenium/version01/src/test/resources/TestDataRepository.accdb";
		String msAccDB = "C:\\Users\\sumit\\eclipse-workspace1\\src\\main\\resources\\TestDataRepository.accdb";
	    String dbURL = "jdbc:ucanaccess://" + msAccDB;
	     con = DriverManager.getConnection(dbURL);
	    
//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//	Connection con = DriverManager.getConnection("jdbc:odbc:TestRepository","","");
		 st = con.createStatement();
		System.out.println("Yahan Out hai");
		//******************************************
//		ResultSet rs = st.executeQuery("Select count(*) as rccount from [Sheet1$]");
		 rsa = st.executeQuery("Select count(*) as rccount from [TobeExecuted]");
		while (rsa.next())
		{
			recordCount=rsa.getInt("rccount");
			System.out.println("Count is "+recordCount);
		}
		//rsa.close();
		}
		  catch (Exception e) {e.printStackTrace();}
		/*  try {
				//con.close();
				//rsa.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		  return recordCount;
	  }

		/*
		 ****************************************************************
		Project Name : Hybrid - Selenium Framework
		Function Name : getRecords(int rCount)
		Author : Sumit Agrawal
		Description : To return the array of test cases to be executed in current cycle
		Date of creation : 12-May-17
		Input Parameters: count of cases in particular run
		Name of person modifying: NA
		Date of modification: NA 
		******************************************************************
		*/
	  
	public String[] getRecords(int rCount)
	{
		String records[]=new String[rCount];
		Statement st=null;
		Connection con=null;
		ResultSet rsa=null;
		//ArrayList<String> a = new ArrayList<String>();
		int i=0;
		try 
		{
//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//	Connection con = DriverManager.getConnection("jdbc:odbc:TestRepository","","");
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		//String msAccDB = "D:/Selenium/version01/src/test/resources/TestDataRepository.accdb";
		String msAccDB = "C:\\Users\\sumit\\eclipse-workspace1\\src\\main\\resources\\TestDataRepository.accdb";
	    String dbURL = "jdbc:ucanaccess://" + msAccDB;
	     con = DriverManager.getConnection(dbURL);
		
		 st = con.createStatement();
		
		//******************************************
		 rsa = st.executeQuery("Select * from [TobeExecuted]");
//		ResultSet rs = st.executeQuery("Select * from [Sheet1$]");
		while (rsa.next())
		{
		records[i]=rsa.getString("Test_Case_Name");
		//System.out.println(rs.getString("Test_Case_Name"));
		i=i+1;
		//a.add(rs.getString("Test_Case_Name"));
		}
		rsa.close();
			}
		catch (Exception e) {e.printStackTrace();}
		
		/* try {
				con.close();
				rsa.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		 
		return records;
		//System.out.println(a.size());
		//return (String[]) a.toArray(new String[a.size()]);
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
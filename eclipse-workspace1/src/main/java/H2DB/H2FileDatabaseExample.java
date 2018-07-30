package H2DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import org.h2.tools.DeleteDbFiles;


// H2 Database Example

public class H2FileDatabaseExample {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) throws Exception {
        try {
            // delete the H2 database named 'test' in the user home directory
           // DeleteDbFiles.execute("~", "test", true);
           // insertWithStatement();
            fetchdata("TC0001","url");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // H2 SQL Statement Example
    private static void insertWithStatement() throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE TOBE_EXECUTED(TC_NAME varchar(255), TC_OBJ varchar(255),TC_DATA varchar(255))");
            stmt.execute("INSERT INTO TOBE_EXECUTED VALUES('TC0001', 'url','http://newtours.demoaut.com/')");
            stmt.execute("INSERT INTO TOBE_EXECUTED VALUES('TC0001', 'User_Id','sumit')");
            stmt.execute("INSERT INTO TOBE_EXECUTED VALUES('TC0001', 'pwd','mercury')");

            ResultSet rs = stmt.executeQuery("select * from TESTDATAREPOSITORY");
            System.out.println("H2 Database inserted through Statement");
            while (rs.next()) {
                System.out.println("Id "+rs.getString("TC_NAME")+" Name "+rs.getString("TC_DATA"));
            }
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

 // H2 SQL Statement Example
    private static void fetchdata(String tcID,String tcObjID) throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

    		ResultSet rsa = stmt.executeQuery("Select TC_DATA from TESTDATAREPOSITORY where TC_NAME='"+tcID+"' and TC_OBJ='"+tcObjID+"'");	
//    		ResultSet rsa = stmt.executeQuery("Select NAME from PERSON where ID='"+tcID+"'");
           // ResultSet rs = stmt.executeQuery("select * from PERSON");
            System.out.println("H2 Database Query Worked fine");
            while (rsa.next()) {
                System.out.println("Data Value "+rsa.getString("TC_DATA"));
            }
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
        	 dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                   DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
package datadriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB 
{
	
	public static void main(String[] args) throws Exception
	   {
	       
	        try {
	          
	        	//Connection String for SQL JDBC
	           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        	
	           //Connection to database
	           Connection connection = DriverManager.getConnection("jdbc:sqlserver://192.168.1.233;database=MQDSNR;username=qa;password=ids;");
	            
	           //Creating New Statement using DB connection
	           Statement stmt = connection.createStatement();
	           //Execute query 
	           ResultSet rs = stmt.executeQuery("select * from userlist");
	           
	           //Iterate until database had next record
	        while(rs.next())
	        {
	        	//Using table component Get value into String Format
	            String Srno=rs.getString("sno");
	            String name=rs.getString("name");
	            String Mnum=rs.getString("mobilenumber");
	            
	        }
	      
	        } catch (Exception e) {
	            e.getMessage();
	            e.getStackTrace();
	        }
	        
	        
	        
	        try {
	        	
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            
	            Connection con = DriverManager.
	                getConnection("jdbc:oracle:thin:@<hostname>:<port num>:<DB name>"
	                    ,"user","password");
	            
	            Statement stmt = con.createStatement();
	            System.out.println("Created DB Connection....");
	            
	            ResultSet rs=stmt.executeQuery("select * from user;");
	            
	            //Iterate for number of record times
	            while(rs.next())
	            {
	            	String name=rs.getString("sname");
	            }
	            
	            
	            
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            throw new IllegalStateException("Wrong connection", e);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	
	        
	        
	        

	   }
	


}

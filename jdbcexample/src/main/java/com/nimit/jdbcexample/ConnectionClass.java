package com.nimit.jdbcexample;

import java.sql.*;

public class ConnectionClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
		         "databaseName=AdventureWorks;user=sa;password=Netiq123";*/
		
		String connectionUrl = "jdbc:jtds:sqlserver://localhost:1433;databaseName=ContentManager;user=sa;password=Netiq123";
		
		Connection con = null;
	    Statement stmt = null;
	    ResultSet result = null;
	    
	    try {
	         // Establish the connection.
	         //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	
	    	 Class.forName("net.sourceforge.jtds.jdbc.Driver");
	         con = DriverManager.getConnection(connectionUrl);

	         // Create and execute an SQL statement that returns some data.
	         String SQL = "select * from TableOfStudents";
	         stmt = con.createStatement();
	         result = stmt.executeQuery(SQL);

	         // Iterate through the data in the result set and display it.
	         while (result.next()) {
	        	 System.out.println(result.getString("ID")+"\t"+result.getString("Name"));
	         }
	      }

	      // Handle any errors that may have occurred.
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         if (result != null) try { result.close(); } catch(Exception e) {}
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	         if (con != null) try { con.close(); } catch(Exception e) {}
	      }

	}

}

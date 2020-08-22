package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*   App to get  count of records in  emp db table
 *  version: 1.0
 * @author Admin
 * */
public class PSSelectTest4 {
   private static final String  EMPS_COUNT_QUERY="SELECT COUNT(*) FROM EMP";
	public static void main(String[] args) {
		Connection con=null;
	    PreparedStatement ps=null;
	    String query=null;
	    ResultSet rs=null;
			try {
		     // register jdbc driver
				//Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			//create JDBC PreparedStatement object
				if(con!=null)
					ps=con.prepareStatement(EMPS_COUNT_QUERY);
		         
				
			 //send and execute SQL query in DB s/w	
				if(ps!=null)
					 rs=ps.executeQuery();
				
				//process the ResultSet object
				if(rs!=null) {
					rs.next();
					//System.out.println("records count::"+rs.getInt(1));
					System.out.println("records count::"+rs.getInt("count(*)"));
				}//if
	    }//try
		catch(SQLException se) {
			System.out.println(se);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
				//close jdbc objs
			   try {
				   if(rs!=null)
					   rs.close();
			   }
			   catch(SQLException se) {
				   se.printStackTrace();
			   }
			   try {
				   if(ps!=null)
					   ps.close();
			   }
			   catch(SQLException se) {
				   se.printStackTrace();
			   }
			   try {
				   if(con!=null)
					   con.close();
			   }
			   catch(SQLException se) {
				   se.printStackTrace();
			   }
			}//finally
	}//main
}//class

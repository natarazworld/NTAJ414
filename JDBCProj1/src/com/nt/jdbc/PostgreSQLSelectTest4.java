package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*   App to get  count of records in  emp db table
 *  version: 1.0
 * @author Admin
 * */
public class PostgreSQLSelectTest4 {

	public static void main(String[] args) {
		Connection con=null;
	    Statement st=null;
	    String query=null;
	    ResultSet rs=null;
			try {
		     // register jdbc driver
				//Class.forName("org.postgresql.Driver");
			//establish the connection
				con=DriverManager.getConnection("jdbc:postgresql:ntaj414db","postgres", "root");
			//create JDBC Statement object
				if(con!=null)
					st=con.createStatement();
				//prepare SQL query
				       
				query="SELECT PID,PNAME,PRICE,QTY FROM PRODUCT";
			 //send and execute SQL query in DB s/w	
				if(st!=null)
					 rs=st.executeQuery(query);
				//process the ResultSet object
				if(rs!=null) {
					while(rs.next()) {
                           System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+"  "+rs.getFloat(4));						
					}
				}//if
				System.out.println(" con object class name::"+con.getClass());
				System.out.println(" st object class name::"+st.getClass());
				System.out.println(" rs object class name::"+rs.getClass());
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
				   if(st!=null)
					   st.close();
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

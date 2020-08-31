package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonAgeCalculatorMySQL {
   //private static final String AGE_CALCULATOR_MYSQL="SELECT (DATEDIFF(NOW(),DOB))/365.25  FROM PERSON_DATE_TAB1 WHERE PID=?";
	private static final String AGE_CALCULATOR_MYSQL="SELECT FROM_DAYS(DATEDIFF(NOW(),DOB))  FROM PERSON_DATE_TAB1 WHERE PID=?";
	public static void main(String[] args) {
		Scanner sc=null;
		int pid=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter PErson id::");
				pid=sc.nextInt();
			}
			
			  //establish the connection
			  con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root","root");
			
			  //create PreparedStatement object having pre-compiled SQL query
			  if(con!=null)
				  ps=con.prepareStatement(AGE_CALCULATOR_MYSQL);
			  //set query param values
			  if(ps!=null)
				  ps.setInt(1, pid);
			  //execute the query
			  if(ps!=null)
				  rs=ps.executeQuery();
			  //process the ResultSet obj
			  if(rs!=null) {
				  if(rs.next()) {
					   //System.out.println("Person age::"+rs.getFloat(1));
					  //System.out.println("Person age::"+rs.getString(1));
					  System.out.println("Person age::"+rs.getDate(1));
				  }
				  else {
					  System.out.println("Record not found");
				  }
     		   }//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
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
			
			
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally

	}//main
}//class

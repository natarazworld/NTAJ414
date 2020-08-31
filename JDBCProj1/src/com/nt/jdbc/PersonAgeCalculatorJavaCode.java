package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class PersonAgeCalculatorJavaCode {
   private static final String GET_DOB="SELECT DOB  FROM PERSON_DATE_TAB1 WHERE PID=?";
	public static void main(String[] args) {
		Scanner sc=null;
		int pid=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		long sysDateMs=0L,dobMs=0L;
		java.util.Date  udob=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter PErson id::");
				pid=sc.nextInt();
			}
			
			  //establish the connection
			 //con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root","root");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			  //create PreparedStatement object having pre-compiled SQL query
			  if(con!=null)
				  ps=con.prepareStatement(GET_DOB);
			  //set query param values
			  if(ps!=null)
				  ps.setInt(1, pid);
			  //execute the query
			  if(ps!=null)
				  rs=ps.executeQuery();
			  //process the ResultSet obj
			  if(rs!=null) {
				  if(rs.next()) {
					  // get System date in ms
					      sysDateMs=new Date().getTime();
					   // get DOB from from ResultSEt
					        udob=rs.getDate(1);  // java.util.Date class ref variable (udob) is refering java.sql.Date class obj
					                                                  //as super class ref can refer sub class obj
					       dobMs=udob.getTime();
					       System.out.println("Person age::"+(sysDateMs-dobMs)/(1000*60*60*24*365.25f));
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

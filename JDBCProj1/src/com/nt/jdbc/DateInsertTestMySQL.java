package com.nt.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertTestMySQL {
  private static final String  DATE_INSERT_QUERY="INSERT INTO PERSON_DATE_TAB1(PNAME,PADDRS,DOB,DOM,DOJ) VALUES(?,?,?,?,?)";
	public static void main(String[] args) {
		 Scanner sc=null;
		 String name=null,addrs=null,sdob=null,sdom=null,sdoj=null;
		 Connection con=null;
		 PreparedStatement ps=null;
		 java.util.Date udob=null,udom=null;
		 SimpleDateFormat sdf1=null,sdf2=null;
		 java.sql.Date sqdob=null,sqdom=null,sqdoj=null;
		 int count=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				 System.out.println("Enter person name::");
				 name=sc.next();
				 System.out.println("Enter person address::");
				 addrs=sc.next();
				 System.out.println("Enter person DOB(dd-MM-yyyy)::");
				 sdob=sc.next();
				 System.out.println("Enter person DOM(MM-dd-yyyy)::");
				 sdom=sc.next();
				 System.out.println("Enter person DOJ(yyyy-MM-dd)::");
				 sdoj=sc.next();
			}//if
			// converting String Date values to java.util.Date class objs (dob,dom)
			 sdf1=new SimpleDateFormat("dd-MM-yyyy");
			  if(sdf1!=null) 
			    udob=sdf1.parse(sdob);
			  
			 sdf2=new SimpleDateFormat("MM-dd-yyyy");
			  if(sdf2!=null)
			    udom=sdf2.parse(sdom);
			  //converting  java.util.DAte class objects to  java.sql.Date class objs (dob,dom)
			   if(udob!=null)
			     sqdob=new java.sql.Date(udob.getTime());
			   
			   if(udom!=null)
				     sqdom=new java.sql.Date(udom.getTime());
			   //converting  String date vlaue (yyyy-MM-dd) (DOJ) directly to java.sql.Date class obj
			    sqdoj=java.sql.Date.valueOf(sdoj);
				   
			
			//register jdbc driver (optional)
			    //Class.forName("com.mysql.cj.jdbc.Driver");
			  //establish the connection
			   con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root","root");
			   //create PreparedStatement object
			   if(con!=null)
				   ps=con.prepareStatement(DATE_INSERT_QUERY);
			   //set values to query params
			   if(ps!=null) {
				   ps.setString(1,name);
				   ps.setString(2,addrs);
				   ps.setDate(3, sqdob);
				   ps.setDate(4, sqdom);
				   ps.setDate(5, sqdoj);
			   }
			   
			   //execut the SQL query
			   if(ps!=null)
				    count=ps.executeUpdate();
			   //process the Result
			   if(count==0)
				    System.out.println("Record not inserted");
			   else
				   System.out.println("record inserted");
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

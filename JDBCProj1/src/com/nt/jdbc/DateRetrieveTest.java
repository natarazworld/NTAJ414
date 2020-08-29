package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateRetrieveTest {
   private   static final String DATE_RETRIEVE_QUERY="SELECT PID,PNAME,PADDRS,DOB,DOM,DOJ  FROM PERSON_DATE_TAB1  WHERE PID=?";
	public static void main(String[] args) {
		Scanner sc=null;
		int id=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int pid=0;
		String pname=null,paddrs=null;
		java.sql.Date sqdob=null,sqdoj=null,sqdom=null;
		String sdob=null,sdoj=null,sdom=null;
		SimpleDateFormat sdf=null;
	  try {
		  //read inputs
		  sc=new Scanner(System.in);
		  if(sc!=null) {
			  System.out.println("Enter Person Id::");
			  id=sc.nextInt();
		  }
		  
		//register jdbc driver (optional)
		    //Class.forName("com.mysql.cj.jdbc.Driver");
		  //establish the connection
		 //  con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root","root");
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		   //create PreparedStatement object
		   if(con!=null)
			   ps=con.prepareStatement(DATE_RETRIEVE_QUERY);
		   //set values to query params
		   if(ps!=null)
			   ps.setInt(1, id);
		   //execute thq query
		   if(ps!=null)
			   rs=ps.executeQuery();
		   //process the ResultSet obj
		   if(rs!=null) {
			   if(rs.next()) {
				    pid=rs.getInt(1);
				   pname=rs.getString(2);
				   paddrs=rs.getString(3);
				   sqdob=rs.getDate(4);
				   sqdom=rs.getDate(5);
				   sqdoj=rs.getDate(6);
				   //convert java.sql.Date objs values to String date values
				   sdf=new SimpleDateFormat("MMM-yyyy-dd");
				   sdob=sdf.format(sqdob);
				   sdom=sdf.format(sqdom);
				   sdoj=sdf.format(sqdoj);
				   System.out.println(pid+"  "+pname+"   "+paddrs+"  "+sdob+"  "+sdom+"  "+sdoj );
				   System.out.println(pid+"  "+pname+"   "+paddrs+"  "+sqdob+"  "+sqdom+"  "+sqdoj );
			   }
			   else {
				   System.out.println("Record not found");
			   }//else
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

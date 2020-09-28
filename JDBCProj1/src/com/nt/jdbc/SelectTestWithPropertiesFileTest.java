package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class SelectTestWithPropertiesFileTest {

	public static void main(String[] args) {
		System.out.println("SelectTest2.main()");
		Scanner sc=null;
		Connection con=null;
	   Statement st=null;
		int no=0;
		String query=null; 
		ResultSet rs=null;
		
		
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter student number");
				no=sc.nextInt();
			}//if
			
			//Load the properties file Into to java.util.Propertie class object
			InputStream is=new FileInputStream("src/com/nt/commons/jdbc.properties");
			Properties props=new Properties();
			props.load(is);
			System.out.println(props);
			
			//register jdbc driver s/w (optonal)
			Class.forName(props.getProperty("jdbc.driver"));
			//establish the connection
			 con=DriverManager.getConnection(props.getProperty("jdbc.url"),
					                                                             props.getProperty("db.user"),
					                                                             props.getProperty("db.pwd"));
			 //create statement object
			 if(con!=null)
				 st=con.createStatement();
			 //prepare SQL Query
			    //select empno,ename,job,sal from  emp where empno=7499;
			  // query="SELECT EMPNO,ENAME,JOB,SAL FROM  EMP WHERE EMPNO="+no;
			  query="SELECT SNO,SNAME,SADD,AVG FROM  STUDENT WHERE SNO="+no;
			   //send and execute in DB s/w 
			   if(st!=null)
				   rs=st.executeQuery(query);
			   //process the ResultSet obj
			   if(rs!=null) {
				    if(rs.next())
	                      System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getFloat(4));			    	
				    else
				    	System.out.println("No records found");
			   }//if

		}//try
		catch(SQLException se) {  //known exceptions
			se.printStackTrace();
		}
		catch(Exception e) {  //for unknown exceptions
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(sc!=null)
					sc.close();
			}//try
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}//finally

	}// main
}// class

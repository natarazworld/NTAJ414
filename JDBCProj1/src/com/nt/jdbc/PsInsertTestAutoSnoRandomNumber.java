package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class PsInsertTestAutoSnoRandomNumber {
   private static final String  INSERT_STUD_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		int sno=0;
		String name=null,addrs=null;
		float avg=0.0f;
		Connection con=null;
		PreparedStatement ps=null;
		  int count=0;
		  String query=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				
				System.out.println("Enter student name::");
				name=sc.next(); //gives ramesh
				System.out.println("Enter student address::");
				addrs=sc.next();  //gives delhi
				System.out.println("Enter student avg::");
				avg=sc.nextFloat();  //gives 56.77
			}
			
			//register jdbc driver s/w
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///NTAJ414DB","root","root");
			//create Statement object
			if(con!=null)
			    ps=con.prepareStatement(INSERT_STUD_QUERY);
			//set values to query params(?)
			if(ps!=null) {
				ps.setInt(1, new Random().nextInt(100000));  // 0 to 99,999
				ps.setString(2,name);
				ps.setString(3, addrs);
				ps.setFloat(4, avg);
			}
			
			//send and execute SQL query in Db s/w
			if(ps!=null)
				count=ps.executeUpdate();

			//process the 
			if(count==0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record inserted ::"+ count);
			}//try
		catch(SQLException se) {
			if(se.getErrorCode()==12899)
				 System.out.println("u can not insert values more than column size");
			else if(se.getErrorCode()>=900 && se.getErrorCode()<=999) 
				System.out.println(" SQL Query Syntax problem");
			else
				System.out.println("unknow jdbc problem");
			
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

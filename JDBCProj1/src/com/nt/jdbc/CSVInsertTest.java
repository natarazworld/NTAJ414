package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CSVInsertTest {
	 // csv file name as   the db table name
    private static final String CSV_INSERT="INSERT INTO FILE1.CSV  VALUES(?,?,?,?)";  
	public static void main(String[] args) {
	   int sno=0;
	   String name=null,sadd=null;
	   float avg=0.0f;
	   int count=0;
	   Scanner sc=null;
		try {
			sc=new Scanner(System.in);
			 System.out.println("enetr student number::");
			 sno=sc.nextInt();
			 System.out.println("enter student name::");
			 name=sc.next();
			 System.out.println("enter student address::");
			 sadd=sc.next();
			 System.out.println("enter student avg::");
			 avg=sc.nextFloat();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
		
		
		try(Connection con=DriverManager.getConnection("jdbc:Text:///G:/Worskpaces/advjava/NTAJ414")){
			try(PreparedStatement ps=con.prepareStatement(CSV_INSERT)){
			         //set values to query params
				      ps.setInt(1,sno); ps.setString(2,name); ps.setString(3, sadd); ps.setFloat(4,avg);
				      //execute the SQL query
				      count=ps.executeUpdate();
				      //process the result
				      if(count==0)
				    	  System.out.println("record not inserted");
				      else
				    	  System.out.println("record inserted");
			     }//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class

package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertTest {
  private static final String  INSERT_STUDENT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)"; 
	public static void main(String[] args) {
		Scanner sc=null;
		int count=0;
		Connection con=null;
		PreparedStatement ps=null;
		int no=0;
		String name=null, addrs=null;
		float avg=0.0f;
		int result=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
			     System.out.println("Enter students count::");
			     count=sc.nextInt();
			}
			//register JDBC driver s/w
			  // Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			   //create PrepaaredStatement obj having given query as pre-compiled SQL Query
			   if(con!=null)
				   ps=con.prepareStatement(INSERT_STUDENT_QUERY);
			   
			   //read each Student details and set them pre-compiled query parama values for multiple times
			   if(ps!=null && sc!=null) {
				   for(int i=1;i<=count;++i) {
					   //read each student details
					    System.out.println("enter "+ i+" student details");
					    System.out.println("number ::");
					    no=sc.nextInt();
					    System.out.println("name::");
					    name=sc.next();
					    System.out.println("address::");
					    addrs=sc.next();
					    System.out.println("avg::");
					    avg=sc.nextFloat();
					    //set each student details to query param values
					    ps.setInt(1,no);
					    ps.setString(2,name);
					    ps.setString(3,addrs);
					    ps.setFloat(4,avg);
					    //execute the query 
					    result=ps.executeUpdate();
					    //process the result
					    if(result==0)
					    	System.out.println(i+" student details are not inserted");
					    else
					    	System.out.println(i+"student details are inserted");
				   }//for
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

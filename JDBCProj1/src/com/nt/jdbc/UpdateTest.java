package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		String newName=null,newAddrs=null;
		float newAvg=0.0f;
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				 System.out.println("Enter exisiting  student number::");
				 no=sc.nextInt(); //gives 101
				 System.out.println("Enter new Name for  student ::");
				 newName=sc.next(); //gives  king
				 System.out.println("Enter new Address for  student ::");
				 newAddrs=sc.next(); //gives  hyd
				 System.out.println("Enter new  avg for   student ::");
				 newAvg=sc.nextFloat(); //gives  78.88f  
			}//if
			//convert  input values as required for  SQL query
			newName="'"+newName+"'"; //gives 'king' 
			newAddrs="'"+newAddrs+"'"; //gives 'hyd' 
			//register  JDBC driver
			//register JDBC driver
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   //estalish the connection
			   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			   //create JDBC statement object
			   if(con!=null)
				   st=con.createStatement();
			   //prepare SQL query
			      //update  student set sname='suresh',sadd='delhi',avg=67.87 where sno=102
			     query="UPDATE  STUDENT SET SNAME="+newName+",SADD="+newAddrs+",AVG="+newAvg+" WHERE SNO="+no;
			     System.out.println(query);
			     //send and execute SQL query in Db s/w
			     if(st!=null)
			    	   count=st.executeUpdate(query);
			   //process the result
			        if(count==0)
			        	  System.out.println("No Record is updated");
			        else
			        	System.out.println(count+" no.of record(s) are updated");
			
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

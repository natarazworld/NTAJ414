package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {
		Scanner sc=null;
		String city=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter student city(address)");
				city=sc.next(); //gives hyd
			}
			//convert input value as required for the SQL query
			city="'"+city+"'";  //gives  'hyd'
			//register JDBC driver
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   //estalish the connection
			   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			   //create JDBC statement object
			   if(con!=null)
				   st=con.createStatement();
			   //prepare SQL query
			          //delete from student where sadd='hyd'
			     query="DELETE FROM STUDENT WHERE SADD="+city;
			     System.out.println(query);
			     //send and executeSQL query in DB s/w
			     if(st!=null)
			    	 count=st.executeUpdate(query);
			      //process the result
			     if(count==0)
			    	   System.out.println("no records are found to delete");
			     else
			    	 System.out.println(count+" no.of records are deleted");
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

package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {

	public static void main(String[] args) {
		Scanner sc=null;
		String user=null;
		String pass=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		int count=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter username:::");
				user=sc.nextLine();  //gives raja
				System.out.println("Enter Password::");
				pass=sc.nextLine(); //gives rani
			}
			//convert input values as required for the SQL query
			user="'"+user+"'";  //gives 'raja'
			pass="'"+pass+"'"; //gives 'rani'
			//register JDBC driver 
			 // Class.forName("oracle.jdbc.driver.OracleDriver")
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			//create STatement object
			if(con!=null)
				st=con.createStatement();
			//prepare SQL query 
			            // select count(*)  from userInfo where uname='raja' and pwd='rani'
			 query="SELECT COUNT(*)  FROM USERINFO WHERE UNAME="+user+"  AND PWD="+pass;
			 System.out.println(query);
			 //send and execute SQL
			 if(st!=null)
				   rs=st.executeQuery(query);
			 
			 //process the ResultSet obj
			 if(rs!=null){
				  rs.next();
				  //count=rs.getInt(1);
				  count=rs.getInt("count(*)");
			 }
			 //process the ResultSet 
			 if(count==0)
				   System.out.println("Invalid Credentials");
			 else
				 System.out.println(" Valid credentials");
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

package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MysqlInsertTest {

	public static void main(String[] args) {
		Scanner sc=null;
		int sno=0;
		String name=null,addrs=null;
		float avg=0.0f;
		Connection con=null;
		Statement st=null;
		  int count=0;
		  String query=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter student number::");
				sno=sc.nextInt();  //gives 1001
				System.out.println("Enter student name::");
				name=sc.next(); //gives ramesh
				System.out.println("Enter student address::");
				addrs=sc.next();  //gives delhi
				System.out.println("Enter student avg::");
				avg=sc.nextFloat();  //gives 56.77
			}
			//convert input  values as required for the SQL Query
			name="'"+name+"'";  //gives 'ramesh'
			addrs="'"+addrs+"'"; //gives 'delhi'
			
			//register jdbc driver s/w
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish the connection
			//con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root","root");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj414db","root","root");
			//create Statement object
			if(con!=null)
				st=con.createStatement();
			//prepare SQL  query
			// insert into student values(101,'rakesh','hyd',67.88)
			 query="INSERT INTO STUDENT VALUES("+sno+","+name+","+addrs+","+avg+")";
			 System.out.println(query);
			//send and execute SQL query in Db s/w
			if(st!=null)
				count=st.executeUpdate(query);

			//process the 
			if(count==0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record inserted ::"+ count);
			}//try
		catch(SQLException se) {
		
			//se.printStackTrace();
			if(se.getErrorCode()==1)
				 System.out.println("u can not insert duplidates in PK column sno");
			else if(se.getErrorCode()==12899)
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

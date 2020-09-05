package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*CREATE SEQUENCE public."PID_SEQ"
INCREMENT 1
START 1000
MINVALUE 1
MAXVALUE 1000000; */

public class PostgreSqlInsertTest {
    private static final String INSERT_QUERY="INSERT INTO PRODUCT VALUES(nextval('PID_SEQ'),?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		String pname=null;
		float price=0.0f,qty=0.0f;
		Connection con=null;
		PreparedStatement ps=null;
		  int count=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter procut name::");
				pname=sc.next(); //gives ramesh
				System.out.println("Enter product price::");
				price=sc.nextFloat();  //gives delhi
				System.out.println("Enter product qty::");
				qty=sc.nextFloat();  //gives 56.77
			}
		
			//register jdbc driver s/w
			//Class.forName("org.postgresql.Driver");
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ntaj414db","postgres","root");
			//create Statement object
			if(con!=null)
				ps=con.prepareStatement(INSERT_QUERY);
			//set values to query params
			if(ps!=null) {
				ps.setString(1,pname);
				ps.setFloat(2, price);
				ps.setFloat(3, qty);
			}
				
			//send and execute SQL query in Db s/w
			if(ps!=null)
				count=ps.executeUpdate();

			//process the 
			if(count==0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record inserted ");
			}//try
		catch(SQLException se) {
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

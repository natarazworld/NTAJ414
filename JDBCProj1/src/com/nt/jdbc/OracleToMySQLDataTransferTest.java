package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleToMySQLDataTransferTest {
    private static final String ORA_GET_ALL_BANK_ACCOUNTS="SELECT  ACNO,HOLDERNAME,BALANCE FROM JDBC_BANKACCOUNT";
    private static final String MYSQL_INSERT_BANK_ACCOUNT="INSERT INTO JDBC_BANKACCOUNT(ACNO,HOLDERNAME,BALANCE) VALUES(?,?,?)";
    
	public static void main(String[] args) {
		Connection oraCon=null,mysqlCon=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		long acno=0l;
		String name=null;
		float balance=0.0f;
		try {
			//Load jdbc drivers (optional)
			    Class.forName("oracle.jdbc.driver.OracleDriver");
			    Class.forName("com.mysql.cj.jdbc.Driver");
			 //Establish the connections   
			    oraCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			   mysqlCon=DriverManager.getConnection("jdbc:mysql:///ntaj414db", "root", "root");
			   //create STatement objects
			   if(oraCon!=null)
				     st=oraCon.createStatement();
			   if(mysqlCon!=null)
				   ps=mysqlCon.prepareStatement(MYSQL_INSERT_BANK_ACCOUNT);
			   //execute SELECT query in Oracle and get ResultSet object
			   if(st!=null)
				   rs=st.executeQuery(ORA_GET_ALL_BANK_ACCOUNTS);
			   if(ps!=null && rs!=null) {
				   while(rs.next()) {
					   //get each record from oracle db table through ResultSet 
					   acno=rs.getLong(1);
					   name=rs.getString(2);
					   balance=rs.getFloat(3);
					   //set values to PreparedStaement obj query params  (inserting to mysql db table)
					   ps.setLong(1,acno);
					   ps.setString(2, name);
					   ps.setFloat(3, balance);
					   ps.executeUpdate();
				   }//while
				   System.out.println("Records are copied from Oracle DB table to mysql DB table");
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
				if(st!=null)
					st.close();
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
				if(oraCon!=null)
					oraCon.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(mysqlCon!=null)
					mysqlCon.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally

	}//main
}//class

package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseMetaDataTest {

	public static void main(String[] args) {
	   //create JDBC con object
		//try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager")) {
		try(Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj414db", "root", "root")) {
			 //create DatabaaseMetaData obj
			DatabaseMetaData dbmd=null;
			 if(con!=null)
				 dbmd=con.getMetaData();
			 //use DatabaseMetData obj to know more about  underlying DB s/w
			if(dbmd!=null) {
				System.out.println("db name::"+dbmd.getDatabaseProductName());
				System.out.println("db Version::"+dbmd.getDatabaseMajorVersion()+"."+dbmd.getDatabaseMinorVersion());
				System.out.println("db complete name with version"+dbmd.getDatabaseProductVersion());
				System.out.println(" max row size:: "+dbmd.getMaxRowSize());
				System.out.println(" Max cols in db table ::"+dbmd.getMaxColumnsInTable());
				System.out.println(" Max cols in select SQL query ::"+dbmd.getMaxColumnsInSelect());
				System.out.println("supports PL/SQL procedures:: "+dbmd.supportsStoredProcedures());
				System.out.println("all Numberic functions::"+dbmd.getNumericFunctions());
				System.out.println("all SQL keywords::"+dbmd.getSQLKeywords());
				System.out.println("schema term::"+dbmd.getSchemaTerm());
			}//if
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main
}//class

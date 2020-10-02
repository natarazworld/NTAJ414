package com.nt.jdbc;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CachedRowSetTest {

	public static void main(String[] args) {
	   try(OracleCachedRowSet crowset=new OracleCachedRowSet()) {
		   //set jdbc propeties  
		   crowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		     crowset.setUsername("system");
		     crowset.setPassword("manager");
		    //set SQL Query
		     crowset.setCommand("SELECT SNO,SNAME,SADD,AVG FROM STUDENT");
		    // crowset.setMaxRows(4);
		     //execut the SQL query
		     crowset.execute();
		     //process the RowSet
		     crowset.setReadOnly(false);
		     while(crowset.next()) {
				 System.out.println(crowset.getInt(1)+"  "+crowset.getString(2)+"  "+crowset.getString(3)+"  "+crowset.getFloat(4));
		     }
		     System.out.println(".................Stop DB s/w.............................");
		     Thread.sleep(40000);
		     crowset.absolute(4);  
		     crowset.updateString(3,"newyork");
		     crowset.updateRow();  //This  is called offline/disconnected data processing
		     System.out.println(".................Start DB s/w.............................");
		     Thread.sleep(40000);
		     //process the RowSet
		     crowset.acceptChanges();
		     while(crowset.next()) {
				 System.out.println(crowset.getInt(1)+"  "+crowset.getString(2)+"  "+crowset.getString(3)+"  "+crowset.getFloat(4));
		     }
	   }//try
	   catch(SQLException se) {
		   se.printStackTrace();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }

	}//main
}//class

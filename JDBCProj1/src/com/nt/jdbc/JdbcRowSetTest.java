package com.nt.jdbc;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JdbcRowSetTest {

	public static void main(String[] args) {
	   try(OracleJDBCRowSet jrowset=new OracleJDBCRowSet()) {
		   //set jdbc propeties  
		   jrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		     jrowset.setUsername("system");
		     jrowset.setPassword("manager");
		    //set SQL Query
		     jrowset.setCommand("SELECT SNO,SNAME,SADD,AVG FROM STUDENT");
		     jrowset.setMaxRows(4);
		     //execut the SQL query
		     jrowset.execute();
		     //process the RowSet
		     //int count=0;
		     while(jrowset.next()) {
				/* jrowset.refreshRow();
				 if(count==0)
					 Thread.sleep(40000);*/
		    	 
		    	 System.out.println(jrowset.getInt(1)+"  "+jrowset.getString(2)+"  "+jrowset.getString(3)+"  "+jrowset.getFloat(4));
		      // count++;
		     }
		     jrowset.absolute(3);
			 System.out.println(jrowset.getRow()+" -->"+jrowset.getInt(1)+"  "+jrowset.getString(2)+"  "+jrowset.getString(3)+"  "+jrowset.getFloat(4));
			 jrowset.updateString(3,"dubai");
			 jrowset.updateRow();
			 System.out.println(jrowset.getRow()+" -->"+jrowset.getInt(1)+"  "+jrowset.getString(2)+"  "+jrowset.getString(3)+"  "+jrowset.getFloat(4));
	   }//try
	   catch(SQLException se) {
		   se.printStackTrace();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }

	}//main
}//class

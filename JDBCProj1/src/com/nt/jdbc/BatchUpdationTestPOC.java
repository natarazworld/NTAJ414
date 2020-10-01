package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdationTestPOC {

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager")) {
			//create JDBC Statement object
			if(con!=null)
			    try(Statement st=con.createStatement()) {
			    	 if(st!=null) {
				     //add queries to the batch
			    	  st.addBatch("insert into student values(101,'karan','hyd',78.99f)");
			    	  st.addBatch("insert into student values(202,'suresh','vizag',98.99f)");
			    	  st.addBatch("update student set avg=avg+5 where sno>=1000");
			    	  st.addBatch("delete from student where  sno<=100");
			    	  //excute batch
			    	  int result[]=st.executeBatch();
			    	  //process the result[]
			    	  int total=0;
			    	  for(int i=0;i<result.length;++i) {
			    		  total=total+result[i];
			    		  System.out.println(i+1+" query of batch has effected "+result[i]+ "records" );
			    	  }
			    	    System.out.println("no.of records that are effected are ::"+total);
			    	 }//if
			   }//try
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class

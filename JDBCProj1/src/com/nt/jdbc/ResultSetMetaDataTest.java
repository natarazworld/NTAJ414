package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataTest {
   private static final String GET_ALL_STUDENTS_QUERY="SELECT SNO,SNAME,AVG,SADD FROM STUDENT";
	public static void main(String[] args) {
		
			//establish the connection
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager")){
			//create Statement object
			if(con!=null)
				try(PreparedStatement ps=con.prepareStatement(GET_ALL_STUDENTS_QUERY)){
			//create ResultSet object (scrollable)
			if(ps!=null)
			  try(ResultSet rs=ps.executeQuery()){
				//create ResultSetMetaData obj
				  ResultSetMetaData rsmd=null;
				  if(rs!=null) 
         			 rsmd=rs.getMetaData();
         	
         		int count=0;
         		if(rsmd!=null) {
         			count=rsmd.getColumnCount();
         			//print col names
         			for(int i=1;i<=count;++i) 
         				System.out.print(rsmd.getColumnLabel(i)+"   ");
         			
         			System.out.println();
         			//print col data types
         			for(int i=1;i<=count;++i) 
         				System.out.print(rsmd.getColumnTypeName(i)+"   ");
         			
         			System.out.println();
         		}//if
         		
         		
		    	if(rs!=null) {
			    	while(rs.next()) {
					   for(int i=1;i<=count;++i) {
						   System.out.print(rs.getString(i)+"  ");
					   }
					   System.out.println(); //new line
				}//while
			}//if
		    	//Getting more info about db table cols
		    	for(int i=1;i<=rsmd.getColumnCount();++i) {
		    		System.out.println("col index ::"+i);
		    		System.out.println("col name::"+rsmd.getColumnLabel(i));
		    		System.out.println("col data type name::"+rsmd.getColumnTypeName(i));
		    		System.out.println("col scale ::"+rsmd.getScale(i));
		    		System.out.println("col precision ::"+rsmd.getPrecision(i));
		    		System.out.println("col is nullable?"+rsmd.isNullable(i));
		    		System.out.println("col is case-sensitive?"+rsmd.isCaseSensitive(i));
		    		System.out.println("col is AutoIncrement?"+rsmd.isAutoIncrement(i));
		    		System.out.println("--------------------------");
		    	}//for
		    	
			  }//try3
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	 }//method
}//class

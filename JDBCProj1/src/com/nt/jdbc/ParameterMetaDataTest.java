package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ParameterMetaDataTest {
   private static final String GET_ALL_STUDENTS_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";
	public static void main(String[] args) {
		
			//establish the connection
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager")){
			//create Statement object
			if(con!=null)
				try(PreparedStatement ps=con.prepareStatement(GET_ALL_STUDENTS_QUERY)){
					//create ParameterMetaData object
					ParameterMetaData pmd=null;
					if(ps!=null)
					    pmd=ps.getParameterMetaData();
					//get more info about parameters
					int count=pmd.getParameterCount();
					System.out.println(count);
					for(int i=1;i<=count;++i) {
						System.out.println("parameter number::"+i);
						System.out.println("parameter mode::"+pmd.getParameterMode(i));
						System.out.println("parmater type name::"+pmd.getParameterTypeName(i));
						System.out.println("parameter scale ::"+pmd.getScale(i));
						System.out.println("parameter precision::"+pmd.getPrecision(i));
					}//if
					
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

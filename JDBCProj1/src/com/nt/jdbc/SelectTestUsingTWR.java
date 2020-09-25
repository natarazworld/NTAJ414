package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTestUsingTWR {

	public static void main(String[] args) {
		  
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager")) {
			try(Statement st=con.createStatement()){
				try(ResultSet rs=st.executeQuery("SELECT SNO,SNAME,SADD,AVG FROM STUDENT")){
					   while(rs.next()) {
						   System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getFloat(4));
					   }//while
				}//try3
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    
	}//main
}//class

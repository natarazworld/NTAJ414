package com.nt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class PooledConnTest {

	public static void main(String[] args) {
		OracleConnectionPoolDataSource ds=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			ds=new OracleConnectionPoolDataSource();
			ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ds.setUser("system");
			ds.setPassword("manager"); //use all these details and creates jdbc con pool having initial  4 jdbc con objs(default)
			//get pooled jdbc con obj
			con=ds.getConnection();
			//create Statement obj
			st=con.createStatement();
			//send and execute SQL query
			 rs=st.executeQuery("SELECT SNO,SNAME,SADD,AVG FROM STUDENT");
			//process the RS
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
			}//while
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
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
				if(con!=null)
					con.close();   //releases the jdbc con object back to jdbc con pool
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}//finally 
	}//main
}//class

package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableRSTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int count=0;
		try {
			//establish the connection
			//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root", "root");
			//create Statement object
			if(con!=null)
				  st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						                                        ResultSet.CONCUR_UPDATABLE);
			   st.setMaxRows(3);
             
			
			
			//create ResultSet object (scrollable)
			if(st!=null) {
			rs=st.executeQuery("SELECT SNO,SNAME,SADD,AVG FROM STUDENT");
			}
			
			
			System.out.println(" Scrollable RS created....");
			
			if(rs!=null) {
				while(rs.next()) {
					rs.refreshRow();
					/*					if(count==0)
											Thread.sleep(30000);  //during this period  modify DB table records  from SQL prompt/developer
					*/					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getFloat(4));
					count++;
				}//while
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
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally

	}//method
}//class

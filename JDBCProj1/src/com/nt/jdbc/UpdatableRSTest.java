package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableRSTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			//create Statement object
			if(con!=null)
				  st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						                                        ResultSet.CONCUR_UPDATABLE);
			//create ResultSet object (scrollable)
			if(st!=null)
			rs=st.executeQuery("SELECT SNO,SNAME,SADD,AVG FROM STUDENT");
		//process RS	
			if(rs!=null) {
				//read operation
				/*				System.out.println("Read Operation");
								while(rs.next()) {
									System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getFloat(4));
								}//while
				*/
				/*System.out.println("..........insert operation...................");
				//insert operation
				rs.moveToInsertRow();  //create empty record
				rs.updateInt(1,4567);
				rs.updateString(2, "amitab");
				rs.updateString(3, "hyd");
				rs.updateFloat(4, 89.55f);
				rs.insertRow();  //inserts the record
				*/				
				
				/*System.out.println("..........update operation...................");
				//update  operation
				rs.absolute(4);
				rs.updateString(2, "smallB");
				rs.updateRow(); //updates the record
				*/
				
				System.out.println("..........delete operation...................");
				//delete operation
				rs.absolute(4);
				rs.deleteRow(); //deletes the record
				
				
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

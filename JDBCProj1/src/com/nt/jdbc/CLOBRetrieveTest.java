package com.nt.jdbc;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

/*
 CREATE TABLE `ntaj414db`.`naukri_profile_tab` (
  `regNo` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NULL,
  `addrs` VARCHAR(25) NULL,
  `qlfy` VARCHAR(25) NULL,
  `resume` LONGTEXT NULL,
  PRIMARY KEY (`regNo`)); 
*/
public class CLOBRetrieveTest {
    private  static final String RETRIEVE_CLOB_QUERY="SELECT REGNO,NAME,ADDRS,QLFY,RESUME  FROM NAUKRI_PROFILE_TAB WHERE REGNO=?";
	public static void main(String[] args) {
     		Scanner sc=null;
     		String name=null,addrs=null,qlfy=null,resumeLocation=null;
     		Connection con=null;
     		Reader reader=null;
     		PreparedStatement ps=null;
     		ResultSet rs=null;
     		Writer writer=null;
     		int regNo=0;
		try {
        //read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter job seeker regNo::");
				regNo=sc.nextInt();
				
			}
			 //establish the connection
			 //con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root","root");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedStatement object having pre-compiled SQL query
				if(con!=null)
					ps=con.prepareStatement(RETRIEVE_CLOB_QUERY);
				
				//set query param vallues
				if(ps!=null) 
					ps.setInt(1, regNo);
				
				//execute the query
				if(ps!=null)
				   rs=ps.executeQuery();
				//process the ResultSet
				if(rs!=null) {
					if(rs.next()) {
						regNo=rs.getInt(1);
						name=rs.getString(2);
						addrs=rs.getString(3);
						qlfy=rs.getString(4);
						reader=rs.getCharacterStream(5);
						//create Writer Stream pointing to dest file
						if(reader!=null) 
						    writer=new FileWriter("new_resume.txt");
						//copy reader resume text data to  write destination file
						if(reader!=null && writer!=null) {
							IOUtils.copy(reader,writer);
							System.out.println(regNo+"  "+name+"  "+addrs+"  "+qlfy);
						    System.out.println("Resume retrieved");	
						}//if
					}//if
					else {
						System.out.println("Record not found");
					}//else
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
				if(ps!=null)
					ps.close();
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
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(reader!=null)
					reader.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(writer!=null)
					writer.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
	}//main
}//class

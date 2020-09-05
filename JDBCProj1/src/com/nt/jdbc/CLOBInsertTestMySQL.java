package com.nt.jdbc;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
 CREATE TABLE `ntaj414db`.`naukri_profile_tab` (
  `regNo` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NULL,
  `addrs` VARCHAR(25) NULL,
  `qlfy` VARCHAR(25) NULL,
  `resume` LONGTEXT NULL,
  PRIMARY KEY (`regNo`)); 
*/
public class CLOBInsertTestMySQL {
    private  static final String INSERT_CLOB_QUERY="INSERT INTO NAUKRI_PROFILE_TAB(NAME,ADDRS,QLFY,RESUME) VALUES(?,?,?,?)";
	public static void main(String[] args) {
     		Scanner sc=null;
     		String name=null,addrs=null,qlfy=null,resumeLocation=null;
     		Connection con=null;
     		Reader reader=null;
     		PreparedStatement ps=null;
     		int count=0;
		try {
        //read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter job seeker name::");
				name=sc.next();
				System.out.println("enter job seeker addrs::");
				addrs=sc.next();
				System.out.println("enter job seeker qualification::");
				qlfy=sc.next();
				System.out.println("enter job seeker resume location::");
				resumeLocation=sc.next();
			}
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root","root");
			 //create Reader Stream (character stream) representing  text file data..
				reader=new FileReader(resumeLocation);
			//create PreparedStatement object having pre-compiled SQL query
				if(con!=null)
					ps=con.prepareStatement(INSERT_CLOB_QUERY);
				//set query param vallues
				if(ps!=null) {
					ps.setString(1, name);
					ps.setString(2, addrs);
					ps.setString(3,qlfy);
					ps.setCharacterStream(4,reader);
				}
				//execute the query
				if(ps!=null)
				  count=ps.executeUpdate();
				//process the results
				if(count==0)
					 System.out.println("Record not inserted");
				else
					System.out.println("record inserted");
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
		}//finally
	}//main
}//class

package com.nt.jdbc;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*CREATE TABLE "SYSTEM"."NAUKRI_PROFILE_TAB" 
(	"REGNO" NUMBER(6,0) NOT NULL ENABLE, 
	"NAME" VARCHAR2(20 BYTE), 
	"ADDRS" VARCHAR2(20 BYTE), 
	"QLFY" VARCHAR2(20 BYTE), 
	"RESUME" CLOB, 
	 CONSTRAINT "NAUKRI_PROFILE_TAB_PK" PRIMARY KEY ("REGNO"));
	 
	  CREATE SEQUENCE  "SYSTEM"."NAUKRI_ID_SEQ"  MINVALUE 1 MAXVALUE 1000000 INCREMENT BY 1 START WITH 1
*/
public class CLOBInsertTestOracle {
    private  static final String INSERT_CLOB_QUERY="INSERT INTO NAUKRI_PROFILE_TAB VALUES(NAUKRI_ID_SEQ.NEXTVAL,?,?,?,?)";
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
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
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

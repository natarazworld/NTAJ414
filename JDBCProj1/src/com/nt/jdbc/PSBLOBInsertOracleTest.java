package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*CREATE TABLE "SYSTEM"."ARTIST_INFO" 
(	"ARTISID" NUMBER(10,0) NOT NULL ENABLE, 
	"ARTISTNAME" VARCHAR2(20 BYTE), 
	"ARTISTADDRS" VARCHAR2(20 BYTE), 
	"INCOME" FLOAT(126), 
	"PHOTO" BLOB, 
	"VIDEO" BLOB, 
	 CONSTRAINT "ARTIST_INFO_PK" PRIMARY KEY ("ARTISID")) ;
	 
	 CREATE SEQUENCE  "SYSTEM"."ARTIST_ID_SEQ"  MINVALUE 1 MAXVALUE 1000000 INCREMENT BY 1 START WITH 1;
	  */


public class PSBLOBInsertOracleTest {
  private static final String ARTIST_INSERT_QUERY="INSERT INTO ARTIST_INFO VALUES(ARTIST_ID_SEQ.NEXTVAL,?,?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		String  name=null,addrs=null,photoLocation=null, videoLocation=null;
		float income=0.0f;
		InputStream photoIS=null, videoIS=null; 
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//read inputs
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Artist name::");
				name=sc.next();
				System.out.println("Enter Artist address::");
				addrs=sc.next();
				System.out.println("Enter Artist income::");
				income=sc.nextFloat();
				System.out.println("Enter Artist photoLocation::");
				photoLocation=sc.next();
				System.out.println("Enter Artist Video Location::");
				videoLocation=sc.next();
			}
			//create InputSTreams rerpresenting   photo file and vedio file
			 photoIS=new FileInputStream(photoLocation);
			 videoIS=new FileInputStream(videoLocation);
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			 //create PreparedStatement obj
			 if(con!=null)
				 ps=con.prepareStatement(ARTIST_INSERT_QUERY);
			 //set values to query params
			 if(ps!=null) {
				 ps.setString(1,name);
				 ps.setString(2,addrs);
				 ps.setFloat(3,income);
				 ps.setBinaryStream(4, photoIS);
				 ps.setBinaryStream(5, videoIS);
			 }
			 //execute the query
			 if(ps!=null)
				 count=ps.executeUpdate();
			 
			 //process the result
			 if(count==0)
				 System.out.println("record not inserted");
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
				if(photoIS!=null)
					photoIS.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(videoIS!=null)
					videoIS.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally

	}//main
}//class

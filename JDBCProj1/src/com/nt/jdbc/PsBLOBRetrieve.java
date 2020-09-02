package com.nt.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class PsBLOBRetrieve {
   private static final String GET_ARTIST_DETAILS_BY_ID="SELECT ARTISTID,ARTISTNAME,ARTISTADDRS,INCOME,PHOTO,VIDEO   FROM ARTIST_INFO  WHERE ARTISTID=?";
	public static void main(String[] args) {
		Scanner sc=null;
		int id=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String name=null,addrs=null;
		float income=0.0f;
		InputStream photoIS=null,videoIS=null;
		OutputStream photoOS=null,videoOS=null;
		
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter ArtistId::");
				id=sc.nextInt();
			}
			// establish the connection
			//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root","root");
			//create PreparedStatement object
			if(con!=null)
				ps=con.prepareStatement(GET_ARTIST_DETAILS_BY_ID);
			//set value to query parameter
			if(ps!=null)
				ps.setInt(1,id);
			//execute the query
			if(ps!=null) 
				rs=ps.executeQuery();
			 //process the ResultSet obj
			  if(rs!=null) {
				   if(rs.next()) {
					   id=rs.getInt(1);
					   name=rs.getString(2);
					   addrs=rs.getString(3);
					   income=rs.getFloat(4);
					   photoIS=rs.getBinaryStream(5);
					   videoIS=rs.getBinaryStream(6);
					   System.out.println(id+"  "+name+"  "+addrs+"  "+income);
					   photoOS=new	   FileOutputStream("new_pict.jpg");
					   videoOS=new FileOutputStream("new_video.mp4");
					   //copy InputStreams content to output streams
					   if(photoIS!=null && videoIS!=null ) {
						   IOUtils.copy(photoIS,photoOS);
						   IOUtils.copy(videoIS,videoOS);
					   }
					   System.out.println("BLOB values are retrived and stored into files");
				   }
				   else {
					   System.out.println("record not found");
				   }
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
			
			try {
				if(videoOS!=null)
					videoOS.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(photoOS!=null)
					photoOS.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}//finally

	}//main
}//class

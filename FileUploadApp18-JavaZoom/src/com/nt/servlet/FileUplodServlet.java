package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

@WebServlet("/uploadurl")
public class FileUplodServlet extends HttpServlet {
	private static final String  INSERT_PERSON_PROFILE="INSERT INTO PERSON_PROFILE VALUES(PID_SEQUENCE.NEXTVAL,?,?,?,?)";
	@Resource(name="DsJndi")
	private   DataSource ds;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String  resumeLocation="E:/upload/resumes/";
		String  photoLocation="E:/upload/photos/";
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		String name=null,addrs=null,resumeFilePath=null,photoFilePath=null;
		boolean uploadFlag=false;
		try {
    		//create Special Request object   which holds  form data and upload files as streams
	    	  MultipartFormDataRequest nreq=new MultipartFormDataRequest(req);
	    	  //read form data
	    	   name=nreq.getParameter("name");
	    	   addrs=nreq.getParameter("addrs");
	    	  //Specify  upload load location in server machine file system
	    	  UploadBean upb=new UploadBean();
	    	  //file uploading restrictions
	    	  upb.setMaxfiles(5);
	    	  upb.setFilesizelimit(10*1024);
	    	  upb.setOverwrite(true);
	    	  upb.setBlacklist("install.exe,setup.exe,abc.jpg");
	    	  upb.setFolderstore(resumeLocation);
	    	  upb.store(nreq,"resume");  //completes resume uploading
	    	  upb.setFolderstore(photoLocation);
	    	  upb.store(nreq,"photo");  //completes  photo uploading
	    	   //get All Uploaded filenames
                Vector vector=upb.getHistory();
                //get uploaded file names
                resumeFilePath=resumeLocation+((UploadParameters)vector.get(0)).getFilename();  //gives E:/upload/resumes/resume.txt
                photoFilePath=photoLocation+((UploadParameters)vector.get(1)).getFilename();  //gives E:/upload/photos/photo.jpg
                pw.println("<br><b>"+((UploadParameters)vector.get(0)).getFilename()+"  "+((UploadParameters)vector.get(1)).getFilename()+"files are uploaded</b>");
                uploadFlag=true;
		}
		catch(Exception e) {
			uploadFlag=false;
			pw.println("<h1>Problem in file uploading-->"+e.getMessage()+"</h1>");
			e.printStackTrace();
		}
		if(uploadFlag) {
                //write  JDBC code..
                //get  pooled Connection object
                  try(Connection con=ds.getConnection()){
                  //create Prepared Statement obj
                  try(PreparedStatement ps=con.prepareStatement(INSERT_PERSON_PROFILE)){
                	  //set values to query params
                	  ps.setString(1, name);
                	  ps.setString(2, addrs);
                	  ps.setString(3,resumeFilePath);
                	  ps.setString(4,photoFilePath);
                	  //execute the Query
                	  int result=ps.executeUpdate();
                	  //process the Result
                	  if(result==0)
                		  pw.println("<h1 style='color:red;text-align:center'> Registration not completed </h1>");
                	  else
                		  pw.println("<h1 style='color:red;text-align:center'> Registration  completed </h1>");
                  }//try2
               }//try1
		catch(Exception e) {
			e.printStackTrace();
  		  pw.println("<h1 style='color:red;text-align:center'> Problem Person Registration</h1>");
		  }
		}//if
		else {
			pw.println("<h1 style='color:red;text-align:center'> Problem File uploading</h1>");
		}
                  //add home hyperlink
                  pw.println("<br><br> <a href='upload.html'>home </a>");
                  //close stream
                  pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
	
}//class

package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.tomcat.util.http.fileupload.IOUtils;


@WebServlet("/downloadurl")
public class FileDownloadServlet extends HttpServlet {
	@Resource(name="DsJndi")
   private  DataSource ds;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//read  addtional req param values
		int id=Integer.parseInt(req.getParameter("id"));
		String type=req.getParameter("type");
		//decide the SQL query to get file to downloaded location from  DB table column
		String query=null;
		if(type.equalsIgnoreCase("resume")) 
			query="SELECT RESUME FROM PERSON_PROFILE WHERE PID=?";
		else
			query="SELECT PHOTO FROM PERSON_PROFILE WHERE PID=?";
		//get pooled Connection
		String  filePath=null;
		try(Connection con=ds.getConnection()){
			//create PreparedStatement obj
			try(PreparedStatement ps=con.prepareStatement(query)){
				//set value to query params
				   ps.setInt(1, id);
				   //execute the SQL query
				try(ResultSet rs=ps.executeQuery()){
					//process the RS
					if(rs.next()) 
						filePath=rs.getString(1);
				}//try3
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//Write file downloading (resource downloadig logic)
		try {
			//create java.io.File obj   pointing to FTBD(FileToBDownloaded)
			File file=new File(filePath);
			//get the length of FTBD and make it response content  length
			res.setContentLengthLong(file.length());
			//get the MIME type of FTDB and make it response content  type
			 ServletContext sc=getServletContext();
			 String mimeType=sc.getMimeType(filePath);
			 mimeType=(mimeType==null)?"application/octet-stream":mimeType;
			 res.setContentType(mimeType);
			 //create InputStream ponting to  FTBD
			 InputStream is=new FileInputStream(file);
			 //create OutputStream pointing to  response obj
			 ServletOutputStream sos=res.getOutputStream();
			 //add response header "Content-Disposition" having value "attachment" for downloading the file
			 res.addHeader("Content-Disposition","attachment;fileName="+file.getName());
			 //copy FTBD content to response object
			 IOUtils.copy(is,sos);
			 //close streams
			 is.close();
			 sos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}//doPost(-,-)

}//class

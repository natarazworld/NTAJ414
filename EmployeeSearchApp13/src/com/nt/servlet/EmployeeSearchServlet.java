package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {
	 private static final String GET_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 int no=0;
	    //get PrintWriter
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 Connection con=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 try {
		 //read form data
		 no=Integer.parseInt(req.getParameter("eno"));
		 //write jdbc code
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the connection
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");	 
		 //create PreparedStatement obj having pre-compiledSQL query
		 if(con!=null)
		   ps=con.prepareStatement(GET_EMP_DETAILS);
		 
		 if(ps!=null) {
		   //set values to query param
		   ps.setInt(1, no);
		   //execute query
		   rs=ps.executeQuery();
		 }
		 //process the RS object
		 if(rs!=null) {
			  if(rs.next()) {
				  pw.println("<h1 style='color:blue;text-align:center'>Employee details are </h1>");
				  pw.println("<br><b> Emp number:: "+rs.getInt(1)+"</b>");
				  pw.println("<br><b> Emp name:: "+rs.getString(2)+"</b>");
				  pw.println("<br><b> Emp Desg:: "+rs.getString(3)+"</b>");
				  pw.println("<br><b> Emp Salary:: "+rs.getFloat(4)+"</b>");
			  }
			  else {
				  pw.println("<h1 style='color:red;text-align:center'>Employee not found </h1>");
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
		  }//finally
		 pw.println("<br><br> <a href='input.html'>home </a>");
		 
		 //close stream
		 pw.close();
	
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}//doPost(-,-)

}

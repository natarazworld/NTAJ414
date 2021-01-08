package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/employeeurl",initParams = {@WebInitParam(name="driverClass",value="oracle.jdbc.driver.OracleDriver"),
		                                                                                 @WebInitParam(name="jdbcUrl", value="jdbc:oracle:thin:@localhost:1521:xe"),
		                                                                                 @WebInitParam(name="dbuser", value="system"),
		                                                                                 @WebInitParam(name="dbpwd",value="manager"),
		                                                                                  })
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
		//include header content
			 RequestDispatcher rd1=req.getRequestDispatcher("/headerurl");
			 rd1.include(req, res);
			 
			 //code  for boddy content
		 //read form data
		 no=Integer.parseInt(req.getParameter("eno"));
		 //get Access to Servletconfig obj
		 ServletConfig  cg=getServletConfig();
		 String driver=cg.getInitParameter("driverClass");
		 String url =cg.getInitParameter("jdbcUrl");
		 String username=cg.getInitParameter("dbuser");
		 String pwd=cg.getInitParameter("dbpwd");
		 //write jdbc code
			 Class.forName(driver);
			 //establish the connection
		 con=DriverManager.getConnection(url,username,pwd);	 
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
		 pw.println("<br><br> <a href='input.html'>home </a>");
		 //include footer content
		 RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
		 pw.close();
		 rd2.include(req, res);
		 }//try
		 catch(Exception e) {
			 pw.println("<b>EmployeeSearchServlet.doGet():: before rd.forward(req,res)</b>");
               System.out.println("EmployeeSearchServlet.doGet():: before rd.forward(req,res)");
               //-------------- servlet as error servlet ------------------
			//RequestDispatcher rd=req.getRequestDispatcher("errorurl");
              ServletContext sc=getServletContext();
              RequestDispatcher rd=sc.getRequestDispatcher("/errorurl");
              rd.forward(req, res);
              //RequestDispatcher rd=sc.getNamedDispatcher("err");
              //--------------jsp file as error page ----------------
              //RequestDispatcher rd=sc.getRequestDispatcher("/error.jsp");
              //RequestDispatcher rd=sc.getRequestDispatcher("/errJspurl");
              //RequestDispatcher rd=sc.getNamedDispatcher("errJsp");
              //---------------html file as error page -----------------------
              //RequestDispatcher  rd=sc.getRequestDispatcher("/my_error.html");
              //RequestDispatcher  rd=sc.getRequestDispatcher("/errHtmlUrl");
				/*    RequestDispatcher  rd=sc.getNamedDispatcher("errHtml");
				rd.forward(req, res);
				System.out.println("EmployeeSearchServlet.doGet():: after rd.forward(req,res)");
				pw.println("<b>EmployeeSearchServlet.doGet():: after rd.forward(req,res)</b>");*/
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
	
		 
		 //close stream
		 pw.close();
	
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}//doPost(-,-)

}

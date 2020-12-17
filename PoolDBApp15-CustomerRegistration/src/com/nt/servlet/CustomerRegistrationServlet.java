package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerRegistrationServlet extends HttpServlet {
	  private static final String INSERT_CUSTOMER_QUERY="INSERT INTO CUSTOMER VALUES(CNO_SEQ.NEXTVAL,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  //get PrintWriter obj
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String cname=req.getParameter("cname");
		String cadd=req.getParameter("cadd");
		float billAmt=Float.parseFloat(req.getParameter("billAmt"));
		try(Connection con=getPooledJdbcConnection("DsJndi")) {
		 if(con!=null)
			 try(PreparedStatement ps=con.prepareStatement(INSERT_CUSTOMER_QUERY)){
				if(ps!=null) {
				//set values to query params
			 	ps.setString(1, cname);
				ps.setString(2,cadd);
				ps.setFloat(3,billAmt);
				//excecute the query
				int result=ps.executeUpdate();
				//process the result
				if(result==0)
					pw.println("<h1 style='color:red;text-align:center'>Problem in record insertion </h1>");
				else
					pw.println("<h1 style='color:red;text-align:center'>Customer Registered successfully </h1>");
				}
			}//try2
		}//try1
		catch(Exception e) {
			pw.println("<h1 style='color:red;text-align:center'>Problem in record insertion </h1>");
			e.printStackTrace();
		}
		//add home hyperlink
		pw.println("<br> <a href='input.html'>home</a>");
		// close stream
		pw.close();
		}//doGet(-,-)
	
	//helper method for other methods of the same class
	  private Connection  getPooledJdbcConnection(String jndiName) throws Exception{
		  //create InitialContext obj to establish the connection  Jndi registry
		  InitialContext ic=new InitialContext();
		  //get Datasource obj through lookup operation
		  DataSource ds=(DataSource)ic.lookup(jndiName); 
		  //get Pooled jdbc con object
		  Connection con=ds.getConnection();
		  return con;
	  }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         doGet(req,res);
	}

}

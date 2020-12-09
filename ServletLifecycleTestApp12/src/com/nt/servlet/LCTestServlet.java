package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LCTestServlet extends HttpServlet {
	
	static {
		System.out.println("LCTestServlet:: static block");
	}
	
	public LCTestServlet() {
		System.out.println("LCTestServlet.0-param constructor");
	}
	 
	public   void init(ServletConfig cg) throws ServletException {
	      super.init(cg);	
		System.out.println("LCTestServlet.init(-)(1 param)");
		System.out.println("db user init param value::"+cg.getInitParameter("dbuser"));
		System.out.println("db pwd init param value::"+cg.getInitParameter("dbpwd"));
	}
	
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  
		  System.out.println("LCTestServlet.service(-,-) 2nd");
		  //get PrintWriter 
		  PrintWriter pw=res.getWriter();
		  //set response content type
		  res.setContentType("text/html");
		  //write b.logic
		  pw.println("<h1 style='color:red;text-align:center'>Date and Time ::"+new java.util.Date()+"</h1>");
			ServletConfig cg=getServletConfig();
			 pw.println("<br>db user init param value::"+cg.getInitParameter("dbuser"));
				pw.println("<br>db pwd init param value::"+cg.getInitParameter("dbpwd"));
		  //close stream
		  pw.close();
		  
	}//service(-,-)
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		  
		  System.out.println("LCTestServlet.service(-,-)1st");
		  //get PrintWriter 
		  PrintWriter pw=res.getWriter();
		  //set response content type
		  res.setContentType("text/html");
		  //write b.logic
		  pw.println("<h1 style='color:red;text-align:center'>Date and Time ::"+new java.util.Date()+"</h1>");
			ServletConfig cg=getServletConfig();
			 pw.println("<br>db user init param value::"+cg.getInitParameter("dbuser"));
				pw.println("<br>db pwd init param value::"+cg.getInitParameter("dbpwd"));
		  //close stream
		  pw.close();
		  
	}//service(-,-)
	
	
	
	@Override
	public void destroy() {
	  System.out.println("LCTestServlet.destroy()");
	}
	
	

}//class

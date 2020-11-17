package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCapitalServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     //get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data 
		 int countryCode=Integer.parseInt(req.getParameter("country"));
		 //write b.logic /request processing logic
		 String capitals[]=new String[] {"New Delhi","Bejing","WashingtonDC","Berlin","Tokyo"};
		 //write response /output to  response obj
		 pw.println("<h1 style='color:red;text-align:center'> Capital City name is ::"+capitals[countryCode]+"</h1>");
		 //add home hyperlink
		 pw.println("<br><a href='input.html'>home</a>");
		 //close stream
		 pw.close();
	}//doPost(-,-)
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doPost(req,res);
	}//doGet(-,-)
	

}//class

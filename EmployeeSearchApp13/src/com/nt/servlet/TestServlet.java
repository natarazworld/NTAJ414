package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//get AccessServletConfig obj
		 ServletConfig cg=getServletConfig();
		 pw.println("<br> TestServlet::  dbuser init param value:: "+cg.getInitParameter("dbuser"));
		 pw.println("<br>  SErvlet class object name::"+cg.getServletName());
		 pw.println("<br>  SErvletConfig  object class name::"+cg.getClass());
		 //close stream
		 pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	
	}
	
}

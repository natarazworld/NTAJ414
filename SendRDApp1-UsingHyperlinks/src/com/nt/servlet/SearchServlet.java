package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=null;
		//get PrintWriter
	  pw=res.getWriter();
	  //set response content type
	  res.setContentType("text/html");
	  //read form data
	  String ss=req.getParameter("ss");
	  //add  hyperlink to the web page  to perform sendRedirection
	  pw.println("<a href='https://www.google.com/search?q="+ss+"'>Go to Google </a>");
		//close stream
	  pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          doGet(req,res);
	}

}

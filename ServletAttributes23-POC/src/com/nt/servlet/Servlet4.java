package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s4url")
public class Servlet4 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read and display request attributes
		   pw.println("<b>Servlet4:: request attribute value ::  </b> "+req.getAttribute("attr1"));
		   //read and display session attribute values
		   HttpSession ses=req.getSession();
		   pw.println("<br><b> servlet4:: session attribute values::"+ses.getAttribute("attr2")+"</b>");
		   
		 //read and display ServletContext attribute values
		   ServletContext sc=getServletContext();
		   pw.println("<br> servlet4:: ServletContext attribute value::"+sc.getAttribute("attr3"));
		   //close stream
		   pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

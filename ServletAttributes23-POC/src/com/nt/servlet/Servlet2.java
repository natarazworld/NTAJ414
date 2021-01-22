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

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read and display request attributes
		   pw.println("<b>Servlet2:: request attribute value ::  </b> "+req.getAttribute("attr1"));
		   //read and display session attribute values
		   HttpSession ses=req.getSession();
		   pw.println("<br> servlet2:: session attrobute values::"+ses.getAttribute("attr2"));
		 //read and display ServletContext attribute values
		   ServletContext sc=getServletContext();
		   pw.println("<br> servlet2:: ServletContext attribute value::"+sc.getAttribute("attr3"));
		//forward the request to Servlet comp3
		RequestDispatcher  rd=req.getRequestDispatcher("/s3url");
		rd.forward(req, res);
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

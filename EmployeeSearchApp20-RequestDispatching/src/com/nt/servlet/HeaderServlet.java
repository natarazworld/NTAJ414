package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns = "/headerurl" )
public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  //get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//write header content
		pw.println("<h1 style='color:red;text-align:center'><marquee> N A R E S H  Technlologies"+new Date()+" </marquee>  </h1>");
		pw.println("<br><br><br>");
		//do not close stream i.e do not commit response
		 //pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

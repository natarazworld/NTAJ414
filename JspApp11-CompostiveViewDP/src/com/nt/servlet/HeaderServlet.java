package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headerurl")
public class HeaderServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//write  header content
		pw.println("<h1 style='color:red'><marquee> NARESHT-IT.com  </marquee> </h1>");
		// do not  close the  stream
		  //pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         doGet(req,res);
	}//method

}//class

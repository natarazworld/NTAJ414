package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("req obj class name:"+req.getClass());
		System.out.println("res obj class name:"+res.getClass());
	       //get PrinterWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String user=req.getParameter("uname");
		String pass=req.getParameter("pwd");
		System.out.println(user+" ......"+pass);
		if(user.equalsIgnoreCase("raja@gmail.com") && pass.equalsIgnoreCase("rani")) {
			pw.println("<h1 style='color:green;text-align:center'> Valid Credentails </h1>");
		}
		else {
			pw.println("<h1 style='color:green;text-align:center'> InValid Credentails </h1>");
		}
		
		//add home
		pw.println("<br> <a href='login.html'>home </a>");
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}

}

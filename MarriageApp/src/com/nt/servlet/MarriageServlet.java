package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	//@Override
	public void processPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  System.out.println("MarriageServlet.processPost(-,-)");
		// set response content type
		res.setContentType("text/html");
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
		//read form data (req param values)
		String name=req.getParameter("pname");
		int age=Integer.parseInt(req.getParameter("page"));
		String gender=req.getParameter("gender");
		//write b.logic or request processing logic
		pw.println("<h1 style='color:blue;text-align:center'> Shaadi.com </h1>");
		
		if(gender.equalsIgnoreCase("M")) {
			 if(age<21)
				  pw.println("<h1 style='color:red;text-align:center'> Mr."+name +" u r not elgible for marriage enjoy life </h1>");
			 else
				 pw.println("<h1 style='color:green;text-align:center'> Mr."+name +" u r  elgible for marriage , But think once </h1>");
		}
		else {
			 if(age<18)
				  pw.println("<h1 style='color:red;text-align:center'> Miss."+name +" u r not elgible for marriage, be happy </h1>");
			 else
				 pw.println("<h1 style='color:green;text-align:center'> Miss."+name +" u r  elgible for marriage , But think Thrice </h1>");
		}
		
		//add graphical hyperlink for home  navigation
		pw.println("<br> <a href='input.html'><img src='images/home.png' width='50' height='50'> </a>");
		//close stream
		pw.close();
	}//doPost(-,-)
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 System.out.println("MarriageServlet.doGet(-,-)");
		processGet(req,res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doPost(-,-)");
	  processPost(req,res);
	}
	
	
	public void processGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.processGet(-,-)");
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//write the wish message
		pw.println("<h1 style='color:red;text-align:center'> Good Morning  </h1> ");
		//add graphical hyperlink for home  navigation
		pw.println("<br> <a href='input.html'><img src='images/home.png' width='50' height='50'> </a>");
		//close stream
		pw.close();
	}//method
		
}//class

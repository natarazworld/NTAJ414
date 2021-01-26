package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
				PrintWriter pw=res.getWriter();
				//set response content type
				res.setContentType("text/html");
				//create cookies and add them to response  (InMemory)
				Cookie ck1=new Cookie("ap","NoCapital");
				Cookie ck2=new Cookie("TS","hyd");
				res.addCookie(ck1); res.addCookie(ck2);
				//Create Cookies  as persistent Cookies
				Cookie ck3=new Cookie("MH","Mumbai");
				Cookie ck4=new Cookie("MP","Bhopal");
				ck3.setMaxAge(2*60);
				ck4.setMaxAge(3*60);
				res.addCookie(ck3); res.addCookie(ck4);
				
				pw.println("<h1 style='color:red;text-align:center'>Cookies are successfully added </h1>");
				//close stream 
				pw.close();	
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

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

@WebServlet("/eurourl")
public class EurorDollarConvertorServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  //get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		float value=Float.parseFloat(req.getParameter("currency"));
		//get		EURO  Dollar price for  INR  
		 float  eurovalue=value/89.0f;
		 pw.println("<h1 style='color:red;text-align:center'>(EurorDollarConvertorServlet) Euro value ::"+eurovalue+" for rupee value is ::"+value+"</h1>");
		 //perform  CrossContext communication
		   //get Acccess to ServletContext obj of current web application
		 ServletContext sc1=getServletContext();
		 //get foreign context of  USDollarConvertorApp
		 ServletContext sc2=sc1.getContext("/USDollarConvertorApp");
		 //create RequestDispatcher object pointing to Destionation web comp of  Another wegb applicaiton
		 RequestDispatcher rd=sc2.getRequestDispatcher("/dollarurl");
		 //include response
		 rd.include(req,res);
		 //add home hyperlink
		 pw.println("<br><a href='input.html'>home</a>");
		 //close stream
		 pw.close();  // it is source servlet comp
	}//doGet(req,res)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

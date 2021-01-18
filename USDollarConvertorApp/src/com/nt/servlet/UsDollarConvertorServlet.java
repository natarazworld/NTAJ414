package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dollarurl")
public class UsDollarConvertorServlet extends HttpServlet {
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read from data  
		float value=Float.parseFloat(req.getParameter("currency"));
		//get converted   US dollar value
		float dollarValue=value/71.0f;
		//diplay value
		pw.println("<h1 style='color:red;text-align:center'>(USDollarConvertorServlet) Us dollar value ::"+dollarValue+" for rupee value is ::"+value+"</h1>");
		 
		//do not close stream
		//pw.close();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

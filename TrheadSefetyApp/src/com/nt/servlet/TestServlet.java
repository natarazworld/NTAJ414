package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet implements SingleThreadModel{
	
	public TestServlet() {
		System.out.println("TestServlet:: 0-param costructor"+this.hashCode()); 
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("TestServlet.doGet(-,-)");
       PrintWriter pw=res.getWriter();
       res.setContentType("text/html");
       try {
    	   Thread.sleep(40000);
       }
       catch(Exception se) {
    	   se.printStackTrace();
       }
       pw.println("<h1> Date and time is ::"+new java.util.Date()+"</h1>");
		//close stream
       pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestServlet.doPost(-,-)");
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}

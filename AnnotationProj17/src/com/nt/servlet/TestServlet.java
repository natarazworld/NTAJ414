package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(value="/testurl")
//@WebServlet("/testurl")
//@WebServlet({"/testurl1","/testurl2"})
//@WebServlet(urlPatterns={"/testurl1","/testurl2"})
//@WebServlet(urlPatterns={"/testurl1","/testurl2"},name="test",loadOnStartup = 1)
 @WebServlet(name="test1",urlPatterns = "/testurl1",initParams = {@WebInitParam(name="p1",value="val1"),
		                                                                                                                                 @WebInitParam(name="p2",value="val2")
                                                                                                                                        } )
public class TestServlet extends HttpServlet {
	
	public TestServlet() {
		System.out.println("TestServlet:: 0-param constructor");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      //get PrintWriter
		 PrintWriter pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 
		 //writer output message to the browser
		 pw.println("<b> Date and time is ::"+new java.util.Date()+"</b>");
		 ServletConfig cg=getServletConfig();
		 pw.println("<br><b> logical name of servlet comp is ::"+cg.getServletName()+"</b>");
		 pw.println("<br> p1, p2 init param values::"+cg.getInitParameter("p1")+" "+cg.getInitParameter("p2"));
		 //close stream
		 pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
	
}

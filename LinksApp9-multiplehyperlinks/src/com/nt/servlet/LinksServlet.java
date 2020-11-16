package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       //get PrintWriter
       PrintWriter pw=res.getWriter();
       //set response content type
       res.setContentType("text/html");
       //read special request param value
       String pval=req.getParameter("s1");
       //get All available Locales  
       Locale locales[]=Locale.getAvailableLocales();
       
       if(pval.equalsIgnoreCase("link1")) {
    	      pw.println("All langugaes are ::");
    	      for(Locale l: locales) {
    	    	    pw.println("<br><b>"+l.getDisplayLanguage()+"</b>");
    	      }
       }//if
       else if(pval.equalsIgnoreCase("link2")) {
    	   pw.println("All counstries are ::");
 	      for(Locale l: locales) {
 	    	    pw.println("<br><b>"+l.getDisplayCountry()+"</b>");
 	      }
       }//else if
       else {
    	   pw.println("System properties ::"+System.getProperties());
       }
       //add home hyperlink
       pw.println("<br><br><a  href='links.html'>home </a>");
       //close stream
       pw.close();
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
	
}//class

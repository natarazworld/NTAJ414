package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class DoublePostingPreventingFilter  extends  HttpFilter {
	
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// Create/Locate Session object
		 HttpSession ses=req.getSession();  
		 if(req.getMethod().equalsIgnoreCase("GET")) {
			 //create Server Token as   Session attribute having random number
			 int val=new Random().nextInt(100000);
			 ses.setAttribute("sToken",val);
			 System.out.println("Generated sToken value::"+val);
			 chain.doFilter(req,res);
		 }
		 else {
			 //read cToken value from hidden box
			 int clientToken=Integer.parseInt(req.getParameter("cToken"));
			//read sToken value from Session object
			 int serverToken=(int) ses.getAttribute("sToken");
			 System.out.println(clientToken+"       "+serverToken);
			  if(clientToken==serverToken) {
				  //change server Token value
				  int val=new Random().nextInt(100000);
					 ses.setAttribute("sToken",val);
					 System.out.println("Request going  actual servlet comp for processing");
				  chain.doFilter(req, res);
			  }
			  else {
				   //get PrintWrtier 
				  PrintWriter pw=res.getWriter();
				  res.setContentType("text/html");
				  pw.println("<h1 style='color:red;text-align:center'> Double Posting  not allowed  </h1>");
				  pw.println("<br> <a href='input.jsp'>home </a>");
			  }
		 }
	
	}

}

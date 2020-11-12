package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  System.out.println("MarriageServlet.doPost(-,-)");
		// set response content type
		res.setContentType("text/html");
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
		//read form data (req param values)
		String name=req.getParameter("pname");
		String tage=req.getParameter("page");
		String gender=req.getParameter("gender");
		String vstatus=req.getParameter("vflag");  
		//execute server side form validation logic only when client side JS is disabled
		int age=0;
    if(vstatus.equalsIgnoreCase("no")) {
		//form validation logic  (server side)
		List<String> errList=new ArrayList();
		System.out.println("MarriageServlet.doPost():: Server side form validation logic");
		if(name==null || name.equals("") || name.length()==0) {  //required rule
			errList.add("Person name is required");
		}
		else if(name.length()<5) {  //min length rule 
			errList.add("Person name must have minimum  5 characters");
		}
		
		
		if(tage==null || tage.equals("") || tage.length()==0) { //required rule
			errList.add("Person age is required");
		}
		else {
			try {
			 age=Integer.parseInt(tage);  // numeric value rule
			  if(age<1 || age>125) {  //range rule
				  errList.add("Person age must be given 1 through 125");
			  }//if
			}//try
			catch(NumberFormatException nfe) {
				errList.add("Person age must be numeric value");
			}//catch
		}//else
          //Display form validation error messages
		    if(!errList.isEmpty()) {
		    	errList.forEach(msg->{    //java8 foreach() method with Lamda expression
		    		pw.println("<li><span style='color:red'>"+msg+"</span></li>");
		    	});
		    	return;
		    }//if
    }//if		
    else {
    	age=Integer.parseInt(tage);  // To convert String age value to numeric value 
    }//else
		
		//write b.logic or request processing logic
		System.out.println("MarriageServlet.doPost():: Server side b.logic");
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
		doPost(req,res);
	}
}//class

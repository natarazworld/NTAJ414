package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  //get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String name=req.getParameter("pname");
		int age=Integer.parseInt(req.getParameter("page"));
		String gender=req.getParameter("gender");
		String addrs=req.getParameter("paddrs");
		String ms=req.getParameter("ms");
		String qlfy=req.getParameter("qlfy");
		String hobies[]=req.getParameterValues("hb");
		String languages[]=req.getParameterValues("languages");
		long phone=Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		int favNumber=Integer.parseInt(req.getParameter("favNumber"));
		String dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String month=req.getParameter("birthMonth");
		String favColor=req.getParameter("favColor");
		long salary=Long.parseLong(req.getParameter("salary"));
		String fburl=req.getParameter("fbUrl");
		//write b.logic
		if(gender.equalsIgnoreCase("M")) {
			 if(age<5)
				 pw.println("<h1 style='color:green;text-align:center'>Master."+name+" u  r  baby boy </h1>");
			 else if(age<13)
				 pw.println("<h1 style='color:green;text-align:center'>Master."+name+" u  r small boy </h1>");
			 else if(age<20)
				 pw.println("<h1 style='color:green;text-align:center'>Mr."+name+" u  r teenage boy </h1>");
			 else if(age<35)
				 pw.println("<h1 style='color:green;text-align:center'>Mr."+name+" u  r young man </h1>");
			 else if(age<50)
				 pw.println("<h1 style='color:green;text-align:center'>Mr."+name+" u  r  middle-aged man </h1>");
			 else 
				 pw.println("<h1 style='color:green;text-align:center'>Mr."+name+" u  r  old man </h1>");
		}//if
		else {
			 if(age<5)
				 pw.println("<h1 style='color:green;text-align:center'>Master."+name+" u  r  baby girl </h1>");
			 else if(age<13)
				 pw.println("<h1 style='color:green;text-align:center'>Master."+name+" u  r small girl </h1>");
			 else if(age<20) {
				  if(ms.equalsIgnoreCase("married"))
				        pw.println("<h1 style='color:green;text-align:center'>Mrs."+name+" u  r teenage girl </h1>");
				  else
					  pw.println("<h1 style='color:green;text-align:center'>Miss."+name+" u  r teenage girl </h1>");
			     }
			 else if(age<35) {
				  if(ms.equalsIgnoreCase("married"))
				        pw.println("<h1 style='color:green;text-align:center'>Mrs."+name+" u  r young woman </h1>");
				  else
					  pw.println("<h1 style='color:green;text-align:center'>Miss."+name+" u  r young woman </h1>");
			     }
			 else if(age<50) {
				  if(ms.equalsIgnoreCase("married"))
				        pw.println("<h1 style='color:green;text-align:center'>Mrs."+name+" u  r middle-aged woman </h1>");
				  else
					  pw.println("<h1 style='color:green;text-align:center'>Miss."+name+" u  r middle-aged woman </h1>");
			     }
			 else {
					  if(ms.equalsIgnoreCase("married"))
					        pw.println("<h1 style='color:green;text-align:center'>Mrs."+name+" u  r old woman </h1>");
					  else
						  pw.println("<h1 style='color:green;text-align:center'>Miss."+name+" u  r old woman </h1>");
				     }
			 
			 }//else
		
		  pw.println("<h2 style='color:blue'>The submitted Details are  </h2>");
		  pw.println("<br><b> name::"+name+"</b>");
		  pw.println("<br><b> age::"+age+"</b>");
		  pw.println("<br><b> adrrs::"+addrs+"</b>");
		  pw.println("<br><b> gender::"+gender+"</b>");
		  pw.println("<br><b> Marital status::"+ms+"</b>");
		  pw.println("<br><b> Qualification::"+qlfy+"</b>");
		  pw.println("<br><b>hobies::"+Arrays.toString(hobies)+"</b>");
		  pw.println("<br><b> languages::"+Arrays.toString(languages)+"</b>");
		  pw.println("<br><b> faviourite number::"+favNumber+"</b>");
		  pw.println("<br><b> faviourite color::"+favColor+"</b>");
		  pw.println("<br><b> Mobile number::"+phone+"</b>");
		  pw.println("<br><b> DOB::"+dob+"</b>");
		  pw.println("<br><b> TOB::"+tob+"</b>");
		  pw.println("<br><b> Birth Month::"+month+"</b>");
		  pw.println("<br><b> FB url::"+fburl+"</b>");
		  pw.println("<br><b> slaary::"+salary+"</b>");
		  pw.println("<br><b> email::"+email+"</b>");
		  
		  //home hyperlink
		  pw.println("<br><br><a href='input.html'>home </a>");
		
		//close stream
		  pw.close();
		
		}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}

package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		//read form1/req1 data
		String  name=req.getParameter("name");
		String father=req.getParameter("father");
		String ms=req.getParameter("ms");
		//Generate form2 dyanmically based on marital status value
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<h1 style='color:red;text-align:center'> provide married life Details(form2)  </h1>");
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table bgcolor='cyan' align='center'>");
			pw.println("<tr><td>Spouse name ::</td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>No.of kids :: </td><td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'> </td></tr>");
			pw.println("<tr><td> <input type='hidden' name='hname' value='"+name+"'></td>"
					+ "<td> <input type='hidden' name='hfname' value='"+father+"'></td></tr>");
			pw.println("<tr><td> <input type='hidden' name='hms' value='"+ms+"'></td> </tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'> Provide Single life Details(form2)  </h1>");
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table bgcolor='cyan' align='center'>");
			pw.println("<tr><td>when do u want to marry?</td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>Why do u want to marry? </td><td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'> </td></tr>");
			pw.println("<tr><td> <input type='hidden' name='hname' value='"+name+"'></td>"
					+ "<td> <input type='hidden' name='hfname' value='"+father+"'></td></tr>");
			pw.println("<tr><td> <input type='hidden' name='hms' value='"+ms+"'></td> </tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		
		//close stream
		pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class

package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/testurl")
public class TestServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      //create different scope of attributes
		req.setAttribute("attr1", "val1");
		HttpSession ses=req.getSession();
		ses.setAttribute("attr2","val2");
		ServletContext sc=req.getServletContext();
		sc.setAttribute("attr3","val3");
		
		//forward the request to test3.jsp
		RequestDispatcher rd=req.getRequestDispatcher("/test3.jsp");
		rd.forward(req,res);
		
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}//class

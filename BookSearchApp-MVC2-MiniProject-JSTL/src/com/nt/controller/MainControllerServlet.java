package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookDetailsDTO;
import com.nt.service.BookMgmtService;
import com.nt.service.BookMgmtServiceImpl;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
   private BookMgmtService service;
	public void init(ServletConfig config) throws ServletException {
	    service=new BookMgmtServiceImpl();	 
	}

	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //read form data
		String category=req.getParameter("category");
		String outputType=req.getParameter("source");
		try {
		//use service
		List<BookDetailsDTO> listDTO=service.searchBooksByCategory(category);
		//keep result in request scope
		req.setAttribute("booksList",listDTO);
		//forwrd to result jsp page based on the button that is clicked
		if(outputType.equalsIgnoreCase("HTML")) {
			RequestDispatcher rd=req.getRequestDispatcher("/html_print.jsp");
			rd.forward(req, res);
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("/excel_screen.jsp");
			rd.forward(req, res);
		}
		}//try
		catch(Exception e) {
			RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
	
	public void destroy() {
	  service=null;	
	}//destroy()

}//class

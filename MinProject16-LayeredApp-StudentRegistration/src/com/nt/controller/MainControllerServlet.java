package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.IStudentMgmtService;
import com.nt.service.StudentMgmtServiceImpl;

public class MainControllerServlet extends HttpServlet {
	private  IStudentMgmtService service;
	public void init() {
		System.out.println("MainControllerServlet.init()");
		try {
		service=new StudentMgmtServiceImpl();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//init()
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// read form data
		String sname=req.getParameter("sname");
		String addrs=req.getParameter("sadd");
		int marks1=Integer.parseInt(req.getParameter("marks1"));
		int marks2=Integer.parseInt(req.getParameter("marks2"));
		int marks3=Integer.parseInt(req.getParameter("marks3"));
		//create  StudentDTO class obj having  form data
		StudentDTO dto=new StudentDTO();
		dto.setSname(sname); dto.setSadd(addrs);
		dto.setMarks1(marks1); dto.setMarks2(marks2); dto.setMarks3(marks3);
		//use service class
		try {
			//invoke service method
			String result=service.generateResult(dto);
		    pw.println("<h1 style='color:red;text-align:center'>Result is ::"+result+"</h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Problem in Student Registration</h1>");
		}
		//add home hyperlink 
		pw.println("<br> <br> <a href='student_register.html'>home</a>");
		//close stream
		pw.close();
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}//class

package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/balanceurl") 
public class ShowBlanceServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		pw.println("<h1 style='color:red'>Authentication Mode ::"+req.getAuthType()+" </h1>");
		pw.println("<h1 style='color:red'>Logged in username ::"+req.getUserPrincipal()+" </h1>");
		//write b.logic
		pw.println("<h3 style='color:red;text-align:center'> Account Balance :"+new Random().nextInt(200000)+"</h1>");
		//close the stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

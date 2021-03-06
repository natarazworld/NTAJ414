package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimingsCheckingFilter extends HttpFilter {
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// System Date and time
		LocalDateTime sysDate=LocalDateTime.now(); //from java8
		//get current of the day
		int hour=sysDate.getHour();
		if(hour<8 || hour>17) {
			//get PrintWriter
			PrintWriter pw=res.getWriter();
			//set response content type
			res.setContentType("text/html");
			pw.println("<h1 style='color:red;text-align:center'>Request must be given between 9am to 5pm </h1>");
			return;
		}
		else {
			System.out.println("TiminigsCheckingFilter.before doFilter(-,-)");
			chain.doFilter(req, res);
			System.out.println("TiminigsCheckingFilter.after doFilter(-,-)");
		}//else
	}//doFilter(-,-,-)
}//class

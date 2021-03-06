package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BrowserCheckingFilter extends HttpFilter {
	
	static {
		System.out.println("BrowserCheckingFilter.static block");
	}
	
	public BrowserCheckingFilter() {
		System.out.println("BrowserCheckingFilter:0-param constructor");
	}
	
	@Override
	public void init() throws ServletException {
	   System.out.println("BrowserCheckingFilter.init()");
	}
	
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("BrowserCheckingFilter.doFilter()");
		String browser=req.getHeader("user-agent");
		if(!browser.contains("Chrome")) {
			//get PrintWriter 
			PrintWriter pw=res.getWriter();
			pw.println("<h1 style='color:red;text-align:center'>Request must be given from Chrome browser </h1>");
			 return;
		}
		else {
			System.out.println("BrowserCheckingFilter.before chain.doFilter()");
			chain.doFilter(req, res);
			System.out.println("BrowserCheckingFilter.after chain.doFilter()");
		}
	}//doFilter(-,-)
	
	
	
	@Override
	public void destroy() {
     System.out.println("BrowserCheckingFilter.destroy()");
	}

}//class

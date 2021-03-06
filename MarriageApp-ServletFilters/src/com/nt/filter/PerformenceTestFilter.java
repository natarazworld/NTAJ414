package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PerformenceTestFilter extends HttpFilter {
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		long start=0,end=0;
		// get request trapping time
		start=System.currentTimeMillis();  //request processing logic
		 chain.doFilter(req, res);
		// get response trapping time
		 end=System.currentTimeMillis();  //response processisng logic
		 System.out.println(req.getRequestURI()+"has taken "+(end-start)+"ms to process the reuqest");
	}

}

package com.nt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrapper.MyRequest;

@WebFilter("/loginurl")
public class LoginFilter extends HttpFilter {

	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		 //create Custom Request obj
		MyRequest mreq=new MyRequest(req);
		chain.doFilter(mreq, res);
		
	}


}

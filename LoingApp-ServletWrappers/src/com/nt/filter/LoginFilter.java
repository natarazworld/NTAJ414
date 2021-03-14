package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrapper.MyRequest;
import com.nt.wrapper.MyResponse;

@WebFilter("/loginurl")
public class LoginFilter extends HttpFilter {

	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		 //create Custom Request obj
		MyRequest mreq=new MyRequest(req);
		 //create Custom Response obj
		MyResponse mres=new MyResponse(res);
		chain.doFilter(mreq, mres);
		System.out.println(mres.toString());
		String output=mres.toString();  //recieving the output from InMemory buffer/String
		//modify the output
		output=output+"<br> <b>From Naresh IT </b>";
		//get PrintWriter object pointing to  original response objs
		PrintWriter pw=res.getWriter();
		pw.println(output);
		//close stream
		pw.close();
		
	}


}

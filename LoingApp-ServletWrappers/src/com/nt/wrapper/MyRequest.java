package com.nt.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest req;
    
	public MyRequest(HttpServletRequest req) {
		super(req);
		this.req=req;
   }
	
	@Override
	public String getParameter(String name) {
	   String  value=req.getParameter(name);
	      if(name.equals("uname")) {
	    	  if(!value.endsWith("@gmail.com"))
	    	  value=value+"@gmail.com";
	      }
	      return value;
	}

}

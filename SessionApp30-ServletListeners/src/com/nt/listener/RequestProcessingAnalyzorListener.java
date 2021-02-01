package com.nt.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestProcessingAnalyzorListener implements ServletRequestListener {
	private long start,end;
	
	public RequestProcessingAnalyzorListener() {
		System.out.println("RequestProcessingAnalyzorListener:: 0-param constructor");
	}
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestProcessingAnalyzorListener.requestInitialized(-)");
	  start=System.currentTimeMillis();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestProcessingAnalyzorListener.requestDestroyed(-)");
       end=System.currentTimeMillis();
       //get HttpServletRequest obj
       HttpServletRequest req=(HttpServletRequest) sre.getServletRequest();
       System.out.println(req.getRequestURL()+" has taken "+(end-start)+"  ms time process the request");
       //write to Server's log file
        ServletContext sc=req.getServletContext();
        sc.log(req.getRequestURL()+" has taken "+(end-start)+"  ms time process the request");
	}
	
	

}

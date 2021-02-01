package com.nt.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionAnalyzarListener implements HttpSessionListener {
	private long start,end;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
	   start=System.currentTimeMillis();
	   System.out.println("Session started at::"+new Date());
	   //write to log file
	   ServletContext sc=se.getSession().getServletContext();
	   sc.log("Session started at::"+new Date());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		end=System.currentTimeMillis();
		System.out.println("Session end at::"+new Date());
		   //write to log file
		   ServletContext sc=se.getSession().getServletContext();
		   sc.log("Session Ended at::"+new Date()+" Session duration is:: "+ (end-start) +" ms");
		   
	}

}

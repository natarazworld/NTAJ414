package com.nt.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class WebApplicationMonitorListener implements ServletContextListener {
    private long start,end;
    
    public WebApplicationMonitorListener() {
    	System.out.println("WebApplicationMonitorListener:: 0-param constructor");
    }

	public void contextDestroyed(ServletContextEvent sce)  {
		System.out.println("WebApplicationMonitorListener.contextDestroyed()");
		end=System.currentTimeMillis();
		System.out.println("web application is stopped/undeployed at::"+new Date()+"  web applicaition running duration is ::"+(end-start)+" ms");
		//write to log file
		ServletContext sc=sce.getServletContext();
		sc.log(sc.getContextPath()+" is stopped/undeployed  at::"+new Date()+"  web applicaition running duration is ::"+(end-start)+" ms");
    }
		
	
	public void contextInitialized(ServletContextEvent sce)  {
		System.out.println("WebApplicationMonitorListener.contextInitialized()");
		start=System.currentTimeMillis();
		System.out.println("web application is deployed/restarted/reloaded  at::"+new Date());
		//write to log file
		ServletContext sc=sce.getServletContext();
		sc.log(sc.getContextPath()+" is deployed /restarted/reloaded at::"+new Date());
	}
		
	
}

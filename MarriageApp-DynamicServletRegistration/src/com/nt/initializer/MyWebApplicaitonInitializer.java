package com.nt.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.MarriageServlet;

public class MyWebApplicaitonInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
		System.out.println("MyWebApplicaitonInitializer.onStartup(-.-)");
		//create object Servlet comp class
		MarriageServlet  servlet=new MarriageServlet();
		//register with ServletContaienr using sc.addServlet(-,-)
		//sc.addServlet(-,-) method returns  ServletRegistration.Dynamic (I) impl class obj and that obj can be used
		//to provide further configurations to servlet comp like url pattern , enabling <l-o-s> and etc..
		ServletRegistration.Dynamic dyna=sc.addServlet("ms", servlet);
		//map with url pattern
		dyna.addMapping("/marriageurl");
		//enable load-on-startup
		dyna.setLoadOnStartup(1);

	}

}

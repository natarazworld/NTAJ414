package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MessageTag extends TagSupport {
	
	@Override
	public int doStartTag() throws JspException {
		System.out.println("MessageTag.doStartTag()");
		//get out object from pageContext obj
		JspWriter out=pageContext.getOut();
		try {
			//write message to response object to browser
			out.println("The Prime Numbers are ");
		}//try
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	    return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("MessageTag.doEndTag()");
	   return EVAL_PAGE;
	}
	

}

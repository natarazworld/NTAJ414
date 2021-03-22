package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DisplayTag extends TagSupport {
	private int size=20;
	private String font;
	
	public void setSize(int size) {
		System.out.println("DispalyTag.setSize()");
		this.size = size;
	}//setSize(-)
	
	public void setFont(String font) {
		System.out.println("DispalyTag.setFont()");
		this.font = font;
	}//setFont(-)
	
	@Override
	public int doStartTag() throws JspException {
		System.out.println("DispalyTag.doStartTag()");
		//get out object
		JspWriter out=pageContext.getOut();
		try {
		out.println("<span style='font-size:"+size+"px;font-family:"+font+"'>");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}//doStartTag
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("DispalyTag.doEndTag()");
		//get out object
		JspWriter out=pageContext.getOut();
		try {
			out.println("</span>");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return EVAL_PAGE;
	}//doEndTag
	
	
}//class

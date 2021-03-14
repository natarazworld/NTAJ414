package com.nt.wrapper;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {
     CharArrayWriter writer=new CharArrayWriter();  // create Writer Stream which takes InMemory String obj/buffer as the 
                                                                                          // the destination to store the written data.
	public MyResponse(HttpServletResponse response) {
		super(response);
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		PrintWriter pw=new PrintWriter(writer);    // pw.println(-) -->CharArrayWriter ---> InMemoryString/buffer
		return pw;
	}
	
	@Override
	public String toString() {
	   return writer.toString();
	}

}

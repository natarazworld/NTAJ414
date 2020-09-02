package com.nt.basics;

import java.text.SimpleDateFormat;

public class DateConversions {

	public static void main(String[] args) throws Exception{
	    //converting String date value to java.util.Date class obj
		 String d1="45-20-1990";  //dd-MM-yyyy
		 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");  //holding pattern of date
		 java.util.Date ud1=sdf.parse(d1);  
		 System.out.println("util date::"+ud1);
		 
		 //converting  java.util.DAte class obj to java.sql.Date class obj
		   long ms=ud1.getTime();  //gives no.of milliseconds that are elasped  b/w
		                                                   // jan 1st 1970 midnight 00:00 hours(epoch standard)  and  ud1 obj's date,time
		   System.out.println(ms);
		   java.sql.Date sd1=new java.sql.Date(ms);
		   System.out.println("sql date1::"+sd1);
		   
		   //if String date value pattern is yyyy-MM-dd then it can be converted directly to
		   // java.sql.Date class obj with out converting to java.util.Date class object.
		   String d2="1995-10-30";  //yyyy-MM-dd
		   java.sql.Date sd2=java.sql.Date.valueOf(d2);  //static method
		   System.out.println("sql date2::"+sd2);
		   
		   SimpleDateFormat sdf2=new SimpleDateFormat("MMM-yyyy-dd");
		   String d3=sdf2.format(sd2);
		   System.out.println("String date value ::"+d3);
		   
		   
		System.out.println( " \\ ");

	}

}

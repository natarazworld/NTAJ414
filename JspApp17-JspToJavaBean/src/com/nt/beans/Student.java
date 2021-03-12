package com.nt.beans;

import java.io.Serializable;

public class Student  implements Serializable {
	private  int sno;
	private String sname;
	private float  avg;
	
	public Student() {
		System.out.println("Student:: 0-param constructor");
	}
	
	 // alt+shit+s,r  -->select all  to get all setters and getters
	public int getSno() {
		System.out.println("Student.getSno()");
		return sno;
	}
	public void setSno(int sno) {
		System.out.println("Student.setSno()");
		this.sno = sno;
	}
	public String getSname() {
		System.out.println("Student.getSname()");
		return sname;
	}
	public void setSname(String sname) {
		System.out.println("Student.setSname()");
		this.sname = sname;
	}
	public float getAvg() {
		System.out.println("Student.getAvg()");
		return avg;
	}
	public void setAvg(float avg) {
		System.out.println("Student.setAvg()");
		this.avg = avg;
	}
	
	
	

}

package com.nt.dto;

import java.io.Serializable;

public class EmployeeDetailsDTO implements Serializable {
    private  String ename;
    private  String desg;
    private  float  bsalary;
    private  float grossSalary;
    private float netSalary;
    
    public EmployeeDetailsDTO() {
		System.out.println("EmployeeDetailsDTO:: 0-param constructor");
	}
    
    //gettes & setters
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public float getBsalary() {
		return bsalary;
	}
	public void setBsalary(float bsalary) {
		this.bsalary = bsalary;
	}
	public float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}
}

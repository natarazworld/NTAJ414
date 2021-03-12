package com.nt.service;

import com.nt.dto.EmployeeDetailsDTO;

public class SalaryDetailsGeneratorImpl implements SalaryDetailsGenerator {
	

	@Override
	public void generateSalaryDetails(EmployeeDetailsDTO dto) {
		//generate gross Salary and netSalary 
		float grossSalary=dto.getBsalary()+ (dto.getBsalary()*0.3f);
		float netSalary=grossSalary-(dto.getBsalary()*0.2f);
		//set  gross salary , netSalary to DTO class object
		dto.setGrossSalary(grossSalary);
		dto.setNetSalary(netSalary);
	}

}

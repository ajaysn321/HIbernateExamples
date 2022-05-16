package com.service;

import com.model.Employee;

public interface ServiceI {
	
	void addEmployee();
	void addMutipleEmployee();
	void showAllEmployee();
	void showSingleEmployeeUsingId();
	Employee showSingleEmployeeUsingId(int id);
	void updateEmployee();
	void deleteEMployee();

}

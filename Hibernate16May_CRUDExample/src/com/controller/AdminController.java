package com.controller;

import java.util.Scanner;

import com.service.ServiceI;
import com.serviceImpl.ServiceImpl;

public class AdminController {

	
	public static void main(String[] args) {
		
		
		System.out.println("=================== Weolcome In Application ================");
		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		ServiceI serviceI=new ServiceImpl();
		while(flag) {
			System.out.println("1. Add Employee Data");
			System.out.println("2. Add Multiple Employee Data");
			System.out.println("3. Show All Employee Data");
			System.out.println("4. Show Single Employee Data");
			System.out.println("5. Update Employee Data");
			System.out.println("6. Delete Employee Data");
			System.out.println("7. Terminate Application");
			
			int ch=sc.nextInt();
			
			switch (ch) {
			case 1:serviceI.addEmployee();
				
				break;
			case 2:serviceI.addMutipleEmployee();

				break;
			case 3:serviceI.showAllEmployee();

				break;
			case 4:serviceI.showSingleEmployeeUsingId();

				break;
			case 5:serviceI.updateEmployee();

				break;
			case 6:serviceI.deleteEMployee();

				break;
			case 7:flag= false;
				break;
			default :
				break;
			}
			
		}
	}
}

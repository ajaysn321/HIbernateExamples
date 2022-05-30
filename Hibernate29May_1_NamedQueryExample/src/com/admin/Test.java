package com.admin;

import java.util.Scanner;

import com.service.ServiceI;
import com.service.ServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		
		ServiceI s =new ServiceImpl();
		Scanner sc  =new Scanner(System.in);
		
		System.out.println("====================== Welcome Appication ==========================");
		while (true) {
			System.out.println("1. Add Student Data");
			System.out.println("2. Show All Student Data");
			System.out.println("3. Get Single Student Data");
			System.out.println("4. Update Single Student Data");
			System.out.println("5. Delete Single Student Data");
			
			int ch = sc.nextInt();
			
			switch (ch) {
			case 1:s.addData();
				
				break;
			case 2:s.showAllData();

				break;
			case 3:s.getSingleStudent();

				break;
			case 4:s.updateSingleStudent();

				break;
			case 5:s.deleteSingleStudent();

				break;
			default:
				break;
			}
		}
		
		
	}

}

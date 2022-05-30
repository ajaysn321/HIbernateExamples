package com.admin;

import java.util.Scanner;

import com.service.OperationImpl;
import com.service.Operations;

public class Controller {
	
	public static void main(String[] args) {
		Operations op= new OperationImpl();
		Scanner sc =new Scanner(System.in);
		
		System.out.println("==================== Welcome in App ======================");
		while (true) {
			System.out.println("1. Add College Data With Multiple Student ");
			
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				     op.addCollegeWithStudent();
				break;

			default:
				break;
			}
		}
	}

}

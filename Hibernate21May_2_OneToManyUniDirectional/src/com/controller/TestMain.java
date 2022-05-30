package com.controller;

import java.util.Scanner;

import com.service.ServiceI;
import com.serviceImpl.ServiceImpl;

public class TestMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ServiceI service = new ServiceImpl();

		boolean flag = true;
		
		while (flag) {
			System.out.println("*************MENU*****************");
			System.out.println("1. Insert User & address details");
			System.out.println("2. Display User & address details");
			System.out.println("3. Display Single User & address details");
			System.out.println("4. Update single record details");
			System.out.println("5. Exit");
			System.out.println("Select your choice..");
			int ch = sc.nextInt();
			switch (ch) {

			case 1:
				service.insertUserAddressDetails();
				break;
			case 2:
				service.displayAllUserAddressDetails();
				break;
			case 3:
				service.displaySingleUserAddressDetails();
				break;
			case 4:
				service.updateSingleUserDetails();
				break;
			case 5:
				flag = false;
				break;
			}

		}
		sc.close();

	}
}

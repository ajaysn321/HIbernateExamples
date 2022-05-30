package com.controller;

import java.util.Scanner;

import com.service.ServiceI;
import com.service.ServiceImpl;

public class Admin {

	public static void main(String[] args) {
       
		ServiceI s = new ServiceImpl();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
			System.out.println("1. Insert Data");
			System.out.println("2. Show All Data");
			System.out.println("3. Get Single Data");
			System.out.println("4. Get Single Column Data");
			System.out.println("5. Get Multiple Column Data");
			
			int ch =sc.nextInt();
			
			switch (ch) {
			case 1:s.insertData();
				
				break;
			case 2:s.showAllData();

				break;
			case 3:s.getSingleUser();

				break;
			case 4:s.getSingleColumnData();

			break;
			case 5:s.getMultipleColumnData();

			break;
			default:
				break;
			}
		}
        
	}
}

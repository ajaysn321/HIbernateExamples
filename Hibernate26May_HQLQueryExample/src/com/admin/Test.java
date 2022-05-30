package com.admin;

import java.util.Scanner;

import com.service.ServiceI;
import com.service.ServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		
		ServiceI s = new ServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("===========================@#@ Application Start @#@==============================");
		while (true) {
			System.out.println("1. Add Employee InFo.");
			System.out.println("2. Show All Employee Info.");
			System.out.println("3. Update Single Employee Info using Hql.");
			System.out.println("4. Delete Single Employee Info Using Hql.");
			System.out.println("5. Get All Data Using As Clause.");
			System.out.println("6. OrderedBy Employee Info.");
			System.out.println("7. Get Single Column Info.");
			System.out.println("8. Find Count.");
			System.out.println("9. Max Paid Salary.");
			System.out.println("10. Calculate All Paidd Amount.");
			System.out.println("11. Get Single Employee Info Uing Hql.");
			
			int ch =sc.nextInt();
			
			switch (ch) {
			case 1:s.addUser();
				
				break;
			case 2:s.showAllUserDataUsingHql();

				break;

			case 3:s.updateSingleDataUsingHql();

				break;

			case 4:s.deleteSingleDataUsingHql();

				break;

			case 5:s.getAllDataUsingHqlAsClause();

				break;

			case 6:s.getDataUsingOrderBy();

				break;

			case 7:s.selectPericularColumn();

				break;

			case 8:s.findCount();
				
				break;

			case 9:s.maXPaidAmountFind();

				break;
			case 10:s.calculateAllPaindAmount();

				break;
			case 11:s.getSingleDataUsingHql();

			break;
			default:
				break;
			}
		}
		
	}

}

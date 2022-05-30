package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.College;
import com.model.Student;
import com.util.HIbernateUtil;

public class OperationImpl implements Operations{

	SessionFactory sf =HIbernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);
	@Override
	public void addCollegeWithStudent() {
		
		Session session = sf.openSession();
		College college = new College();
		System.out.println("Enter College Id : " );
		college.setCid(sc.nextInt());
		System.out.println("Enter College Name :  ");
		college.setCname(sc.next());
		
		System.out.println("Enter How many Student you want to add ?");
		int n =sc.nextInt();
		
		for(int i=0;i<n;i++) {
			Student student = new Student();
			System.out.println("Enter Student Id :" );
			student.setSid(sc.nextInt());
			System.out.println("Enter Student Name : " );
			student.setSname(sc.next());
			
			student.setCollege(college);
			college.getSlist().add(student);
			session.save(college);
			session.save(student);
		}
		session.beginTransaction().commit();
		System.out.println("Data Inserted...!");
	}

}

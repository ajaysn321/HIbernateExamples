package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Student;
import com.util.HibenateUtil;

public class ServiceImpl  implements ServiceI{

	SessionFactory sf =HibenateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void addData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Student student = new Student();
		System.out.println("Enter Student id : ");
		student.setSid(sc.nextInt());
		System.out.println("Enter Student Name : ");
		student.setSname(sc.next());
		System.out.println("Enter Student Address : ");
		student.setSaddress(sc.next());
		
		session.save(student);
		session.beginTransaction().commit();
		System.out.println("Done");
	}

	@Override
	public void showAllData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<Student> query = session.createNamedQuery("findall");
		List<Student> list = query.getResultList();
		System.out.println(list);
	}

	@Override
	public void getSingleStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Student Id : ");
		int i = sc.nextInt();
		Query<Student> query = session.createNamedQuery("fetchSingle");
		query.setParameter("id", i);
		Student student = query.getSingleResult();
		System.out.println(student);
	}

	@Override
	public void updateSingleStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		session.beginTransaction();
		System.out.println("Enter Student Id : ");
		int i = sc.nextInt();
		System.out.println("Enter Student Name : ");
		String name = sc.next();
		System.out.println("Enter Student Address : ");
		String address = sc.next();
		Query<Student> query = session.createNamedQuery("updateStudent");
		query.setParameter("n", name);
		query.setParameter("a", address);
		query.setParameter("id", i);
		query.executeUpdate();
		session.getTransaction().commit();
		System.out.println("Data Updated");
	}

	@Override
	public void deleteSingleStudent() {
		// TODO Auto-generated method stub
		
	}

}

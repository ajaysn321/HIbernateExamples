package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestMain {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Student stu = new Student();
		stu.setId(1);
		stu.setName("ABC1");
		stu.setAddress("Pune1");
		
		session.save(stu);
		session.beginTransaction().commit();
		
		
		session.close();
		sf.close();
		System.out.println("record Inserted ....");

	}
}

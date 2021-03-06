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
		stu.setId(3);
		stu.setName("ABC123");
		stu.setAddress("Pune123");
		
		session.save(stu);
		session.beginTransaction().commit();
		
		
		session.close();
		sf.close();
		System.out.println("record Inserted ....");

	}
}

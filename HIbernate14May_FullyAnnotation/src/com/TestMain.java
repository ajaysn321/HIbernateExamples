package com;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class TestMain {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		/*
		 * Employee stu = new Employee(); stu.setId(3); stu.setName("ABC3");
		 * stu.setAddress("Pune3");
		 * 
		 * 
		 * Employee emp2 = new Employee(); emp2.setId(2); emp2.setName("ABC2");
		 * emp2.setAddress("Pune2");
		 * 
		 * 
		 * session.save(stu); session.beginTransaction().commit();
		 * 
		 */

		Employee emp = session.get(Employee.class, 1);
		System.out.println("EMP ID :" + emp.getId());
		System.out.println("Retrieved Employee from Get: ," + emp);

		System.out.println("------------------------***----------------------");

		Employee emp1 = session.load(Employee.class, 3);
		System.out.println("EMP ID :" + emp1.getId());
		System.out.println("Retrieved Employee through Load: ," + emp1);

		System.out.println("------------------------***----------------------");

		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> list = query.getResultList();
		for (Employee employee : list) {
			System.out.println(employee);
		}

		session.close();
		sessionFactory.close();
		System.out.println("record Inserted/Fetched ....");

	}
}
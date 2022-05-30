package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestMain {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		
		  Employee stu = new Employee(); 
		  stu.setId(3); 
		  stu.setName("ABC3");
		  stu.setAddress("Pune3");
		  
		  Employee emp2 = new Employee(); 
		  emp2.setId(2); 
		  emp2.setName("ABC2");
		  emp2.setAddress("Pune2");
		  
		 
		  session.save(stu); 
		  session.save(emp2);
		  session.beginTransaction().commit();
		 
		  session.close();
		  
		  session = sessionFactory.openSession();
		Employee emp = session.get(Employee.class, 3);//select --DB hit  null
		System.out.println("EMP ID :" + emp.getId());//null pointer exception
		System.out.println("Retrieved Employee from Get: ," + emp);

		System.out.println("------------------------***----------------------");

		Employee emp1 = session.load(Employee.class, 2);//proxy 
		System.out.println("EMP ID :" + emp1.getId());
		//System.out.println(emp1.getName());
		System.out.println("Retrieved Employee through Load: ," + emp1);

		System.out.println("------------------------***----------------------");

		
		session.close();
		sessionFactory.close();
		System.out.println("record Inserted/Fetched ....");

	}
}

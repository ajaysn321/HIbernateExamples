package com.admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.util.HibernateUtil;

public class Controller {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		/*
		 * Student student = new Student();
		 * 
		 * student.setSid(124); student.setSname("Pqrs"); student.setAddress("Akurdi");
		 * 
		 * session.save(student); session.beginTransaction().commit();
		 */
		
		 Student student = session.get(Student.class, 123);
		 System.out.println(session.hashCode());
		 System.out.println(student);
		 //session.evict(student);
		 // session.clear();
         System.out.println("--------------------------------------------");
         Session session2 = sf.openSession();
         System.out.println(session2.hashCode());
		 Student student1 = session2.get(Student.class, 123);
		 System.out.println(student1);
		
	}

}

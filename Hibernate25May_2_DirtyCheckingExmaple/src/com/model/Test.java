package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		/*
		 * Client client = new Client(); client.setCid(12); client.setName("Xyz");
		 * client.setAddress("Pune");
		 * 
		 * session.save(client); session.beginTransaction().commit();
		 */
		
		Client client = session.get(Client.class, 11);
		System.out.println("Client  : " + client);
		System.out.println("After Modification");
		client.setName("Anonymous");
		session.update(client);
		session.beginTransaction().commit();
		System.out.println("Data updated");
		
		
	}
	
}

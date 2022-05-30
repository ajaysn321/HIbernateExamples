package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Test {

	
	public static void main(String[] args) {
		
		SessionFactory sf =HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//Query<Product> query = session.createNamedQuery("insertData");
		Query<Product> query = session.createNativeQuery("insert into product(pid,pname,price) values(?,?,?)");
		//Query<Product> query = session.getNamedNativeQuery("insertData");
		query.setParameter(1, 3);
		query.setParameter(2, "T-Shirt");
		query.setParameter(3, 1500);
		query.executeUpdate();
		System.out.println("Data Inserted...!");
		//Update,Delete,ShowAll,getSingleProduct.
		}
}

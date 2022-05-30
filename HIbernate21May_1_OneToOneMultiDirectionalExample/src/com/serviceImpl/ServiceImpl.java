package com.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Address;
import com.model.UserOneToOne;
import com.service.ServiceI;
import com.util.HibernateUtil;

public class ServiceImpl implements ServiceI {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	Scanner sc = new Scanner(System.in);

	@Override
	public void insertUserAddressDetails() {

		Session session = sessionFactory.openSession();

		UserOneToOne user = new UserOneToOne();
		System.out.println("Enter Your Name:");
		user.setName(sc.next());

		Address add = new Address();
		System.out.println("Enter First Line Of address: ");
		add.setFirstLine(sc.next());
		System.out.println("Enter Second line of address: ");
		add.setSecondLine(sc.next());
		System.out.println("Enter Pincode: ");
		add.setPinCode(sc.nextInt());

		user.setAddress(add);

		session.save(add);
		session.save(user);

		session.close();
		System.out.println("record Inserted/Fetched ....");

	}

	@Override
	public void displayAllUserAddressDetails() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Query<UserOneToOne> query = session.createQuery("from UserOneToOne");
		List<UserOneToOne> list = query.getResultList();
		for (UserOneToOne userOneToOne : list) {
			System.out.println(userOneToOne);
		}
		session.close();
	}

	@Override
	public void displaySingleUserAddressDetails() {
		Session session = sessionFactory.openSession();
		System.out.println("Enter User Id to get the details: ");
		UserOneToOne user = session.get(UserOneToOne.class, sc.nextInt());
		System.out.println(user);

	}

	@Override
	public void updateSingleUserDetails() {

		Session session = sessionFactory.openSession();
		System.out.println("Enter User Id to get the details: ");
		UserOneToOne user = session.get(UserOneToOne.class, sc.nextInt());
		System.out.println(user);
		System.out.println("Enter your Name to update: ");
		user.setName(sc.next());
		System.out.println("Enter Pincode to update: ");
		user.getAddress().setPinCode(sc.nextInt());
		session.save(user);
		//session.update(user);
		System.out.println(user);
		
	}

}

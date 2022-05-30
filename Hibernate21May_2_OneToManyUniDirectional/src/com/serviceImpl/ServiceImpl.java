package com.serviceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Address;
import com.model.UserOneToMany;
import com.service.ServiceI;
import com.util.HibernateUtil;

public class ServiceImpl implements ServiceI {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	Scanner sc = new Scanner(System.in);

	@Override
	public void insertUserAddressDetails() {

		Session session = sessionFactory.openSession();

		UserOneToMany user = new UserOneToMany();
		System.out.println("Enter Your Name:");
		user.setName(sc.next());

		Address localAdd = new Address();
		System.out.println("Enter First Line Of Local address: ");
		localAdd.setFirstLine(sc.next());
		System.out.println("Enter Second line of Local address: ");
		localAdd.setSecondLine(sc.next());
		System.out.println("Enter Pincode of Local Address: ");
		localAdd.setPinCode(sc.nextInt());

		Address permAdd = new Address();
		System.out.println("Enter First Line Of Perm address: ");
		permAdd.setFirstLine(sc.next());
		System.out.println("Enter Second line of address: ");
		permAdd.setSecondLine(sc.next());
		System.out.println("Enter Pincode: ");
		permAdd.setPinCode(sc.nextInt());

		session.save(localAdd);
		session.save(permAdd);

		user.getAddress().add(localAdd);
		user.getAddress().add(permAdd);

		session.save(user);
		session.beginTransaction().commit();
		session.close();
		System.out.println("record Inserted/Fetched ....");

	}

	@Override
	public void displayAllUserAddressDetails() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Query<UserOneToMany> query = session.createQuery("from UserOneToMany");
		List<UserOneToMany> list = query.getResultList();
		for (UserOneToMany userOneToOne : list) {
			System.out.println(userOneToOne);
		}
		session.close();
	}

	@Override
	public void displaySingleUserAddressDetails() {
		Session session = sessionFactory.openSession();
		System.out.println("Enter User Id to get the details: ");
		UserOneToMany user = session.get(UserOneToMany.class, sc.nextInt());
		System.out.println(user);

	}

	@Override
	public void updateSingleUserDetails() {

		Session session = sessionFactory.openSession();
		System.out.println("Enter User Id to get the details: ");
		UserOneToMany user = session.get(UserOneToMany.class, sc.nextInt());
		System.out.println(user);
		System.out.println("Enter your Name to update: ");
		user.setName(sc.next());

		System.out.println("Select Address which you want to update:");
		List<Address> addressList = user.getAddress();
		Collections.sort(addressList);
		int addId = 0;
		for (Address add : user.getAddress()) {
			System.out.println("Id:" + add.getAddId() + "  Local address");
			System.out.println("Id:" + add.getAddId() + "  Perm address");
			addId = sc.nextInt();
		}

		for (Address add : user.getAddress()) {

			if (add.getAddId() == addId) {
				System.out.println("Enter First Line Of address: ");
				add.setFirstLine(sc.next());
				System.out.println("Enter Second line of  address: ");
				add.setSecondLine(sc.next());
				System.out.println("Enter Pincode of Address: ");
				add.setPinCode(sc.nextInt());
				session.save(user);
			}
		}

		System.out.println(user);

	}

}

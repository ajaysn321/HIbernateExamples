package com.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Car;
import com.util.HibernateUtil;

public class ServiceImpl implements ServiceI{

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void insertData() {
		// TODO Auto-generated method stub
		Session session =  sf.openSession();
		Car car =new Car();
		System.out.println("Enter Car Id : ");
		car.setCid(sc.nextInt());
		System.out.println("Enter Car Name : ");
		car.setCname(sc.next());
		System.out.println("Enter Car Tyoe : ");
		car.setCtype(sc.next());
		
		session.save(car);
		session.beginTransaction().commit();
		System.out.println("Car Data Inserted....!");
	}

	@Override
	public void showAllData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Car> criteriaQuery = builder.createQuery(Car.class);
		Root<Car> root = criteriaQuery.from(Car.class);
		           criteriaQuery.select(root);
		           
		Query<Car> query = session.createQuery(criteriaQuery);
		List<Car> clist = query.getResultList();
		System.out.println(clist);
	}

	@Override
	public void getSingleUser() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Car> criteriaQuery = builder.createQuery(Car.class);
		System.out.println("Enter Car Id : ");
		int cid = sc.nextInt();
		Root<Car> root = criteriaQuery.from(Car.class);
		          criteriaQuery.select(root).where(builder.equal(root.get("cid"),cid));
		Query<Car> query = session.createQuery(criteriaQuery);
		Car car = query.getSingleResult();
		System.out.println("Car Data : " + car);
	}

	@Override
	public void getSingleColumnData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
		Root<Car> root = criteriaQuery.from(Car.class);
		                criteriaQuery.select(root.get("cname"));
		                
		Query<String> query = session.createQuery(criteriaQuery);
		List<String> list = query.getResultList();
		System.out.println(list);
	}

	@Override
	public void getMultipleColumnData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		Root<Car> root = criteriaQuery.from(Car.class);
		                criteriaQuery.multiselect(root.get("cname"),root.get("ctype"));
	    Query<Object[]> query = session.createQuery(criteriaQuery);
		List<Object[]> list = query.getResultList();
	    
		 for(Object[] o: list) {
			 System.out.println("Cname : " + o[0]);
			 System.out.println("Ctype : " + o[1]);
		 }
	
	}

}

package com.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.EmployeeInfo;
import com.util.HibernateUtil;

@SuppressWarnings(value = {"unchecked","unused"})
public class ServiceImpl implements ServiceI{

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		EmployeeInfo emp = new EmployeeInfo();
		
		System.out.println("Enter Employee ID : ");
		emp.setEid(sc.nextInt());
		System.out.println("Enter Employee Name : ");
		emp.setEname(sc.next());
		System.out.println("Enter Employee Address : ");
		emp.setAddress(sc.next());
		Date date = new Date(System.currentTimeMillis());
		emp.setJoinnigDate(date);
		System.out.println("Check Date : " + date);
		System.out.println("Enter Employee Salary : ");
		emp.setSalary(sc.nextDouble());
	
		Session session = sf.openSession();
		session.save(emp);
		session.beginTransaction().commit();
		System.out.println("Data Inserted...!");
	
	}

	@Override
	public void showAllUserDataUsingHql() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		List<EmployeeInfo> eList = session.createQuery("from EmployeeInfo").getResultList();
		eList.forEach((n) -> System.out.println(n));
	}

	@Override
	public void getSingleDataUsingHql() {
		// TODO Auto-generated method stub
      Session session = sf.openSession();
      System.out.println("Enter Employee Id : ");
      int i = sc.nextInt();
      Query<EmployeeInfo> query = session.createQuery("from EmployeeInfo where eid=:id");
      query.setParameter("id", i);
      EmployeeInfo e = query.getSingleResult();
      System.out.println(e);
	}

	@Override
	public void updateSingleDataUsingHql() {
		// TODO Auto-generated method stub
		  Session session = sf.openSession();
	      System.out.println("Enter Employee Id : ");
	      int i = sc.nextInt();
	      Query<EmployeeInfo> query = session.createQuery("from EmployeeInfo where eid=:id");
	      query.setParameter("id", i);
	      EmployeeInfo e = query.getSingleResult();
	      System.out.println(e);
	      
	      Session session2 = sf.openSession();
	      Transaction tx = session2.beginTransaction();
	      System.out.println("Enter Emloyee ID :  ");
	      int i1 = sc.nextInt();
	      String str = "update EmployeeInfo set joinnigDate=: jdate where eid=:id";
	      Query<EmployeeInfo> empQuery = session2.createQuery(str);
	      Date date = new Date(System.currentTimeMillis());
	      empQuery.setParameter("jdate", date);
	      empQuery.setParameter("id", i1);
	      empQuery.executeUpdate();
	      System.out.println("Data Updated...!");
	}

	@Override
	public void deleteSingleDataUsingHql() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
	      System.out.println("Enter Employee Id : ");
	      int i = sc.nextInt();
	      Query<EmployeeInfo> query = session.createQuery("delete EmployeeInfo where eid=:id");
	      query.setParameter("id", i);
	      query.executeUpdate();
	      System.out.println("EmployeeData Deleted...!");
	}

	@Override
	public void getAllDataUsingHqlAsClause() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		List<EmployeeInfo> eList = session.createQuery("from EmployeeInfo AS e").getResultList();
		eList.forEach((n) -> System.out.println(n));
	}

	@Override
	public void getDataUsingOrderBy() {
		// TODO Auto-generated method stub
	   Session session = sf.openSession();
	   String str = "from EmployeeInfo As e where e.eid > 0 order by e.salary asc";
	   Query<EmployeeInfo> query = session.createQuery(str);
	   List<EmployeeInfo> elist = query.getResultList();
	   System.out.println(elist);
	}

	@Override
	public void selectPericularColumn() {
		// TODO Auto-generated method stub
		  Session session = sf.openSession();
	      Query<EmployeeInfo> query = session.createQuery("select e.ename from EmployeeInfo e");
	      List<EmployeeInfo> e = query.getResultList();
	      System.out.println(e);
	}

	@Override
	public void findCount() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
	      Query<EmployeeInfo> query = session.createQuery("select count(distinct ename) from EmployeeInfo");
	      List<EmployeeInfo> count = query.getResultList();
	      System.out.println(count);

	}

	@Override
	public void maXPaidAmountFind() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
	      Query<EmployeeInfo> query = session.createQuery("select max(salary) from EmployeeInfo");
	      List<EmployeeInfo> max = query.getResultList();
	      System.out.println(max);
	}

	@Override
	public void calculateAllPaindAmount() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
	      Query<EmployeeInfo> query = session.createQuery("select sum(salary) from EmployeeInfo");
	      List<EmployeeInfo> sum = query.getResultList();
	      System.out.println(sum);
	}

}

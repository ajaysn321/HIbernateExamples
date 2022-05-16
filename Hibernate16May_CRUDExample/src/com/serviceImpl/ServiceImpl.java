package com.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Employee;
import com.service.ServiceI;
import com.util.HibernateUtil;

public class ServiceImpl implements ServiceI {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addEmployee() {

		Employee e = new Employee();
		System.out.println("Enter Employee Id : ");
		e.setEid(sc.nextInt());
		System.out.println("Enter Employee Name : ");
		e.setEname(sc.next());
		System.out.println("Enter Employee Address : ");
		e.setEaddress(sc.next());
		System.out.println("Enter Employee Salary : ");
		e.setSalary(sc.nextDouble());

		Session session = sf.openSession();
		session.save(e);
		session.beginTransaction().commit();
		System.out.println("Employee Data Stored....!");
	}

	@Override
	public void addMutipleEmployee() {

		System.out.println("How Many Employee To Be Add : ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Employee e = new Employee();
			System.out.println("Enter Employee Id : ");
			e.setEid(sc.nextInt());
			System.out.println("Enter Employee Name : ");
			e.setEname(sc.next());
			System.out.println("Enter Employee Address : ");
			e.setEaddress(sc.next());
			System.out.println("Enter Employee Salary : ");
			e.setSalary(sc.nextDouble());

			Session session = sf.openSession();
			session.save(e);
			session.beginTransaction().commit();
			System.out.println("Employee Data Stored....!");
		}

	}

	@Override
	public void showAllEmployee() {
		Session session = sf.openSession();
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> empList = query.getResultList();
		System.out.println("======================= All Employee Data =====================");
		for (Employee emp : empList) {
			System.out.println("Employee Id      : " + emp.getEid());
			System.out.println("Employee Name    : " + emp.getEname());
			System.out.println("Employee Address : " + emp.getEaddress());
			System.out.println("Employee Salary  : " + emp.getSalary());
			System.out.println("---------------------------------------------");
		}
	}

	@Override
	public void showSingleEmployeeUsingId() {
		Session session = sf.openSession();
		System.out.println("Enter Employee Id : ");
		int id = sc.nextInt();
		Employee emp = session.get(Employee.class, id);
		System.out.println("Employee Id      : " + emp.getEid());
		System.out.println("Employee Name    : " + emp.getEname());
		System.out.println("Employee Address : " + emp.getEaddress());
		System.out.println("Employee Salary  : " + emp.getSalary());
	}

	@Override
	public void updateEmployee() {
		Session session = sf.openSession();
		System.out.println("Enter Employee Id : ");
		int id = sc.nextInt();
		Employee e = showSingleEmployeeUsingId(id);
		e.setEid(id);
		System.out.println("Enter Employee Name : ");
		e.setEname(sc.next());
		System.out.println("Enter Employee Address : ");
		e.setEaddress(sc.next());
		System.out.println("Enter Employee Salary : ");
		e.setSalary(sc.nextDouble());

		session.update(e);
		session.beginTransaction().commit();
		System.out.println("Update Employee Data Done");
	}

	@Override
	public void deleteEMployee() {
		Session session = sf.openSession();
		System.out.println("Enter Employee Id : ");
		int id = sc.nextInt();
		Employee emp = session.get(Employee.class, id);
		session.delete(emp);
		session.beginTransaction().commit();
		System.out.println("Employee Deleted");
	}

	@Override
	public Employee showSingleEmployeeUsingId(int id) {
		Session session = sf.openSession();
		Employee emp = session.get(Employee.class, id);
		System.out.println("----------------------------------------------------");
		System.out.println("Employee Id      : " + emp.getEid());
		System.out.println("Employee Name    : " + emp.getEname());
		System.out.println("Employee Address : " + emp.getEaddress());
		System.out.println("Employee Salary  : " + emp.getSalary());
		System.out.println("----------------------------------------------------");
		return emp;
	}
}

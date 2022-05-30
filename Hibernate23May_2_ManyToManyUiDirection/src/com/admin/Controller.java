package com.admin;

import org.hibernate.Session;

import com.model.Person;
import com.model.Simcard;
import com.util.HibernateUtil;

public class Controller {
	
	public static void main(String[] args) {
		
	 Person person = new Person();
	 person.setPid(123);
	 person.setPname("Abcd");

	 Person person1 = new Person();
	 person1.setPid(124);
	 person1.setPname("Pqrs");
	 
	 
	 Simcard sim1 = new Simcard();
	 sim1.setSid(1);
	 sim1.setSname("VI");
	 sim1.setSimtype("4G");
	 
	 Simcard sim2 = new Simcard();
	 sim2.setSid(2);
	 sim2.setSname("Airtel");
	 sim2.setSimtype("4G");
	 
	 person.getSimcards().add(sim1);
	 person.getSimcards().add(sim2);
	 
	 person1.getSimcards().add(sim2);
	
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 session.save(person);
	 session.save(person1);
	 session.beginTransaction().commit();
	 
	}

}

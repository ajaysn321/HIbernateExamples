package com.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.model.Student;

public class HibenateUtil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sf;

	public static SessionFactory getSessionFactory() {

		if (sf == null) {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/mydba");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "password");

			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			map.put(Environment.HBM2DDL_AUTO, "create");
			map.put(Environment.SHOW_SQL, true);
			
			registry = new StandardServiceRegistryBuilder().applySettings(map).build();
			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(Student.class);
			Metadata md = mds.getMetadataBuilder().build();
			sf = md.getSessionFactoryBuilder().build();
		}

		return sf;
	}

}

package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) throws IOException {
	
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		FileInfo fileInfo = new FileInfo();
		
		File file = new File("E:\\All Procedure.zip");
		fileInfo.setFid(123);
		fileInfo.setFname(file.getName());
		fileInfo.setFsize(file.length());
		
		byte[] b = Files.readAllBytes(file.toPath());
		
		fileInfo.setFiledata(b);
		fileInfo.setStatus(false);
		
		System.out.println(fileInfo);
		session.save(fileInfo);
		session.beginTransaction().commit();
		System.out.println("Data Inserted...!");
	}
	
}

package com;

import java.io.FileOutputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test1 {
	
	public static void main(String[] args) throws IOException {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		FileInfo fileInfo = session.get(FileInfo.class, 125);
		System.out.println(fileInfo.isStatus());
		
		FileOutputStream fos = new FileOutputStream("G:\\"+fileInfo.getFname()); 
            fos.write(fileInfo.getFiledata());
            System.out.println("File Write......!");
	
		
	}

}

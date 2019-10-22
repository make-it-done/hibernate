package com.rohit.Hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rohit.entity.Customer;


public class Database {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
//		String driver = "com.mysql.jdbc.Driver";
//		Class.forName(driver);
		String url="jdbc:mysql://localhost:3306/web_customer_tracker";
		
		try {
			
			Connection connection = DriverManager.getConnection(url, "springstudent", "springstudent");		
			System.out.println("Connection Successful");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
		
		
		SessionFactory sessionFactory = new Configuration()
				.configure("/Config/hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session Created");
		try {
//			session.beginTransaction();
//			
//				
//			Customer rohit = new Customer("rohitkum", "kumar", "rohitislampur@gmail.com");
//			session.save(rohit);
//			
//			Customer customer=session.get(Customer.class, rohit.getId());
//			System.out.println(customer.toString()+" nothing");
//			session.getTransaction().commit();
			
			
			session.beginTransaction();
			
			List<Customer> cList = session.createQuery("from Customer where firstName like '%rohit%'").getResultList();
			
			for(Customer customer : cList)
			{
				System.out.println(customer.toString());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("exception happend");
		}
		session.close();
		sessionFactory.close();
	}

}

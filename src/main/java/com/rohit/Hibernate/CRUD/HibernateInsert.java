package com.rohit.Hibernate.CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rohit.entity.Customer;

public class HibernateInsert {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("/Config/hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session Created");
		try {
			session.beginTransaction();
			
				
			Customer rohit = new Customer("rohitkum", "kumarroh", "rohitislampur@gmail.com");
			session.save(rohit);
			
			Customer customer=session.get(Customer.class, rohit.getId());			
			System.out.println(customer.toString()+" nothing");
			session.getTransaction().commit();
			

			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("exception happend");
		}
		session.close();
		sessionFactory.close();
	}

	
}

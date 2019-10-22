package com.rohit.Hibernate.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rohit.entity.Customer;
import com.rohit.entity.Student;

public class HibernateDelete {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("/Config/hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session Created");
		try {
			session.beginTransaction();
//
//			Customer customer = session.get(Customer.class, 6);
//			
//			System.out.println(customer.toString());
//			
//			session.delete(customer);
			
			session.createQuery("delete from Customer where firstName = 'changerohit'").executeUpdate();
			
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

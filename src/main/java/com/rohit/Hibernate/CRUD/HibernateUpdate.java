package com.rohit.Hibernate.CRUD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.rohit.entity.Customer;

public class HibernateUpdate {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("/Config/hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session Created");
		try {
			session.beginTransaction();

//			List<Customer> cList = session.createQuery("from Customer where firstName = 'rohit'").getResultList();
//			
//			for(Customer customer:cList)
//			{
//				customer.setFirstName("changedrohit");
//			}
			
			session.createQuery("update Customer set firstName ='changerohit' where firstName like 'rohit%'").executeUpdate();
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

package com.rohit.hb_01_one_to_one_uni;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rohit.entity.Instructor;
import com.rohit.entity.InstructorDetail;

public class OneToOneBidirectional {
	
	public static void main(String[] args) throws ClassNotFoundException {

		SessionFactory sessionFactory = new Configuration().configure("/Config/hibernate_hb-01-one-to-one-uni.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session Created");
		try {
			session.beginTransaction();

			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
			
			System.out.println(instructorDetail.getInstructor().toString());
			
			@SuppressWarnings("unchecked")
			List<InstructorDetail> cList = session.createQuery("From InstructorDetail").getResultList();

			for(InstructorDetail instructor2 : cList)
			{
				System.out.println(instructor2.toString());
			}

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

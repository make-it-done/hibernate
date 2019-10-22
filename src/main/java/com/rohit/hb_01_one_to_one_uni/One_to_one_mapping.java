package com.rohit.hb_01_one_to_one_uni;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.rohit.entity.Instructor;
import com.rohit.entity.InstructorDetail;

public class One_to_one_mapping {

	public static void main(String[] args) throws ClassNotFoundException {

		SessionFactory sessionFactory = new Configuration().configure("/Config/hibernate_hb-01-one-to-one-uni.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session Created");
		try {
			session.beginTransaction();

			InstructorDetail instructorDetail = new InstructorDetail("myChannel", "song");
			Instructor instructor = new Instructor("rohit", "kumar", "rohitislampur");
			
			instructor.setInstructorDetail(instructorDetail);
			session.save(instructor);
			
			@SuppressWarnings("unchecked")
			List<Instructor> cList = session.createQuery("From Instructor").getResultList();

			for(Instructor instructor2 : cList)
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

package com.rohit.hb_03_one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rohit.entity.Course;
import com.rohit.entity.Instructor;
import com.rohit.entity.InstructorDetail;

public class OneToManyMappingInsert {

	public static void main(String[] args) throws ClassNotFoundException {

		SessionFactory sessionFactory = new Configuration().configure("/Config/hibernate_hb-03-one-to-many.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session Created");
		try {
			session.beginTransaction();

			InstructorDetail instructorDetail = new InstructorDetail("myChannel", "song");
			
			Instructor instructor = new Instructor("rohit", "kumar", "rohitislampur");
			instructor.setInstructorDetail(instructorDetail);
			
			Course course = new Course("Physics");
			//course.setInstructor(instructor);
			instructor.add(course);
			
			session.save(instructor);
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

package com.rohit.hb_04_one_to_many_uni;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rohit.entity.Course;
import com.rohit.entity.Instructor;
import com.rohit.entity.InstructorDetail;
import com.rohit.entity.Review;

public class OneToManyUniInsert {
	
	public static void main(String[] args) throws ClassNotFoundException {

		SessionFactory sessionFactory = new Configuration().configure("/Config/hibernate_hb-04-one-to-many-uni.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session Created");
		try {
			session.beginTransaction();

			InstructorDetail instructorDetail = new InstructorDetail("myChannel", "song");
			
			Instructor instructor = new Instructor("rohit", "kumar", "rohitislampur");
			instructor.setInstructorDetail(instructorDetail);
			
			Course course = new Course("Physics");
			course.setInstructor(instructor);
			
			Review review=new Review("course is good");
			Review review2=new Review("Need some improvement");
			
			course.addReview(review2);
			course.addReview(review);
			
			//instructor.add(course);
			session.save(instructor);
			session.save(course);
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

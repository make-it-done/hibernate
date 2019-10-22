package com.rohit.hb_03_one_to_many;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rohit.entity.Course;
import com.rohit.entity.Instructor;
import com.rohit.entity.InstructorDetail;

public class OneToManyMappingGet {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {

		SessionFactory sessionFactory = new Configuration().configure("/Config/hibernate_hb-03-one-to-many.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session Created");
		try {
			session.beginTransaction();

			List<Course> courses = session.createQuery("From Course").getResultList();

			for (Course course : courses) {
				System.out.println(course.toString());
			}

			List<Instructor> instructors = session.createQuery("From Instructor").getResultList();

			for (Instructor instructor : instructors) {
				System.out.println(instructor.toString());
				System.out.println("start");
				for (Course course : instructor.getCourses())
					System.out.println(course.toString());
			}

			List<InstructorDetail> instructorDetails = session.createQuery("From InstructorDetail").getResultList();
			for (InstructorDetail instructorDetail : instructorDetails) {
				System.out.println(instructorDetail.toString());
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

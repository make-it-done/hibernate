package com.rohit.hb_05_many_to_many;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rohit.entity.Course;
import com.rohit.entity.Instructor;
import com.rohit.entity.InstructorDetail;
import com.rohit.entity.Review;
import com.rohit.entity.Student;

public class ManyToManyQuery {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {

		SessionFactory sessionFactory = new Configuration().configure("/Config/hibernate_hb-05-many-to-many.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session Created");
		try {
			session.beginTransaction();
			List<Student> students = session.createQuery("From Student").getResultList();
			List<Course> courses= session.createQuery("From Course").getResultList();
			
			for(Course course:courses)
			{
				System.out.println(course.toString());
			}
			System.out.println("\n******************\n");
			
			for(Student student:students)
			{
				System.out.println(student.toString()+" \nCourses are");
				for(Course course:student.getCourses())
					System.out.println(course.toString());
				
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

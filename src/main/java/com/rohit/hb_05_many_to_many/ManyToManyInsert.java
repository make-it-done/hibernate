package com.rohit.hb_05_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rohit.entity.Course;
import com.rohit.entity.Instructor;
import com.rohit.entity.InstructorDetail;
import com.rohit.entity.Review;
import com.rohit.entity.Student;

public class ManyToManyInsert {

	public static void main(String[] args) throws ClassNotFoundException {

		SessionFactory sessionFactory = new Configuration().configure("/Config/hibernate_hb-05-many-to-many.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session Created");
		try {
			//session.beginTransaction();
			Student student=new Student("rohit2gfh", "kumar", "islampur");
			Student student2=new Student("projjfdsfa2l", "kundu", "projjal1611");
			
			Course course = new Course("Newfd tfdrCohgfdurse");
			Course course2=new Course("Pshhhggfdshhhhghu");
			
			student.addCourse(course);
			student.addCourse(course2);
			
			student2.addCourse(course);
			student2.addCourse(course2);
			
			session.save(course);
			session.save(course2); 
			
			session.save(student);
			session.save(student2);
			
			
			
			//session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("exception happend");
		}
		session.close();
		sessionFactory.close();
	}

}

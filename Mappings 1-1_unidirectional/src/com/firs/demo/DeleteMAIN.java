package com.firs.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fisr.entity.Instructor;
import com.fisr.entity.InstructorDetail;

public class DeleteMAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
//			// create the objects
//			Instructor I1 = new Instructor("teja", "tavva", "tej@gmail.com");
//			InstructorDetail ID1 = new InstructorDetail("kitchen/youtube", "love cooking");
			// create the objects
			Instructor I1 = new Instructor("sandhya", "gorle", "gorle@gmail.com");
			InstructorDetail ID1 = new InstructorDetail("sports/youtube", "love Runningee");
			// associate the objects
			I1.setInstructorDetail(ID1);
			// start a transaction
			session.beginTransaction();
			// save the instructor
			// this will also save the Instructor detail object
			// because CascadeType.ALL
			System.out.println("Saving instructor" + I1);
			session.save(I1);
			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}

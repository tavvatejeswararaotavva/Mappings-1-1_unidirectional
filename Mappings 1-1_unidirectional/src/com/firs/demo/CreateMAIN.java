package com.firs.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fisr.entity.Instructor;
import com.fisr.entity.InstructorDetail;

public class CreateMAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
//			// create the objects
//			Instructor I1 = new Instructor("teja", "tavva", "tej@gmail.com");
//			InstructorDetail ID1 = new InstructorDetail("kitchen/youtube", "love cooking");

			session.beginTransaction();

			int theId = 3;
			Instructor Id1 = session.get(Instructor.class, theId);
			System.out.println(Id1);
			if (Id1 != null) {
				System.out.println("Deleting :" + Id1);
				session.delete(Id1);
			}
			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}

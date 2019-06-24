package com.sonam.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstructorDetailDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			int id=6;
			InstructorDetail inst=session.get(InstructorDetail.class,id);
			Instructor instData= inst.getInstructor();
			System.out.println(instData.getEmail());			
			System.out.println("Hobby is"+inst.getHobby());
			System.out.println("Youtube Channel"+inst.getYoutube_channel());
			//You are breaking the link between instructor and 
			//instructor detail using the below statement and it is important
			//to remember the fact that Cascade.ALL should be replaced with cascade.Detach 
			//Cascade.refresh cascade.merge and cascade.persist
			inst.getInstructor().setInstructorDetail(null);
			session.delete(inst);
			session.getTransaction().commit();		
			//SUCCESS!!!!!
			// HUH HUH!!!!!!!!!!!
		    }
		catch(Exception ex)
		    {
			System.out.println(ex.getMessage());		
		    }
		finally
			{
			session.close();
			factory.close();			
			}
		
	}

}

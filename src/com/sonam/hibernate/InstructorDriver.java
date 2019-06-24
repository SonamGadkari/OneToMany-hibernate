package com.sonam.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstructorDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory =new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			//Start here: Added a new instructor and his details
		/*	session.beginTransaction();
			Instructor instr=new Instructor("Sandeep","Jain","sandeep.jain@gmail.com");
			InstructorDetail insDetail=new InstructorDetail("https://dbmsconcepts.org","Teacher");			
			instr.setInstructorDetail(insDetail);	
			session.save(instr);
			session.getTransaction().commit();*/
			//Ends here
			//Start here: create multiple courses
		/*	Instructor instr=new Instructor("sonam","gadekari", "sonam.gadekari@gmail.com");
			session=factory.getCurrentSession();
			session.beginTransaction();
			Course co1=new Course("Oops",instr);			
			instr.add(co1);		
			session.save(co1);
			Course co2=new Course("Dbms",instr);
			instr.add(co2);
			session.save(co2);
			Course co3=new Course("Java",instr);
			instr.add(co3);
			session.save(co3);			
			session.save(instr);
			session.getTransaction().commit();
			*/
		/*	session=factory.getCurrentSession();
			session.beginTransaction();		
			Instructor instr1=session.get(Instructor.class, 7);
			session.delete(instr1);
			session.getTransaction().commit();
			*/		
			session=factory.getCurrentSession();
			session.beginTransaction();
			Course cr=session.get(Course.class, 21);
			session.delete(cr);
			session.getTransaction().commit();
			//Ends here: multiple courses are added and are ended here. 			
			//update the records using the get
			/*session=factory.getCurrentSession();
			session.beginTransaction();
			int id=3;
			Instructor instr1= session.get(Instructor.class, id); 
			Course co4=new Course("Web Apps",instr1);
			session.save(co4);
			session.save(instr1);
			session.getTransaction().commit();
			*/	
			//Delete a course		
			/*
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Before begin transaction");
			int id=3;
			Instructor instr1= session.get(Instructor.class, id); 
			List<Course> courses=instr1.getCourse();
			for(Course co1:courses)
			{
				session.delete(co1);
			}
			session.getTransaction().commit();
			System.out.println("instr1 courses"+instr1.getCourse().get(0).getTitle());
			*/
			//Delete instructor details
			/*
			session=factory.getCurrentSession(); 
			session.beginTransaction(); 
			System.out.println("Before begin transaction"); 
			int id=2; 			
		//	Instructor instr= session.get(Instructor.class, id);
			//instr.setInstructorDetail(null);			
			//InstructorDetail instrdet=instr.set;
			/*instr.setInstructorDetail(null);*/
			/*InstructorDetail intrdetail=session.get(InstructorDetail.class, id);
			intrdetail.getInstructor().setInstructorDetail(null);
		
			//session.delete(intrdetail);
			//session.delete(intrdetail);
			//System.out.println(instrdet);
			session.delete(intrdetail);
			session.getTransaction().commit();
			*/
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

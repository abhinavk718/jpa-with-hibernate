package com.tyss.jpawithhibernateapp;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.manytomany.Course;
import com.tyss.jpawithhibernateapp.manytomany.Student;

public class TestManyToMany 
{

	public static void main(String[] args)
	{
		Course course=new Course();
		course.setCid(1);
		course.setCname("JAVA");
		 
		Course course1=new Course();
		course1.setCid(2);
		course1.setCname("SQl");
		
		Course course2=new Course();
		course2.setCid(3);
		course2.setCname("JDBC");
		
		
		ArrayList<Course> al=new ArrayList<Course>();
		al.add(course);
		al.add(course1);
		al.add(course2);
		
		Student student=new Student();
		student.setSid(102);
		student.setSname("Aniket");
		student.setCourse(al);
		
		EntityManager entityManager=null;
		EntityTransaction entityTransaction =null;
		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction =entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(student);
			System.out.println("Record Inserted Successfully.");
			entityTransaction.commit();	
		}
		catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
	}//end of main() method
}//end of TestManyToMany class

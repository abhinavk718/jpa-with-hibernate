package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.manytoone.Pencil;
import com.tyss.jpawithhibernateapp.manytoone.PencilBox;


public class TestManyToOne 
{
	public static void main(String[] args) 
	{
		PencilBox pencilBox=new PencilBox();
		pencilBox.setBid(25);
		pencilBox.setBname("Natraj");
		
		Pencil pencil=new Pencil();
		pencil.setPid(150);
		pencil.setColor("Yellow");
		pencil.setPencilBox(pencilBox);
		
		Pencil pencil1=new Pencil();
		pencil1.setPid(151);
		pencil1.setColor("Brown");
		pencil1.setPencilBox(pencilBox);
		
		EntityManager entityManager=null;
		EntityTransaction entityTransaction =null;
		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction =entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(pencil);
			entityManager.persist(pencil1);
			System.out.println("Record Inserted Successfully.");
			entityTransaction.commit();	
		}
		catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
	}//end main() method
}//end of TestManyToOne class 

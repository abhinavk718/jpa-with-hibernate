package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.onetoone.Person;
import com.tyss.jpawithhibernateapp.onetoone.VoterCard;

public class TestOneToOne
{
	public static void main(String[] args)
	{
		VoterCard vc=new VoterCard();
		vc.setVid(20);
		vc.setVName("Sita");
		
		Person person=new Person();
		person.setPid(2);
		person.setName("Sita");
		person.setVoterCard(vc);
		
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction  entityTransaction =null;
		try 
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction =entityManager.getTransaction();
			entityTransaction.begin();
			
			VoterCard vCard=entityManager.find(VoterCard.class, 10);
			System.out.println(vCard.getPerson().getPid());
			//entityManager.persist(person);
			System.out.println("Record Inserted Successfully.");
			entityTransaction.commit();	
		}
		catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
	}//end of main() method
}//end of TestOneToOne

package com.tyss.jpawithhibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateDemo 
{
	public static void main(String[] args)
	{ 
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction entityTransaction=null;
		try
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
		    entityManager=entityManagerFactory.createEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			String jpql="update ProductInfo set pname='Bullet' where pid=103";
			Query query = entityManager.createQuery(jpql);
			int result=query.executeUpdate();
			System.out.println(result);
			entityTransaction.commit();	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			entityTransaction.rollback();
		}
		finally
		{
			entityManager.close();	
		}
	}//end of main() method
}//end of UpdateDemo

package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.dto.ProductInfo;

public class UpdateDemo
{
	public static void main(String[] args) 
	{
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager=null;
		EntityTransaction entityTransaction=null;
		
		try 
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			ProductInfo productInfo=entityManager.find(ProductInfo.class, 101);
			productInfo.setPname("Register_Book");
			System.out.println("Record Updated Successfully.");
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
}//end of UpdateDemo class

package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.dto.ProductInfo;

public class InsertDemo 
{
	public static void main(String[] args) 
	{
		ProductInfo productInfo=new ProductInfo();
		productInfo.setPid(105);
		productInfo.setPname("Watch");
		productInfo.setPrice(4500);
		productInfo.setQuantity(45);
		
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager	= null;
		EntityTransaction entityTransaction = null;
		try
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(productInfo);
			System.out.println("Record Inserted Successfully.");
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
}//end of InsertDemo class 

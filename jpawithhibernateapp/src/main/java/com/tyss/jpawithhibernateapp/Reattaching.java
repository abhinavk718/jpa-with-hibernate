package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.dto.ProductInfo;

public class Reattaching {

	public static void main(String[] args) 
	{
		EntityManagerFactory entityManagerFactory =null;
		EntityManager entityManager=null;
		EntityTransaction entityTransaction=null;
		try 
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			ProductInfo  productInfo=entityManager.find(ProductInfo.class, 102);
			System.out.println(entityManager.contains(productInfo));
			entityManager.detach(productInfo);
			System.out.println(entityManager.contains(productInfo));
			ProductInfo productInfo2= entityManager.merge(productInfo);
			
			productInfo2.setPname("Bus");
			System.out.println("Record updated");
			entityTransaction.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			entityTransaction.rollback();
		} 
		entityManager.close();
	}//end of main() method
}//end of Reattaching

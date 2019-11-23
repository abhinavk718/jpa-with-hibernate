package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.dto.ProductInfo;

public class GetRefrence 
{
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
			ProductInfo  productInfo=entityManager.getReference(ProductInfo.class, 103);
			System.out.println(productInfo.getPid());
			System.out.println(productInfo.getPname());
			System.out.println(productInfo.getQuantity());
			System.out.println(productInfo.getClass());//it will return proxy object
			
			entityManager.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			entityTransaction.rollback();
		} 
	}//end of main() method
}//end of  GetRefrence 

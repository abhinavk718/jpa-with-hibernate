package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.dto.ProductInfo;

public class UpdateDemo 
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
			entityTransaction.begin();
			ProductInfo  productInfo=entityManager.find(ProductInfo.class, 102);
			productInfo.setPname("Bike");
			System.out.println("Record updated");
			entityTransaction.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			entityTransaction.rollback();
		} 
	}//end of main() method
}//end of UpdateDemo

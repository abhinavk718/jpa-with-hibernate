package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.dto.ProductInfo;

public class InsertDemo 
{
	public static void main(String[] args) 
	{
		ProductInfo prductInfo=new ProductInfo();
		prductInfo.setPid(104);
		prductInfo.setPname("Car");
		prductInfo.setQuantity(10);
		
		EntityManager entityManager=null;
		EntityTransaction entityTransaction =null;
		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction =entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(prductInfo);
			System.out.println("Record Inserted");
			entityTransaction.commit();	
		}
		catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
	}//end main() method
}//end of  InsertDemo

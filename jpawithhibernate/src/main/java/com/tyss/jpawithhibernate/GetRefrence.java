package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.dto.ProductInfo;

public class GetRefrence
{
	public static void main(String[] args)
	{
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		try
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			ProductInfo productInfo=entityManager.getReference(ProductInfo.class, 102);
			System.out.println("Pid is :"+productInfo.getPid());
			System.out.println("pname is  : "+productInfo.getPname());
			System.out.println("price is : "+productInfo.getPrice());
			System.out.println("Quantity is : "+productInfo.getQuantity());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}//end of catch block
	}//end of main() method
}//end of GetRefrence class

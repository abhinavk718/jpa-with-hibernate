package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.dto.ProductInfo;

public class ReadDemo 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		
		try 
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			ProductInfo productInfo=entityManager.find(ProductInfo.class, 102);
			System.out.println("Pid is : "+productInfo.getPid());
			System.out.println("Pname is : "+productInfo.getPname());
			System.out.println("Price is : "+productInfo.getPrice());
			System.out.println("Quantity is : "+productInfo.getQuantity());	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}//end of catch block
	}//end of main() method
}//end of ReadDemo class

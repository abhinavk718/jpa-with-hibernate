package com.tyss.jpawithhibernateapp.jpql;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernateapp.dto.ProductInfo;


public class ReadDemo
{
	public static void main(String[] args)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String jpql="from ProductInfo";
		Query query=entityManager.createQuery(jpql);
		List<ProductInfo> list=query.getResultList();
		for (ProductInfo productInfo : list) 
		{
			System.out.println(productInfo.getPid());
			System.out.println(productInfo.getPname());
			System.out.println(productInfo.getQuantity());
			System.out.println("**********************");
		}
	}//end of main() method
}//end of ReadDemo

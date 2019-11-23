package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.dto.ProductInfo;

public class ReadDemo {

	public static void main(String[] args) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		ProductInfo productDetail=entityManager.find(ProductInfo.class, 101);
		int pid=productDetail.getPid();
		String pname=productDetail.getPname();
		int quantity=productDetail.getQuantity();
		System.out.println("PID is : "+pid);
		System.out.println("Pname is : "+pname);
		System.out.println("Quantity is : "+quantity);
        entityManager.close();
	}//end of main() method
}//end of  ReadDemo

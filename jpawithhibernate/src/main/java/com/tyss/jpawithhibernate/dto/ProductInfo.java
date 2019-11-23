package com.tyss.jpawithhibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product_details")
public class ProductInfo 
{
	@Id
	@Column
	private int pid;
	
	@Column
	private String pname;
	
	@Column
	private int price;
	
	@Column
	private int quantity;
}//end of ProductInfo class

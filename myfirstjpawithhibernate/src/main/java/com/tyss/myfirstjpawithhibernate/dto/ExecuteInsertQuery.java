package com.tyss.myfirstjpawithhibernate.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteInsertQuery
{
	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql="insert into employee_info values(21,'Akshay',10000,'M')";
		
		Connection conn=null;
		Statement stmt=null;
		try
		{
			//Step 1 Load and register the Driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2 Get the connection
			conn=DriverManager.getConnection(url);
			
			//step 3 create statement and issue sql query
			stmt=conn.createStatement();
			
			//Step 4 Read executed sql query
			int count=stmt.executeUpdate(sql);
			if(count>0)
			{
				System.out.println(count+"Row's Inserted");
            }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//step 5 close all jdbc resources
			try
			{
				if(conn!=null)
				{
					conn.close();
				}
				else 
				{
					stmt.close();
					
				}
			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}//end of finally block
	}//end of main() method
}//end of ExecuteInsertQuery

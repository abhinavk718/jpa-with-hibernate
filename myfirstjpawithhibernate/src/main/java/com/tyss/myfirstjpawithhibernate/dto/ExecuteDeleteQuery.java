package com.tyss.myfirstjpawithhibernate.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteDeleteQuery 
{
	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql="delete from employee_info where id=20";
		
		Connection conn=null;
		Statement stmt=null;
		try 
		{
			//Step 1 Load and register the driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2 Get the connection
			conn=DriverManager.getConnection(url);
			
			//Step 3 create statement and issue SQL Query
			stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);
			
			//step 4 read the resultset
			if(count>0)
			{
				System.out.println(count+" Row's Deleted.");
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
}//end of ExecuteDeleteQuery

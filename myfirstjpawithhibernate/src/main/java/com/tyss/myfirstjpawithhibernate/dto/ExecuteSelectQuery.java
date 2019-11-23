package com.tyss.myfirstjpawithhibernate.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQuery
{
	public static void main(String[] args)
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try 
		{
			//step 1 load and register the driver
			Driver driver=new Driver();
			DriverManager.deregisterDriver(driver);
			
			//step 2 Get the connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			
			//step 3 create connection and issue sql query
			String sql="select * from employee_info";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			//step 4 Read the resultset
			while (rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int salary=rs.getInt("sal");
				String gender=rs.getString("gender");
				System.out.println("ID is : "+id);
				System.out.println("Name is : "+name);
				System.out.println("Salary is : "+salary);
				System.out.println("Gender is  : "+gender);
				System.out.println("***********************************");	
			}		
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}//end of catch block
		finally 
		{
			//step 5 end of all jdbc resources
			try 
			{
				if (conn!=null) 
				{
					conn.close();
				}
				else if(stmt!=null)
				{
                       stmt.close();
				}
				else
					rs.close();
			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}//end of catch block
		}//end of finally block
	}//end of main() method
}//end of ExecuteSelectQuery

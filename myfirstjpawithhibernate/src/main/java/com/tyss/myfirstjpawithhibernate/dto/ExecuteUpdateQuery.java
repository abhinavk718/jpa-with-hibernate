package com.tyss.myfirstjpawithhibernate.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteUpdateQuery 
{
	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql="update employee_info set id=19 where name='Roshan'";
		
		Connection conn=null;
		Statement stmt=null;
		try 
		{
			//step 1 load and register the driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//step 2 Get the connection
			conn=DriverManager.getConnection(url);
			
			//step 3 create statment and issue sql query
			stmt=conn.createStatement();
			
			//step 4 read the executed query
			int count=stmt.executeUpdate(sql);
			if (count>0) 
			{
				System.out.println(count+"Rows updated");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			//step 5 end of all jdbc resources
			try
			{
				if (conn!=null) {
					conn.close();
				} else {
                    stmt.close();
				}
				
			}
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}//end of finally block
	}//end of main() method
}//end of ExecuteUpdateQuery

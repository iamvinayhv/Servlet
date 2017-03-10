package com.jsp;

import java.sql.*;

public class Pojo 

{
	public Connection getConnection()
	{
		Connection connection=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/VinayKumar?user=root&password=tiger");
			
		} 
		catch (ClassNotFoundException |SQLException e) 
		{
			e.printStackTrace();
		} 
		
		return connection;
	}
	

	
	public boolean register(int id,String name,String sal,String dept,String pass)
	{
		String qry="insert into VinayKumar.employee values(?,?,?,?,?)";
		Connection connection=getConnection();
		PreparedStatement preparedStatement = null;
		
		try 
		{
			
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, sal);
			preparedStatement.setString(4, dept);
			preparedStatement.setString(5, pass);
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
		
	}
	
	
	
	public String login(int id,String password)
	{
		String qry="select Password,Ename from VinayKumar.employee where id=?";
		
		Connection connection=getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rs=null;
		
		
		try 
		{
			
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setInt(1, id);
			rs=preparedStatement.executeQuery();
			
			
			rs.next();
			String pwd=rs.getString("Password");
			
			if(password.equals(pwd))
			{
				String name;
				name = rs.getString("Ename");
				return name;
			}
			
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		
		finally
		{
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
		
	}
	
	
	public boolean delete(int id, String password)
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement = null;
		String qry="delete from VinayKumar.employee where id=? and password=?";
		int i=0;
		
		try
		{
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, password);
			i=preparedStatement.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(i==0)
			return false;
		else
			return true;
		
		
		
	}
	
}

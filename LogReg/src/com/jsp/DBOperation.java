package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.plaf.synth.SynthScrollBarUI;

import com.mysql.jdbc.Statement;

public class DBOperation 
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
	

	
	public boolean register(String name,String dept,String mail,String pwd)
	{
		String qry="insert into VinayKumar.logreg values(?,?,?,?)";
		Connection connection=getConnection();
		PreparedStatement preparedStatement = null;
		
		try 
		{
			
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, dept);
			preparedStatement.setString(3, mail);
			preparedStatement.setString(4, pwd);
			
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
	
	
	public boolean login(String mail,String password)
	{
		
		Connection connection=getConnection();
		String qry="select Password from VinayKumar.logreg where Email=?";
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		
		try 
		{

			preparedStatement=connection.prepareStatement(qry);
			preparedStatement.setString(1, mail);
			rs=preparedStatement.executeQuery();

			if(rs.next())
			{
				String pwd=rs.getString("Password");
				if(pwd.equals(password))
				{
					return true;
				}
			}
				
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;	
		}
		
			return false;	
	}
	
	
	public String users()
	{
		Connection connection=getConnection();
		String qry="select Email from VinayKumar.logreg";
		
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		String result="";
		String []resArr;
		
		try 
		{
			preparedStatement=connection.prepareStatement(qry);
			rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result=result+rs.getString("Email")+" ";
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return result;
				
	}
	
	
	
	public String details(String mail)
	{
		Connection connection=getConnection();
		
		String qry="select Name,Department,Email from VinayKumar.logreg where Email=?";
		
		ResultSet rs=null;
		
		String result="";
		try 
		{
			PreparedStatement preparedStatement=connection.prepareStatement(qry);
			preparedStatement.setString(1, mail);
			rs=preparedStatement.executeQuery();
			
			if(rs.next())
			{
				result=result+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		
		return result;
		
	}
	
	
	
	
	public boolean delete(String mail, String password)
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement = null;
		String qry="delete from VinayKumar.logreg where id=? and password=?";
		int i=0;
		
		try
		{
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setString(1,mail);
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

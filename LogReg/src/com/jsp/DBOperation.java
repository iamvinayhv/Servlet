package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	

	
	public boolean register(RegBean rb)
	{
		String qry="insert into VinayKumar.logreg values(?,?,?,?)";
		Connection connection=getConnection();
		PreparedStatement preparedStatement = null;
		
		try 
		{
			
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setString(1, rb.getName());
			preparedStatement.setString(2, rb.getDept());
			preparedStatement.setString(3, rb.getMail());
			preparedStatement.setString(4, rb.getPwd());
			
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
	
	
	public boolean login(LoginBean lb)
	{
		
		Connection connection=getConnection();
		String qry="select Password from VinayKumar.logreg where Email=?";
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		
		try 
		{

			preparedStatement=connection.prepareStatement(qry);
			preparedStatement.setString(1, lb.getMail());
			rs=preparedStatement.executeQuery();

			if(rs.next())
			{
				String pwd=rs.getString("Password");
				if(pwd.equals(lb.getPwd()))
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
	
	
	public ArrayList users()
	{
		Connection connection=getConnection();
		String qry="select Email from VinayKumar.logreg";
		
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		String result="";
		String []resArr;
		
		ArrayList al=new ArrayList();
		
		try 
		{
			preparedStatement=connection.prepareStatement(qry);
			rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
				//result=result+rs.getString("Email")+" ";
				al.add(rs.getString("Email"));
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return al;
				
	}
	
	
	
	public ArrayList details(String mail)
	{
		Connection connection=getConnection();
		
		String qry="select Name,Department,Email from VinayKumar.logreg where Email=?";
		
		ResultSet rs=null;
		
		ArrayList al=new ArrayList();
				
		
		try 
		{
			PreparedStatement preparedStatement=connection.prepareStatement(qry);
			preparedStatement.setString(1, mail);
			rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				al.add(rs.getString(1));
				al.add(rs.getString(2));
				al.add(rs.getString(3));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		
		return al;
		
	}
	
	
	
	
	public boolean delete(DelBean db)
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement = null;
		String qry="delete from VinayKumar.logreg where Email=? and password=?";
		
		int i=0;
		try
		{
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setString(1,db.getMail());
			preparedStatement.setString(2, db.getPwd());
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

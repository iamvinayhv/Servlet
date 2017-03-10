package com.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String uri=request.getRequestURI();
		
		if(uri.equals("/EmployeeApp/login"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String password=request.getParameter("pwd");
			
			if(id!=0&&password!="")
			{
				Pojo pojo=new Pojo();
				
				String name=pojo.login(id, password);
				
				if(name!=null)
				{
	 				HttpSession session=request.getSession(true);
					session.setAttribute("user", name);
					//session.invalidate();
					
					RequestDispatcher rd=request.getRequestDispatcher("Logcomplete.jsp");
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("loginerror.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("requiredFldsErr.jsp");
				rd.forward(request, response);
			}
		}
	
	}

}

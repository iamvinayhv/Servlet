package com.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginRegServlet
 */
public class LoginRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String uri=request.getRequestURI();
		
		if(uri.equals("/LogReg/login"))
		{
			String mail=request.getParameter("mail");
			String password=request.getParameter("pwd");
			
			if(mail!=""&&password!="")
			{
				DBOperation db=new DBOperation();
				
				boolean res=db.login(mail, password);
				if(res)
				{
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
				RequestDispatcher rd=request.getRequestDispatcher("requiredFlds.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
		
		if(uri.equals("/LogReg/register"))
		{
			
			String name=request.getParameter("name");
			String dept=request.getParameter("dept");
			String mail=request.getParameter("mail");
			String pwd=request.getParameter("pwd");
			String cpwd=request.getParameter("cpwd");
			
			if(name!="" && mail!=""&& dept!="")
			{
				if(pwd.equals(cpwd))
				{
					DBOperation db=new DBOperation();
					
					boolean isUpdate=db.register(name,dept,mail, pwd);
					{
						if(isUpdate)
						{
							RequestDispatcher rd=request.getRequestDispatcher("Regcomplete.jsp");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
							rd.forward(request, response);
						}
						
					}
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("noMatch.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("requiredFldsErr.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
		if(uri.equals("/LogReg/users"))
		{
			DBOperation db=new DBOperation();
			String users=db.users();
			
			
			HttpSession session=request.getSession(true);
			session.setAttribute("users", users);
			RequestDispatcher rd=request.getRequestDispatcher("users.jsp");
			rd.forward(request, response);
		}
		
		
		if(uri.equals("/LogReg/details"))
		{
			String mail=request.getParameter("mail");
			DBOperation db=new DBOperation();
			String details=db.details(mail);
			
			if(details!=null)
			{
				HttpSession session=request.getSession(true);
				session.setAttribute("details",details);
				RequestDispatcher rd=request.getRequestDispatcher("details.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("detailsErr.jsp");
				rd.forward(request, response);
			}
			
			
		}
		
		if(uri.equals("/LogReg/logout"))
		{
			HttpSession session=request.getSession(false);
			
			if(session!=null)
			{
				session.removeAttribute("users");
				session.removeAttribute("details");
				session.invalidate();
				
				RequestDispatcher rd=request.getRequestDispatcher("logout.jsp");
				rd.forward(request, response);
			}
			
		}
		
		
	}

}

package com.jsp;

import java.io.IOException;
import java.util.ArrayList;

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
			LoginBean rb=(LoginBean) request.getAttribute("login");
			String mail=rb.getMail();
			String password=rb.getPwd();
			
			if(mail!=""&&password!="")
			{
				DBOperation db=new DBOperation();
				
				boolean res=db.login(rb);
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
			RegBean rb=(RegBean)request.getAttribute("reg");
			
			String name=rb.getName();
			String dept=rb.getDept();
			String mail=rb.getMail();
			String pwd=rb.getPwd();
			String cpwd=rb.getCpwd();
			
			if(name!="" && mail!=""&& dept!="")
			{
				if(pwd.equals(cpwd))
				{
					DBOperation db=new DBOperation();
					
					boolean isUpdate=db.register(rb);
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
			ArrayList al=db.users();
			
			RequestDispatcher rd=request.getRequestDispatcher("users.jsp");
			request.setAttribute("users", al);
			rd.forward(request, response);
		}
		
		
		if(uri.equals("/LogReg/details"))
		{
			String mail=request.getParameter("mail");
			DBOperation db=new DBOperation();
			ArrayList details=db.details(mail);
			
			if(details!=null)
			{
				RequestDispatcher rd=request.getRequestDispatcher("details.jsp");
				request.setAttribute("details", details);
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
				RequestDispatcher rd=request.getRequestDispatcher("logout.jsp");
				rd.forward(request, response);
			}
			
		}
		
		
		
		if(uri.equals("/LogReg/delete"))
		{
			
			DelBean db=(DelBean) request.getAttribute("delete");
			String mail=db.getMail();
			String password=db.getPwd();
			
			DBOperation dbo=new DBOperation();
			boolean del=dbo.delete(db);
			
			if(del)
			{
				RequestDispatcher rd=request.getRequestDispatcher("deletecomplete.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("deleteerror.jsp");
				rd.forward(request, response);
			}
			
		}
		
		
	}

}

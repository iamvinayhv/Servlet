package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			System.out.println("inside doget of ps");
			
			RegBean rb=(RegBean) request.getAttribute("reg");
			System.out.println("inputs from bean"+rb.getUname()+""+rb.getEmail()+""+rb.getPwd()+""+rb.getPwd());
			
			
		}
	

}

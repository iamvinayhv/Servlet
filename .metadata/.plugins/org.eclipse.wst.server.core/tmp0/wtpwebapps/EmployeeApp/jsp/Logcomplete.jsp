<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body bgcolor=silver>

<%! String username=null; %>

<%
	HttpSession session2=request.getSession(false);
	username=(String)session2.getAttribute("user");
	
%>
<p style="color:blue;">WELCOME
<%=username%><br/>
</p>

<%-- <% response.sendRedirect("details.jsp");%> --%>

<% RequestDispatcher rd=request.getRequestDispatcher("details.jsp");
				rd.include(request, response);%>
				


</body>
</html>
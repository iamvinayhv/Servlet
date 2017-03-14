<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>

<%String arr=(String)session.getAttribute("users"); %>
<%

	String[]use=arr.split(" ");
	
	for(int i=0;i<use.length;i++)
	{%>
		
		<br/><%=use[i] %>
		
	<%}%>

<form action="details" method="post">

Enter id of the user for details:<input type="text" name="mail"><br/>
<input type="submit" value="details">

</form>

</body>
</html>
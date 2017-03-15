<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>
<%ArrayList al=(ArrayList)request.getAttribute("users"); %>


	
	
<%
	for(Object al1:al)
	{%>
		<br/><%=al1.toString() %>
	<%}%>



<form action="details" method="post">

Enter id of the user for details:<input type="text" name="mail"><br/>
<input type="submit" value="details">

</form>

</body>
</html>
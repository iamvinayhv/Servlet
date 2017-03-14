<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4 style="color:blue;">Details</h4>
<%String details=(String)session.getAttribute("details"); 

	String[]deta=details.split(" ");
	
	for(int i=0;i<deta.length;i++)
	{%>
		
		<br/><%=deta[i] %>
		
	<%}%><br/><br/><br/>


<form action="logout" method="post">

<input type="submit" value="logout">


</form>

</body>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LogOut</title>
</head>
<body>
<p>Please LogIn Again</p>
<% session.invalidate(); %>

<a href="login.jsp">
<input type="submit" value="LogIn"><br/></a>

<img alt="logo" src="login.jpg"><br/>

</body>
</html>
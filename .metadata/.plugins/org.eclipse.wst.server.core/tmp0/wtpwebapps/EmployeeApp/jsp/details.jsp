<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.jsp.Pojo" import="java.sql.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee details</title>
</head>
<body bgcolor="skyblue">
<p style="color=gold;">Your Details</p>
<%!ResultSet rs;
String res="";
%>
<%
	Pojo p=new Pojo();
	Connection connection=p.getConnection();
	String qry="select * from VinayKumar.employee where id=?";
	
	PreparedStatement preparedStatement=connection.prepareStatement(qry);
	
	int id=Integer.parseInt(request.getParameter("id"));
	
	preparedStatement.setInt(1, id);
	
	rs=preparedStatement.executeQuery();
	
	while(rs.next())
	{
		res=res+"Emp ID:"+rs.getString("id")+"</br>"+"Emp Name:"+rs.getString("Ename")+"</br>"+"Emp salary:"+rs.getString("Salary")+"</br>"+"Emp Depatment:"+rs.getString("dept");
	}

%>
<%=res %>

<a href="logout.jsp">
<input type="submit" value="Logout"><br/></a>

</body>
</html>
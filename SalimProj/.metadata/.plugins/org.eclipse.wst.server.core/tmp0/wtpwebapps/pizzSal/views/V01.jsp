<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>ok</h1>
	
	<% String s = (String)request.getAttribute("ref"); %>
	<%  String s2 = (String)request.getAttribute("Desig");%>
	<%Integer s3 = (Integer)request.getAttribute("pu");%>
		 
		<%= s %>
		<%= s2 %>
		<%= s3 %>
		
	
</body>
</html>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="models.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>List</h1>

	<table>
		<c:forEach var="s" items="${model}">
			<tr>
		      <td><c:out value="${s.ref}" /></td>
		      <td><c:out value="${s.desig}" /></td>
		      <td><c:out value="${s.pu}" /></td>
		   	</tr>
		</c:forEach>
	    
	</table>
</body>
</html>
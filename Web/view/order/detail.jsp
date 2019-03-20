<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/MVC/css/css.css">
</head>
<body>
			<p>Member ID: ${o.memberId}</p>
			<p>Email: ${o.email}</p>
			<p>Phone number: ${o.tel}</p>
			<p>Address: ${o.address }</p>
			<p>Status: ${o.statusName }</p>
<table class="table table-bordered">
	<c:forEach var="v" items="${o.details}">
		<tr>
			<td>${v.title}</td>
			<td>${v.price }</td>
			<td>${v.quantity }</td>
			<td>
			<img width="150" src="/MVC/upload/${v.imageUrl}">
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
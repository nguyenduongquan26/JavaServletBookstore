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
<div class="container">
<a href = "/MVC/home.html">Continue Shopping</a>
<form method="post" class="form">
	<p>
		<label>Email</label>
		<input type="email" name="email">
	</p>
	<p>
		<label>Phone number</label>
		<input type="number" name="tel">
	</p>
	<p>
		<label>Address</label>
		<input type="text" name="address">
	</p>
	<p>
		<button class = "btn btn-primary">Check Out</button>
	</p>
	</form>
	<table class="table table-bordered">
	<c:forEach var="o" items="${list}">
		<tr>
			<td>Title: ${o.title}</td>
			<td>Quantity: ${o.quantity}</td>
			<td>Price: ${o.price}</td>
			<td>
				<img width="150" src="/MVC/upload/${o.imageURL}">
		</tr>
	</c:forEach>
</table>
<p>${msg}
</p>
</div>
</body>
</html>
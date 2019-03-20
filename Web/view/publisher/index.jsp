<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>
<a href = "/MVC/PublisherAddController">ADD</a>
</p>
<form method="post">
	<table>
		<tr>
			<td><button>Delete</button></td>
			<td>Id</td>
			<td>Name</td>
			<td>Delete</td>
			<td>Detail</td>
			<td>Edit</td>
		</tr>
		<c:forEach var="o" items="${list}">
			<tr>
				<td>
					<input name="del" type="checkbox" value="${o.id}">
				</td>
				<td>${o.id}</td>
				<td>${o.name}</td>
				<td>
					<a href="/MVC/publisher/del.html?id=${o.id}">
						<img alt="Delete" src="/MVC/images/trash.png">
					</a>
				</td>
								<td>
					<a href="/MVC/publisher/del.html?id=${o.id}">
						<img alt="Detail" src="/MVC/images/detail.png">
					</a>
				</td>
								<td>
					<a href="/MVC/publisher/edit.html?id=${o.id}">
						<img alt="Edit" src="/MVC/images/edit.png">
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>
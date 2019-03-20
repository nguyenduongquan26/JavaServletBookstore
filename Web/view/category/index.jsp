<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/MVC/css/css.css">
</head>
<body>
<a href="/MVC/CategoryAddController">Add</a>
<p>
	<form method="post">
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Parent Name</th>
			</tr>
				<c:forEach var="o" items="${list}" >
					<tr>
						<td>${o.id }</td>
						<td>${o.name}</td>
						<td>${o.parentName}</td>
					</tr>
				</c:forEach>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/MVC/css/css.css">
</head>
<body>
<form method="post">
	<p>
		<label>Name</label>
	</p>
	<p>
		<input name="name" type="text">
	</p>
	<p>
		<label>Parent</label>
			<select name="parent">
				<c:forEach var="o" items="${parents}">
				 <option value="${o.id}">${o.name}</option>
				</c:forEach>
			</select>
		<frm:select name="parent" list="${parents }"/>
	</p>
	<p>
		<button>Save</button>
	</p>
</form>
</body>
</html>
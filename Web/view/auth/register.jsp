<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" type="text/css" href="/MVC/css/css.css">
</head>
<body>
<form method="post" class="form">
	<p>
		<label>User name</label>
		<input type="text" name="user">
	</p>
	<p>
		<label>Password</label>
		<input type="password" name="pass">
	</p>
	<p>
		<label>Email</label>
		<input type="email" name="email">
	</p>
	<p>
		<label>Gender</label>
		<select name="gender">
			<option value="1">Male</option>
			<option value="2">Female</option>
			<option value="0">Undefine</option>
		</select>
	</p>
	<p>
		<label>Full name</label>
		<input type="text" name="name">
	</p>
	<p>
		<button>Register</button>
	</p>
</form>
${msg }
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<input type="hidden" name="id" value="${o.id}">
		<p>
			<label>Name</label>
			<input type="text" name="name" value="${o.name}">
		</p>
		<p>
			<button>Save</button>
		</p>
	</form>
	<p>${msg}</p>
</body>
</html>
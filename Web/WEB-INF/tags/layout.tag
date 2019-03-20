<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name = "title" required="true"  %>
<%@attribute name="content" required="true" fragment="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="form" %>
<!DOCTYPE html>
<html>
<head>
	<title>${title}</title>
	<link rel="stylesheet" type="text/css" href="/MVC/css/css.css">
</head>
<body>
	<div class="nav">
			<div class="container">
				<div class="brand">Mini Shop</div>
			</div>
			<div class="clear"></div>
	</div>
	<div class="page">
		<div class= "container">
			<div class ="col-3">
				<form:menu list="${categories}"/>
			</div>
				<div class="col-9">
					<jsp:invoke fragment="content"/>
				</div>
		</div>
			<div class="clear"></div>
		</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tpl" uri="/WEB-INF/tpl"%>
<tpl:layout  title="Upload Simple">
	<jsp:attribute name="content">
		<form class = "form" method = "post" enctype="multipart/form-data">
			<p>
				<label>Select Image</label>
				<input type = "file" name="file">
			</p>
			<p>
				<button>Upload</button>
			</p>
		</form>
		<img width="200" src = "${pageContext.request.contextPath }/upload/${url}">
	</jsp:attribute>
</tpl:layout>
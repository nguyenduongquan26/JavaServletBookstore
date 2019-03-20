<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="form"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" enctype="multipart/form-data">
	<p>
		<label>Category</label>
		<form:select name="categoryId" list="${categories}"/>
	</p>
	<p>
		<label>Publisher</label>
		<form:select name="publisherId" list="${publisher}"/>
	</p>
	<p>
		<label>Author</label>
		<form:select name="authorId" list="${authors}"/>
	</p>
	<p>
		<label>ISBN</label>
		<input type="text" name="isbn">
	</p>
		<p>
		<label>Title</label>
		<input type="text" name="title">
	</p>
		<p>
		<label>Pages</label>
		<input type="number" name="pages">
	</p>
		<p>
		<label>Year</label>
		<input type="number" name="year">
	</p>
		<p>
		<label>Weight</label>
		<input type="text" name="weight">
	</p>
		<p>
		<label>Size</label>
		<input type="text" name="size">
	</p>
	<p>
		<label>Content</label>
		<textarea name="content"></textarea>
	</p>
		<p>
		<label>Description</label>
		<textarea name="description"></textarea>
	</p>
		<p>
		<label>Image</label>
		<input type="file" name="image">
	</p>
		<p>
		<label>price</label>
		<input type="number" name="price">
	</p>
	<p>
		<button>Save</button>
	</p>
	<p>
		${msg }
	</p>
</form>
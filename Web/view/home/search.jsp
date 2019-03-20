<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tpl" uri="/WEB-INF/tpl" %>
<tpl:layout title="Search">
	<jsp:attribute name="content">
	<div class="container">
	<form  class="form-search" action="/MVC/home/search.html">
	<input type="text" name="q" placeholder="Searching">
	<button>Search</button>
	</form>
		<c:forEach var="o" items="${list}">
		<div class="col-4">
			<div class="item">
				<img src="/MVC/upload/${o.imageURL}">
				<div class="info">
					<a href="/MVC/home/detail?id=${o.id }">
					${o.title}
					</a>
				</div>
			</div>
		</div>
	</c:forEach>
	</div>
	</jsp:attribute>
</tpl:layout>
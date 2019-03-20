<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tpl" uri="/WEB-INF/tpl" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<tpl:layout title="${o.title}">
	<jsp:attribute name="content">
	<jsp:include page="/view/home/formsearch.jsp"/>
	<div class="col-4">
		<img width="200" src="/MVC/upload/${o.imageURL}">
	</div>
	<div class="col-8">
		<h2>${o.title}</h2>
		<p><span>Price :${o.price} VND</span></p>
		<p><span>${o.description}</span></p>
		<p>
			<form method="post" action="/MVC/cart.html">
				<input name="id" type="hidden" value="${o.id }">
				<input name="quantity" type="number" value="1">
				<button class="btn btn-primary">Buy</button>
			</form>
		</p>
	</div>
	</jsp:attribute>
	
</tpl:layout>
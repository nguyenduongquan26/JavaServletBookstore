<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tpl" uri="/WEB-INF/tpl"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<tpl:layout title="${o.name}">
	<jsp:attribute name="content">
		<div class="page-heading">
			${o.name }
		</div>
		<jsp:include page="/view/home/products.jsp"/>
	</jsp:attribute>
</tpl:layout>
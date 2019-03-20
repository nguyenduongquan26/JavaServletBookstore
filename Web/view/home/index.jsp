<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tpl" uri="/WEB-INF/tpl"%>
<%@taglib prefix="form" uri="form" %>
	<tpl:layout title="Mini Shop">
		<jsp:attribute name="content">
			<jsp:include page="/view/home/formsearch.jsp"/>
				<p>Total : ${total}</p>
				<p>N : ${n }</p>
				<p>Welcome : ${user}</p>
				<form:pagination url="/MVC/home.html" n="${n}"/>
				<jsp:include page="/view/home/products.jsp"/>
				<%-- <div>
					<c:forEach var="o" items="${list}">
					<div class="col-3">
						<div class="item">
							<img src="${pageContext.request.contextPath}/upload/${o.imageURL}">
							<div class="info">
								<a href="/MVC/home/detail?id=${o.id }">
								${o.title}
								</a>
							</div>
						</div>
					</div>
				</c:forEach>
				</div> --%>
		</jsp:attribute>
	</tpl:layout>
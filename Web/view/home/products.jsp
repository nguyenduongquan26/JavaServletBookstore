<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<c:forEach var="o" items="${list }">
				<div class = col-3>
				<div class="items">
					
					<img src="${pageContext.request.contextPath}/upload/${o.imageURL}">
					
					<div class="info">
						<h2>
							<a href="${pageContext.request.contextPath }/home/detail?id=${o.id}">
							${o.title}
							</a>
						</h2>
					</div>
				</div>
				</div>
		</c:forEach>
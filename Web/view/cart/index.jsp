<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tpl" uri="/WEB-INF/tpl" %>


<a href="/MVC/home.html">Continue Shopping</a>
<tpl:layout  title="Cart">
	<jsp:attribute name="content">
		<table class="table table-bordered">
			<c:forEach var="o" items="${list}">
				<tr data-id="${o.productId}">
					<td>Title: ${o.title}</td>
					<td>Quantity:<input type="number" class="qty" value="${o.quantity }"> </td>
					<td>Price: ${o.price}</td>
					<td>
					<img width="150" src="/MVC/upload/${o.imageURL}">
				</tr>
			</c:forEach>
		</table>	
		<p class="center" >
		<a href="/MVC/cart/checkout.html" class="btn btn-primary">Check Out</a>
	</p>	
<script type="text/javascript">
var qtys = document.getElementsByClassName('qty');
for(var i = qtys.length - 1; i>=0;i++){
	qtys[i].onchange = function(){
		var qty = this.value;
		var id = this.parentNode.parentNode.getAttribute('data-id');
		//Ajax send
		var xhr = new XMLHttpRequest();
		xhr.open('POST','${pageContext.request.contextPath}/cart/edit.html');
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		var data = 'id=' + id +'&qty='+qty;
		xhr.send(data);
		xhr.onload = function(){
			if(xhr.response != '1'){
			alert("ERROR");
		}
		}
		
	}
	
}
</script>
	</jsp:attribute>
</tpl:layout>



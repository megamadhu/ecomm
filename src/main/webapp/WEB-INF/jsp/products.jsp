<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<title>Herbal Products</title>
<meta charset="UTF-8">
<meta name="herbalindia" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icon.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<style>
.w3-table td, .w3-table th{
  padding: 8px 8px 8px 150px;
}

</style>
<body>
<!-- Links (sit on top) -->
	<div class="w3-top">
		<div class="w3-row w3-large w3-light-grey">
			<div class="w3-col s3">
				<a href="${pageContext.request.contextPath}/" class="w3-button w3-block">Home</a>
			</div>
			<div class="w3-col s3">
				<a href="${pageContext.request.contextPath}/product" class="w3-button w3-block">Product Details</a>
			</div>
			<c:choose>
				<c:when test="${sessionScope.uname != null && sessionScope.uname != ''}">
					<div class="w3-col s3">
						<a href="${pageContext.request.contextPath}/editProfile" class="w3-button w3-block">Edit Profile</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="w3-col s3">
						<a href="${pageContext.request.contextPath}/signup" class="w3-button w3-block">Sign up</a>
					</div>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${sessionScope.uname != null && sessionScope.uname != ''}">
					<div class="w3-col s3">
						<a href="${pageContext.request.contextPath}/signout" class="w3-button w3-block">Sign Out</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="w3-col s3">
						<a href="${pageContext.request.contextPath}/signin" class="w3-button w3-block">Sign In</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<span style="position: absolute;right: 10%;font-weight: bold;">
		<c:if test="${sessionScope.uname != null && sessionScope.uname != ''}">
			Welcome ${sessionScope.uname}
		</c:if>
	</span>
<div class="w3-content" style="max-width: 1100px; margin-top: 80px; margin-bottom: 80px">
	<div class="w3-panel">
		<h1>
			<b>Herbal India <img src="${pageContext.request.contextPath}/images/herbal_india.png" style="width: 5%"></b>
		</h1>
		<div class="w3-pale-green"  style="height:2%; width:100%">${msg}</div>
		<div class="w3-pale-red"  style="height:2%; width:100%">${errMsg}</div>
	</div>
	<c:if test="${sessionScope.uname != null && sessionScope.uname != ''}">
	
		<form action="${pageContext.request.contextPath}/product/add" method="post">
		<div class="w3-row-padding" id="productsDiv">
			<div class="w3-center w3-padding-64">
				<h3>Product Details</h3>
			</div>
			<div class="w3-section" id="addProduct">
				<label>Product Name *</label> 
				<input class="w3-input w3-border w3-hover-border-black" style="width: 100%;" type="text" name="name" id="pname" required> 
				
				<label>Product Description</label> 
				<input class="w3-input w3-border w3-hover-border-black" style="width: 100%;" type="text" name="description" id="pdescription" required>

				<label>Price *</label> 
				<input class="w3-input w3-border w3-hover-border-black" pattern="\d+(\.\d{1,2})?" style="width: 100%;" type="text" name="price" id="pprice" required>

			</div>
			<button type="submit" class="w3-button w3-block w3-black" id="add">Submit</button>
		</div>
		</form>
	</c:if>
	
		<!-- Grid -->
		<div class="w3-row-padding" id="products">

			<div class="w3-center w3-padding-64">
				<h3>Product List</h3>
			</div>
			
				<div class="w3-section" style="width: 100%">
		    	  <form action="${pageContext.request.contextPath}/product/delete" method="post">
					<table id="productList" class="w3-table w3-table-all">
						<thead>
							<th>Product Name</th>
							<th>Description</th>
							<th>Price</th>
							<c:if test="${sessionScope.uname != null && sessionScope.uname != ''}">
							<th>Action</th>
							</c:if>
						</thead>
						<tbody>	
							<c:forEach var="prod" items="${allProduct}">
							    <tr>
							    	<td>${prod.name}</td>
							    	<td>${prod.description}</td>
							    	<td>${prod.price}</td>
							    	<c:if test="${sessionScope.uname != null && sessionScope.uname != ''}">
							    	<td>
							    	  <button type="button" onclick="populateProduct('${prod.name}','${prod.description}','${prod.price}')"><img alt="Edit" src="${pageContext.request.contextPath}/images/edit.png"/></button>
							    	  <input type="hidden" name="productId" value="${prod.id}"/>
							    	  <button type="submit"><img alt="Delete" src="${pageContext.request.contextPath}/images/delete.png"/></button>
							    	  
							    	</td>
							    	</c:if>
							    </tr>
							</c:forEach>
						</tbody>
					</table>
				 </form>
	
				</div>
		</div>
	</div>
	<script>
	function populateProduct(name, description, price){
		$("#pname").val(name);
		$("#pdescription").val(description);
		$("#pprice").val(price);
	}
		
	</script>
</body>
</html>

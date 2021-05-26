<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Sign Up</title>
<meta name="herbalindia" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icon.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
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
	<c:choose>
		<c:when test="${sessionScope.uname != null && sessionScope.uname != ''}">
			<form action="${pageContext.request.contextPath}/editProfile" method="post" >
		</c:when>
		<c:otherwise>
			<form action="${pageContext.request.contextPath}/signup" method="post" >
		</c:otherwise>
	</c:choose>
		<div class="w3-row-padding" id="productsDiv">
			<div class="w3-center w3-padding-64">
				<c:choose>
					<c:when test="${sessionScope.uname != null && sessionScope.uname != ''}">
						<h3>Edit Profile</h3>
					</c:when>
					<c:otherwise>
						<h3>Sign Up</h3>
					</c:otherwise>
				</c:choose>
					
			</div>
		    <div class="w3-section">
		      <label>Name*</label>
		      <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="name" required value="<c:out value='${signupDB.name}'/>">
		    </div>
		    <div class="w3-section">
		    <label>User Name*</label>
		    <c:choose>
				<c:when test="${sessionScope.uname != null && sessionScope.uname != ''}">
					<input readonly class="w3-input w3-border w3-hover-border-black" style="width:100%;" name="uname" required value="${signupDB.signupKey.username}" minlength="5" maxlength="8">
				</c:when>
				<c:otherwise>
					<input class="w3-input w3-border w3-hover-border-black" style="width:100%;" name="uname" required minlength="5" maxlength="8">
				</c:otherwise>
			</c:choose>
		    </div>
		    <div class="w3-section">
		      <label>Password*</label>
		      <input type="password" class="w3-input w3-border w3-hover-border-black" style="width:100%;" name="pass" required value="${signupDB.signupKey.password}" pattern=".{5,}" title="Five or more characters">
		    </div>
		    <div class="w3-section">
		      <label>Email*</label>
		      <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="email" required value="${signupDB.email}" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
		    </div>
	    	<button type="submit" class="w3-button w3-block w3-black">Submit</button>
	    </div>
	 </form>
	</div>
</body>
</html>
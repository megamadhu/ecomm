<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<meta name="herbalindia" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">

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
		</div>
		
		<div class="w3-panel">
			<h1>
				<c:choose>
					<c:when test="${errType == '404'}">
						<div class="w3-col s3" style="width:100%">
							<b>404 Page Not Found!</b>
						</div>
					</c:when>
					<c:otherwise>
						<div class="w3-col s3" style="width:100%">
							<b>Please Contact System Administrator</b>
						</div>
					</c:otherwise>
				</c:choose>
				<label>Email at: helpdesk@herbalindia.com</label>
			</h1>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
<meta name="herbalindia" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icon.css">
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
			<div class="w3-col s3">
				<a href="${pageContext.request.contextPath}/signup" class="w3-button w3-block">Sign up</a>
			</div>
			<div class="w3-col s3">
				<a href="${pageContext.request.contextPath}/signin" class="w3-button w3-block">Sign in</a>
			</div>
		</div>
	</div>
<div class="w3-content" style="max-width: 1100px; margin-top: 80px; margin-bottom: 80px">
	<div class="w3-panel">
		<h1>
			<b>Herbal India <img src="${pageContext.request.contextPath}/images/herbal_india.png" style="width: 5%"></b>
		</h1>
		<div class="w3-pale-green"  style="height:2%; width:100%">${msg}</div>
		<div class="w3-pale-red"  style="height:2%; width:100%">${errMsg}</div>
	</div>
	
	<form action="${pageContext.request.contextPath}/signin" method="post" >
		<div class="w3-row-padding" id="productsDiv">
			<div class="w3-center w3-padding-64">
					<h3>Sign In</h3>
				</div>
		    <div class="w3-section">
		      <label>User Name*</label>
		      <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" name="uname" required>
		    </div>
		    <div class="w3-section">
		      <label>Password*</label>
		      <input type="password" class="w3-input w3-border w3-hover-border-black" style="width:100%;" name="pass" required>
		    </div>
	    	<button type="submit" class="w3-button w3-block w3-black">Sign In</button>
	    </div>
	 </form>
</div>
</body>
</html>
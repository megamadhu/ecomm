<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<title>Herbal India</title>
<meta charset="UTF-8">
<meta name="herbalindia" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/font.css">
<script src="js/jquery.min.js"></script>
<style>
html, body, h1, h2, h3, h4 {
	font-family: "Lato", sans-serif
}

.mySlides {
	display: none
}

.w3-tag, .fa {
	cursor: pointer
}

.w3-tag {
	height: 15px;
	width: 15px;
	padding: 0;
	margin-top: 6px
}
</style>
<body>

	<!-- Links (sit on top) -->
	<div class="w3-top">
		<div class="w3-row w3-large w3-light-grey">
			<div class="w3-col s3">
				<a href="#" class="w3-button w3-block">Home</a>
			</div>
			<div class="w3-col s3">
				<a href="/product/" class="w3-button w3-block">Product Details</a>
			</div>
			<div class="w3-col s3">
				<a href="/product/signup" class="w3-button w3-block">Sign up</a>
			</div>
			<div class="w3-col s3">
				<a href="/product/signin" class="w3-button w3-block">Sign in</a>
			</div>
		</div>
	</div>

	<!-- Home -->
	<div class="w3-content" style="max-width: 1100px; margin-top: 80px; margin-bottom: 80px">

		<div class="w3-panel">
			<h1>
				<b>Herbal India <img src="/images/herbal_india.png" style="width: 5%"></b>
			</h1>
		</div>
		
		<!-- Slideshow -->
		<div class="w3-container">
			<div id="homeDiv">
			<div class="w3-display-container mySlides">
				<img src="/images/herbal_herbs.jpg" style="width: 100%">
				<div class="w3-display-topright w3-container w3-padding-32">
					<span class="w3-white w3-padding-large w3-animate-bottom">Herbal Herbs</span>
				</div>
			</div>
			<div class="w3-display-container mySlides">
				<img src="/images/herbal_ingred.jpg" style="width: 100%">
				<div class="w3-display-topright w3-container w3-padding-32">
					<span class="w3-white w3-padding-large w3-animate-bottom">Herbal Ingredients</span>
				</div>
			</div>
			<div class="w3-display-container mySlides">
				<img src="/images/herbal_product.jpg" style="width: 100%">
				<div class="w3-display-topright w3-container w3-padding-32">
					<span class="w3-white w3-padding-large w3-animate-bottom">Herbal Product</span>
				</div>
			</div>

			<!-- Slideshow next/previous buttons -->
			<div class="w3-container w3-dark-grey w3-padding w3-xlarge">
				<div class="w3-left" onclick="plusDivs(-1)">
					<i class="fa fa-arrow-circle-left w3-hover-text-teal"></i>
				</div>
				<div class="w3-right" onclick="plusDivs(1)">
					<i class="fa fa-arrow-circle-right w3-hover-text-teal"></i>
				</div>

				<div class="w3-center">
					<span class="w3-tag demodots w3-border w3-transparent w3-hover-white" onclick="currentDiv(1)"></span> 
					<span class="w3-tag demodots w3-border w3-transparent w3-hover-white" onclick="currentDiv(2)"></span> 
					<span class="w3-tag demodots w3-border w3-transparent w3-hover-white" onclick="currentDiv(3)"></span>
				</div>
			</div>
		</div>
		</div>
		
	</div>


	<!-- Contact -->

	<footer class="w3-container w3-padding-32 w3-light-grey w3-center">
		<div class="w3-center w3-padding-64" id="contact">
			<span
				class="w3-xlarge w3-bottombar w3-border-dark-grey w3-padding-16">Contact
				Us</span>
		</div>
		<a href="#" class="w3-button w3-black w3-margin"><i
			class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
		<div class="w3-xlarge w3-section">

			<div class="w3-section">
				<label>Call at:9999999999</label>
			</div>
			<div class="w3-section">
				<label>Email at: mortar.medical@gmail.com</label>
			</div>
			<div class="w3-section">
				<label>Available from 9 AM to 6PM</label>
			</div>
		</div>
	</footer>


	<script>
		// Slideshow
		var slideIndex = 1;
		showDivs(slideIndex);

		function plusDivs(n) {
			showDivs(slideIndex += n);
		}

		function currentDiv(n) {
			showDivs(slideIndex = n);
		}

		function showDivs(n) {
			var i;
			var x = document.getElementsByClassName("mySlides");
			var dots = document.getElementsByClassName("demodots");
			if (n > x.length) {
				slideIndex = 1
			}
			if (n < 1) {
				slideIndex = x.length
			}
			;
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" w3-white", "");
			}
			x[slideIndex - 1].style.display = "block";
			dots[slideIndex - 1].className += " w3-white";
		}

		
	</script>

</body>
</html>

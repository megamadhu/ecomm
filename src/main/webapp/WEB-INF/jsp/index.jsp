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
html,body,h1,h2,h3,h4 {font-family:"Lato", sans-serif}
.mySlides {display:none}
.w3-tag, .fa {cursor:pointer}
.w3-tag {height:15px;width:15px;padding:0;margin-top:6px}
</style>
<body>

<!-- Links (sit on top) -->
<div class="w3-top">
  <div class="w3-row w3-large w3-light-grey">
    <div class="w3-col s3">
      <a href="#" class="w3-button w3-block">Home</a>
    </div>
    <div class="w3-col s3">
      <a href="#products" class="w3-button w3-block">Product Details</a>
    </div>
    <div class="w3-col s3">
      <a href="/Register.jsp" class="w3-button w3-block">Sign up</a>
    </div>
    <div class="w3-col s3">
      <a href="/login.jsp" class="w3-button w3-block">Sign in</a>
    </div>
  </div>
</div>

<!-- Home -->
<div class="w3-content" style="max-width:1100px;margin-top:80px;margin-bottom:80px">

  <div class="w3-panel">
    <h1><b>Herbal India <img src="/images/herbal_india.png" style="width:5%"></b></h1>
  </div>

  <!-- Slideshow -->
  <div class="w3-container">
    <div class="w3-display-container mySlides">
      <img src="/images/herbal_herbs.jpg" style="width:40%">
      <div class="w3-display-topright w3-container w3-padding-32">
        <span class="w3-white w3-padding-large w3-animate-bottom">Herbal Herbs</span>
      </div>
    </div>
    <div class="w3-display-container mySlides">
      <img src="/images/herbal_ingred.jpg" style="width:40%">
      <div class="w3-display-topright w3-container w3-padding-32">
        <span class="w3-white w3-padding-large w3-animate-bottom">Herbal Ingredients</span>
      </div>
    </div>
    <div class="w3-display-container mySlides">
      <img src="/images/herbal_product.jpg" style="width:30%">
      <div class="w3-display-topright w3-container w3-padding-32">
        <span class="w3-white w3-padding-large w3-animate-bottom">Herbal Product</span>
      </div>
    </div>

    <!-- Slideshow next/previous buttons -->
    <div class="w3-container w3-dark-grey w3-padding w3-xlarge">
      <div class="w3-left" onclick="plusDivs(-1)"><i class="fa fa-arrow-circle-left w3-hover-text-teal"></i></div>
      <div class="w3-right" onclick="plusDivs(1)"><i class="fa fa-arrow-circle-right w3-hover-text-teal"></i></div>
    
      <div class="w3-center">
        <span class="w3-tag demodots w3-border w3-transparent w3-hover-white" onclick="currentDiv(1)"></span>
        <span class="w3-tag demodots w3-border w3-transparent w3-hover-white" onclick="currentDiv(2)"></span>
        <span class="w3-tag demodots w3-border w3-transparent w3-hover-white" onclick="currentDiv(3)"></span>
      </div>
    </div>
  </div>
  
 
  <!-- Grid -->
  <div class="w3-row-padding" id="products" style="height:800px;">
    <div class="w3-center w3-padding-64">
      <h3>Product Details</h3>
    </div>
    <form class="w3-container" action="/product/add" target="_blank">
      <div class="w3-section" id="addProduct">
        <label>Product Name *</label>
        <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" id="pname" required>
        
        <label>Product Description</label>
        <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" id="pdescription" required>
        
        <label>Price *</label>
        <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" id="pprice" required>
        
      </div>
        <button type="button" class="w3-button w3-block w3-black" id="add">Add</button>
    </form>
  </div>

  <!-- Grid -->
  <div class="w3-row-padding" id="signup">
    <div class="w3-center w3-padding-64">
      <span class="w3-xlarge w3-bottombar w3-border-dark-grey w3-padding-16">Sign up</span>
      <span class=".w3-text-red,.w3-hover-text-red:hover" id="message"></span>
    </div>

    <form class="w3-container" action="" target="_blank">
    <div class="w3-section">
      <label>Name *</label>
      <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="name" required>
    </div>
    <div class="w3-section">
      <label>Username *</label>
      <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" name="username" required>
    </div>
    <div class="w3-section">
      <label>Password *</label>
      <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" name="password" required>
    </div>
    <div class="w3-section">
      <label>Email *</label>
      <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="email" required>
    </div>
    
    
    <button type="submit" class="w3-button w3-block w3-black">Sign Up</button>
  </form>
  </div>
  
  <div class="w3-row-padding" id="signin">
    <div class="w3-center w3-padding-64">
      <span class="w3-xlarge w3-bottombar w3-border-dark-grey w3-padding-16">Sign in</span>
    </div>

    <form class="w3-container" action="" target="_blank">
    <div class="w3-section">
      <label>Username *</label>
      <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="username" required>
    </div>
    <div class="w3-section">
      <label>Password *</label>
      <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="password" required>
    </div>
  
    <button type="submit" class="w3-button w3-block w3-black">Sign in</button>
  </form>
  </div>

 
  

</div>

<!-- Contact -->

<footer class="w3-container w3-padding-32 w3-light-grey w3-center">
   <div class="w3-center w3-padding-64" id="contact">
    <span class="w3-xlarge w3-bottombar w3-border-dark-grey w3-padding-16">Contact Us</span>
  </div>
  <a href="#" class="w3-button w3-black w3-margin"><i class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
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
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a></p>
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
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length} ;
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" w3-white", "");
  }
  x[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " w3-white";
}


$(document).ready(function(){
  $("#add").click(function(){
	$.post("/product/add",
	  {
	    name: $("#pname").val(),
	    description: $("#pdescription").val(),
	    price: $("#price").val()
	  },
	function(data, status){
	     $("#message").html(data);
	});
 
});
});


</script>

</body>
</html>

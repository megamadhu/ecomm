<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<title>Herbal Products</title>
<meta charset="UTF-8">
<meta name="herbalindia" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/w3.css">
<link rel="stylesheet" href="/css/font.css">
<link rel="stylesheet" href="/css/font.css">
<link rel="stylesheet" href="/css/icon.css">
<script src="/js/jquery.min.js"></script>
<body>
<div class="w3-content" style="max-width: 1100px; margin-top: 80px; margin-bottom: 80px">

	<div class="w3-panel">
		<h1>
			<b>Herbal India <img src="/images/herbal_india.png" style="width: 5%"></b>
		</h1>
		<div class="w3-pale-green"  style="height:2%; width:100%">${msg}</div>
		<div class="w3-pale-red"  style="height:2%; width:100%">${errMsg}</div>
	</div>
	<form action="/product/add" method="post">
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
			<button type="submit" class="w3-button w3-block w3-black" id="add">Add</button>
		</div>
	</form>
	
		<!-- Grid -->
		<div class="w3-row-padding" id="products">

			<div class="w3-center w3-padding-64">
				<h3>Product List</h3>
			</div>
			
				<div class="w3-section" style="width: 100%">
					<table id="productList" class="w3-table w3-table-all">
						<thead>
							<th>Product Name</th>
							<th>Description</th>
							<th>Price</th>
							<th>Action</th>
						</thead>
						<tbody>	
							<c:forEach var="prod" items="${allProduct}">
							    <tr>
							    	<td>${prod.name}</td>
							    	<td>${prod.description}</td>
							    	<td>${prod.price}</td>
							    	<td>
							    	  <a href="/product/delete?id=${prod.id}"><button type="button"><img alt="Delete" src="/images/delete.png"/></button></a>
							    	  <button type="button" onclick="populateProduct('${prod.name}','${prod.description}','${prod.price}')"><img alt="Edit" src="/images/edit.png"/></button>
							    	</td>
							    </tr>
							</c:forEach>
						</tbody>
					</table>
	
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

<%@ 
	page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.generation.webshop.model.entities.*,java.util.List"
    
%>
<!-- pagina principale -->
<%
	Customer user = (Customer) request.getAttribute("loggedin");
%>
<html>
	<head>
		<title> Web Shop </title>
		<!-- sto scaricando una libreria -->
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<style>
			.rientrostandard
			{
				padding-left:10px;
			}
			
			.product
			{
				margin-top:10px;
				margin-bottom:10px;
				padding-left:10px;
			}
			
			.description
			{
				padding:5px;
				color:black;
				font-weight:bold;
				height:200px;
			}
			
		</style>
	</head>
	<body>
		<div class="w3-card-4 w3-indigo rientrostandard">
			<h1> Web Shop </h1>
			<h4> 
					Logged in as: <%=user.getName()+" "+user.getSurname() %>
			</h4>
		</div>
		<div id="menu" class="w3-container">
			<%
			if(user.getLevel()==0)
			{
			%>
			<a href="Index?cmd=formlogin"  style="float:right;margin-right:10px" class="w3-btn w3-indigo">Login</a>
			<%					
			}
			if(user.getLevel()==2)
			{
			%>
			<a href="Index?cmd=formnewproduct"  style="float:right;margin-right:10px" class="w3-btn w3-indigo">New Product</a>
			<%
			}
			%>			
		</div>
		<div class="w3-half">
			<form method="post" action="Index">
				<input type="hidden" name="cmd" value="newproduct" />
				Name
				<input type="text" name="name" class="w3-input" />
				Description
				<input type="text" name="description" class="w3-input" />
				Category
				<input type="text" name="category" class="w3-input" />
				Price
				<input type="number" name="price" class="w3-input" />
				Quantity
				<input type="number" name="quantity" class="w3-input" />
				
				<input type="submit" value="send" class="w3-input w3-indigo" />
			
			</form>
		</div>			
		
	</body>
</html>
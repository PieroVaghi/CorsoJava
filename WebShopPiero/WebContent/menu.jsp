<%@ 
	page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.generation.webshop.model.entities.*"
    
%>
<!--  menù, verrà incluso in tutte le altre pagine  -->
<%
	Customer user = (Customer) request.getAttribute("user");
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
				padding:20px;
				
			}
			
			.product B
			{
				font-size:16px;
			}
			
			.product IMG
			{
				display:block;
				padding:10px;
				width:200px;
				height:200px;
			}
			
			
			a
			{
				text-decoration:none;
			}
			
		</style>
	</head>
	<body>
		<div class="w3-card-4 w3-indigo rientrostandard">
			<h1> <a href="Index">Web Shop</a></h1>
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
			if(user.getLevel()>0)
			{
			%>
			<a href="Index?cmd=logout"  style="float:right;margin-right:10px" class="w3-btn w3-indigo">Logout</a>
			<%					
			}
			if(user.getLevel()==2)
			{
			%>
			<a href="Index?cmd=formnewproduct"  style="float:right;margin-right:10px" class="w3-btn w3-indigo">New Product</a>
			<a href="Index?cmd=formnewcustomer"  style="float:right;margin-right:10px" class="w3-btn w3-indigo">New Customer</a>
			<%
			}
			%>			
		</div>

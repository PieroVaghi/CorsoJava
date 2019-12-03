<%@ 
	page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
%>
<%
	String errorMessage = (String) request.getAttribute("errorMessage");
	if(errorMessage==null) errorMessage = "";
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
		</div>
		<div class="w3-half" style="padding-left:20px">
			<!--  post redirige a get nella nostra servlet -->
			<h1> Form Login </h1>
			<form action="Index" method="post">
				Email
				<input type="text" name="email" class="w3-input" />
				Password
				<input type="password" name="password" class="w3-input" />
				<input type="hidden"  name="cmd" value="login" />
				<input type="submit" value="send" class="w3-btn w3-indigo w3-input" />
			</form>
			<%=errorMessage %>
			
		</div>			
		
	</body>
</html>
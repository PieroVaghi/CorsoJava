<%@ 
	page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.generation.webshop.model.entities.*,java.util.List"
    
%>
<!-- pagina principale -->
<%
	List<Product> products = (List<Product>) request.getAttribute("products");
	// Questo dato arriva dalla servlet, che lo ha preso dalla session
	// oppure mi ha dato guest
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
			<%
			}
			%>			
		</div>
		<%
		for(Product p:products)
		{
		%>
		<div class="product w3-third">
			<b> <%=p.getName()%> </b> <br />
			<%=p.getCategory() %> <br />
			<div class="description">
				<%=p.getDescription()%>
			</div>
			<div class="numbers">
				<%=p.getQuantity() %> pcs - <%=p.getPrice() %> &euro;
			</div>
			<a href="Index?cmd=productdetail&productid=<%=p.getId() %>" class="w3-btn w3-indigo">Detail</a>
			<% if(user.getLevel() == 2)
					{ %>
					<a href="Index?cmd=deleteproduct&productid=<%=p.getId() %>" class="w3-btn w3-indigo">Remove</a>
					<% 
					}
			%>
		</div>
		<%
		}
		%>	
			
		
	</body>
</html>
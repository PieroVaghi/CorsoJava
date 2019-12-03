<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="com.generation.webshop.model.entities.*"    
%>
<%
	Product p = (Product) request.getAttribute("product");
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
			
			#detail
			{
				padding-left:20px;
				padding-right:20px;
				text-align:justify;
			}
			
			#newreview
			{
				padding-left:20px;
				padding-right:20px;
			}
			
			#reviews
			{
			}
			
			
			
		</style>
	</head>
	<body>
		<div class="w3-card-4 w3-indigo rientrostandard">
			<h1> Product <%=p.getId()%> - <%=p.getName()%> </h1>
			<h4> 
					Logged in as: <%=user.getName()+" "+user.getSurname() %>
			</h4>
		</div>
		<div class="w3-half" id="detail">
			<h2> Detail for product <%=p.getName() %></h2>
			<%=p.getDescription()%>
			<br /><br />
			<%=p.getQuantity()%> pcs - <%=p.getPrice() %> &euro; 
			<br />
			<br />
			<a href="Index?cmd=" class="w3-btn w3-indigo">Back</a>
		</div>
		<div class="w3-quarter" id="newreview">
			<h2> New Review </h2>
			<form method="get" action="Index">
				Titolo
				<input type="text" name="title" class="w3-input"/>
				Content
				<input type="text" name="content" class="w3-input" />
				Stars
				<input type="number" name="stars" class="w3-input" />
				<input type="hidden" name="cmd" value="savereview" />
				<input type="hidden" name="customerid" value="<%=user.getId() %>">
				<input type="hidden" name="productid" value="<%=p.getId() %>">
				<input type="submit" value="save" class="w3-btn w3-indigo" />
			</form>
		</div>
		<div class="w3-quarter" id="reviews">
			<h2> Reviews </h2>
			<%
			
			System.out.println(p.getReviews());
			for(Review r:p.getReviews())
				{	
				%>
				<div class="review">
					<%=r.getTitle()%> - <%=r.getStars()%>/5
					<% if(user.getId() == r.getCustomer().getId())
					{ %>
					<a href="Index?cmd=deletereview&reviewid=<%=r.getId() %>&productid=<%=p.getId() %>" class="w3-btn w3-indigo">Remove</a>
					<% 
					}
					%>
				</div>		
				<%
				}
				%>
		</div>
		
	</body>
</html>
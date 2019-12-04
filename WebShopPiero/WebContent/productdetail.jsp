<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="com.generation.webshop.model.entities.*, java.util.List"    
%>
<%
	Product 		p 		= (Product) request.getAttribute("product");
	List<Product>	similar = (List<Product>) request.getAttribute("similar");
	Customer user = (Customer) request.getAttribute("user");
%>
		<style>
			#detail, #reviews, #similar
			{
				padding:20px;
				text-align:justify;
			}
			
			
		</style>

		<jsp:include page="menu.jsp" />

		<div class="w3-card-4 w3-indigo rientrostandard">
			<h1> Product <%=p.getId()%> - <%=p.getName()%> </h1>
		</div>
		<div class="w3-third" id="detail">
			<h2> <%=p.getName() %></h2>
			<%=p.getDescription()%>
			<br /><br />
			<center>
				<img style="width:300px;height:300px" src="<%=p.getImage() %>" />
				<br /> <br />
				<%=p.getQuantity()%> pcs - <%=p.getPrice() %> &euro; 
				<a href="Index?cmd=" class="w3-btn w3-indigo">Back</a>
			</center>
			
		</div>
		<div class="w3-third" id="reviews">
			<h2> New Review </h2>
			<form method="post" action="Index">
				Titolo
				<input type="text" name="title" class="w3-input"/>
				Content
				<input type="text" name="content" class="w3-input" />
				Stars
				<input type="number" name="stars" class="w3-input" />
				<input type="hidden" name="cmd" value="savereview" />
				<input type="hidden" name="productid" value="<%= p.getId()%>">
				<input type="submit" value="save" class="w3-btn w3-indigo" />
			</form>
			<h2> Reviews </h2>
			<%
			for(Review r:p.getReviews())
			{	
			%>
			<div class="review">
				<%=r.getTitle() %> - <%=r.getStars() %>/5
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
		<div class="w3-third" id="similar">
			<h2> See Also </h2>
		</div>
		
	</body>
</html>
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
		<jsp:include page="menu.jsp" />
		<div class="w3-half" style="padding-left:10px">
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
				Image
				<input type="text" name="image" class="w3-input" />
				<br />
				<input type="submit" value="send" class="w3-input w3-indigo" />
			</form>
		</div>			
		
	</body>
</html>
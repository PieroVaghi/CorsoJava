<%@ 
	page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.generation.webshop.model.entities.*, java.util.List"
%>
<!--  includo il menù  -->
<%
	List<Product> products = (List<Product>) request.getAttribute("products");
	Customer user = (Customer) request.getAttribute("user");
%>
<jsp:include page="menu.jsp" />
<style>

</style>
<%
	for(Product p:products)
	{
		%>
		<div class="product w3-quarter">
			<div class="w3-half" style="background-color:#CCC;padding:10px;height:240px;text-align:justify;overflow:hide">
				<b> <%=p.getName()%> </b> <br />
				<%=p.getCategory() %> <br />
				<div style="min-height:120px">
					<%=p.getShortDescription() %>
				</div>
				<div class="numbers">
					<%=p.getQuantity() %> pcs - <%=p.getPrice() %> &euro;
				</div>
			</div>
			<div class="w3-half">
				<center>
					<img src="<%=p.getImage() %>" />
					<a href="Index?cmd=productdetail&productid=<%=p.getId() %>" class="w3-btn w3-indigo">detail</a>
					<%					
					if(user.getLevel()==2)
					{
					%>
					<a href="Index?cmd=deleteproduct&productid=<%=p.getId() %>"  class="w3-btn w3-indigo">delete</a>
					<%
					}
					%>	
				</center>
			</div>
		</div>
		<%
		}
	%>	
	</body>
</html>
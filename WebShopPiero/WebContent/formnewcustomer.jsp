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
				<input type="hidden" name="cmd" value="newcustomer" />
				Name
				<input type="text" name="name" class="w3-input" />
				Surname
				<input type="text" name="surname" class="w3-input" />
				Email
				<input type="email" name="email" class="w3-input" />
				Password
				<input type="password" name="password" class="w3-input" />
				Reinsert Password
				<input type="password" name="checkpassword" class="w3-input" />
				<br />
				<input type="submit" value="send" class="w3-input w3-indigo" />
			</form>
		</div>			
		
	</body>
</html>
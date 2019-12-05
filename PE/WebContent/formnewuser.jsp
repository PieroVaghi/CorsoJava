<%@ 
	page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.generation.pe.model.entities.*,java.util.List"
    
%>
<!-- pagina principale -->
<%
	User user = (User) request.getAttribute("loggedin");
%>
		<jsp:include page="menu.jsp" />
		<div class="w3-half" style="padding-left:10px">
			<form method="post" action="Index">
				<input type="hidden" name="cmd" value="newuser" />
				Name
				<input type="text" name="name" class="w3-input" />
				Surname
				<input type="text" name="surname" class="w3-input" />
				Email
				<input type="email" name="email" class="w3-input" />
				Password
				<input type="password" name="password" class="w3-input" />
				Date Of Birth (dd/mm/yyyy)
				<input type="text" name="dob" class="w3-input" />
				City
				<input type="text" name="city" class="w3-input" />
				Address
				<input type="text" name="address" class="w3-input" />
				Yearly
				<input type="number" name="yearly" class="w3-input" />
				Level (1 -> Freelance / 2 -> Employee)
				<input type="number" name="level" class="w3-input" />
				Gemder (M/F)
				<input type="text" name="gender" class="w3-input" />
				<br />
				<input type="submit" value="send" class="w3-input w3-indigo" />
			</form>
		</div>			
		
	</body>
</html>
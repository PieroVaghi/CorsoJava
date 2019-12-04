<%@ 
	page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
%>
<%
	String errorMessage = (String) request.getAttribute("errorMessage");
	if(errorMessage==null) errorMessage = "";
%>
	<jsp:include page="menu.jsp" />
		<div class="w3-half" style="padding-left:20px">
			<!--  post redirige a get nella nostra servlet -->
			<h1> Form Login </h1>
			<form action="Index" method="post">
				Email
				<input type="text" name="email" class="w3-input" />
				Password
				<input type="password" name="password" class="w3-input" />
				<input type="hidden"  name="cmd" value="login" />
				<br />
				<input type="submit" value="send" class="w3-btn w3-indigo w3-input" />
			</form>
			<%=errorMessage %>
			
		</div>			
	</body>
</html>
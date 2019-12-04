<%@ 
	page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<!-- pagina principale -->
<%
	String error = (String) request.getAttribute("error");
%>
	<jsp:include page="menu.jsp" />
	<style>
		.error
		{
			text-align:center;
			color:red;
			font-size:30px;
		}
	</style>
	<div class="error">
		<a href="Index"><%= error %> <br /> Go back</a>
	</div>	
	</body>
</html>
<%@ 
	page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.generation.pe.model.entities.*, java.util.List"
%>
<!--  includo il menù  -->
<%
	List<User> users = (List<User>) request.getAttribute("users");
	User user = (User) request.getAttribute("user");
%>
<jsp:include page="menu.jsp" />
<style>
	.user div
			{
				padding-left:5px;
				padding-right:5px;
			}
</style>
<%
	for(User u:users)
	{
		if(u.getLevel()!=2){
		%>
		<div class="user" style="width:70%;">
			<div class="w3-half" >
				<div class="w3-card-4 w3-indigo rientrostandard">
					<h1> <%=u.getName()%> <%=u.getSurname()%> </h1>
				</div>
				<div class="w3-third" id="detailuser" style="width:25%">
					<br />
					<b> DoB: </b> <%=u.getDob().toLocaleString().substring(0,11) %><br />
					<b> Address: </b> <%=u.getCity() %> - <%=u.getAddress() %>
					<b>Yearly: </b> <%=u.getYearly() %> &euro; 
					<a href="Index?cmd=ownprofile&iduser=<%=u.getId() %>"  class="w3-btn w3-indigo">detail</a>
				</div>
			</div>
					
		</div>
		<%
		}
		}
	%>	
	</body>
</html>
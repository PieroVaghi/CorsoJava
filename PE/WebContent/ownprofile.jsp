<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="com.generation.pe.model.entities.*, java.util.List"    
%>
<%
		User u = (User) request.getAttribute("user");
		User useranalized = (User) request.getAttribute("useranalized");
		boolean freelance = (u.getId() == useranalized.getId());
		// border:1px solid black;
%>
		<style>
			#detail, #reviews, #similar
			{
				padding:20px;
				text-align:justify;
			}
			
			
			.expense div
			{
				padding-left:5px;
				padding-right:5px;
			}
			
			.expense .title
			{
				display:inline-block;
				width:30%;
				font-weight:bold;
			}
			
			.expense .doe
			{
				display:inline-block;
				width:25%;
			}
			
			.expense .delete
			{
				display:inline-block;
				width:45%;
			}

			
			
		</style>

		<jsp:include page="menu.jsp" />

		<div class="w3-card-4 w3-indigo rientrostandard">
			<h1> <%=useranalized.getName()%> - <%=useranalized.getSurname()%> </h1>
		</div>
		<div class="w3-third" id="detailuser" style="width:25%">
			<br />
			<b> DoB: </b> <%=useranalized.getDob().toLocaleString().substring(0,11) %><br />
			<b> Address: </b> <%=useranalized.getCity() %> - <%=useranalized.getAddress() %>
			<b>Yearly: </b> <%=useranalized.getYearly() %> &euro; 
		</div>
		
		<div class="w3-third" id="expenses" style="width:40%;">
			<h2> Expenses: </h2>
			<%
			for(Expense e : useranalized.getExpenses())
			{	
			%>
			<div class="expense">
				<div class="title">
					<%=e.getTitle() %>
				</div>
				 <div class="doe">
				 	<%=e.getDoe().toLocaleString().substring(0,11) %>
				</div>
				 <div class="value">
				 	<%=e.getValue() %> &euro;
				</div>
				<%
				if(freelance) {
				%>
				<div class="delete" style="display:inline-block;">
					<a href="Index?cmd=deleteexpense&expenseid=<%=e.getId() %>&iduser=0" class="w3-btn w3-indigo">Remove</a>
				</div>
				<%
				}
				%>
			</div>		
			<%
			}
			%>	
		</div>
		<div class="newExpence" style="width:30%; display:inline-block;">
			<%if(freelance) {%>
			<div id="formexpense">
				<h2> New Expense </h2>
				<form method="post" action="Index">
					Titolo
					<input type="text" name="title" class="w3-input"/>
					Date of Expense
					<input type="text" name="doe" class="w3-input" />
					Value
					<input type="number" name="value" class="w3-input" />
					<input type="hidden" name="cmd" value="addexpense" />
					<input type="hidden"  name="iduser" value="0" />
					<input type="submit" value="save" class="w3-btn w3-indigo" />
				</form>
			</div>
			<%} %>
		</div>
			<%if(!freelance) {%>
		<div class="back" style="width:30%; display:inline-block;">
			<a href="Index?cmd=listprofile" class="w3-btn w3-indigo">Back</a>
		</div>
			<%} %>
		
	</body>
</html>
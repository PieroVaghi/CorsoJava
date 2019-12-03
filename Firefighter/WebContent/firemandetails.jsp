<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="com.generation.firefighter.model.entities.*"    
%>
<%
	Fireman f = (Fireman) request.getAttribute("fireman");
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
			
			#newbadge
			{
				padding-left:20px;
				padding-right:20px;
			}
			
			#badgess
			{
			}
			
			.redbackground
			{
				color:#ffffff;
				background-color:#6b0311;
			}
	
			
			
			
		</style>
	</head>
	<body>
		<div class="w3-card-4 redbackground rientrostandard">
			<h1> Fireman - <%=f.getName()%> <%=f.getSurname()%></h1>
		</div>
		<div class="w3-half" id="detail">
			<form method="get" action="Index">
				<h2> Detail for Fireman <%=f.getName() %> <%=f.getSurname()%></h2>
				<%=f.getLevel()%>
				<br />
				<%=f.getSalary()%>  &euro;
				<br />
				<br />
				<a href="Index?cmd=" class="w3-btn redbackground">Back</a>
			</form>
		</div>
		<div class="w3-quarter" id="newbadge">
			<h2> New Badge </h2>
			<form method="get" action="Index">
				Titolo
				<input type="text" name="title" class="w3-input"/>
				Livello di Rischio
				<input type="number" name="risklevel" class="w3-input" />
				<input type="hidden" name="cmd" value="savebadge" />
				<input type="hidden" name="firemanid" value="<%= f.getId()%>">
				<input type="submit" value="save" class="w3-btn redbackground rientrostandard" />
			</form>
		</div>
		<div class="w3-quarter" id="badges">
			<h2> Badges </h2>
			<%
			for(Badge r:f.getBadges())
			{	
			%>
			<div class="badge">
				<%=r.getTitle() %> - <%=r.getRisklevel() %>/5
			</div>		
			<%
			}
			%>
		</div>
		
	</body>
</html>
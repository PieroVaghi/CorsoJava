<%@ 
	page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.generation.firefighter.model.entities.*,java.util.List"
    
%>
<!-- pagina principale -->
<%
	List<Fireman> firemans = (List<Fireman>) request.getAttribute("firemans");

%>
<html>
	<head>
		<title> GENERATION FIRE DEPARTMENT </title>
		<!-- sto scaricando una libreria -->
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<style>
			.rientrostandard
			{
				padding-left:10px;
			}
			
			.fireman
			{
				margin-top:10px;
				margin-bottom:10px;
				padding-left:10px;
			}
			
			.redbackground
			{
				color:#ffffff;
				background-color:#6b0311;
			}
			.center 
			{
				margin: auto;
				width: 100%;
				padding: 10px;
			}
	
		</style>
	</head>
	<body>
		<div class="w3-card-4 redbackground rientrostandard center">
			<h1> GENERATION FIRE DEPARTMENT <a href="Index?cmd=bella">?</a></h1>	
		</div>
		<%
		for(Fireman f:firemans)
		{
		%>
		<div class="fireman w3-third">
			<b> <%=f.getName()%> </b> <b> <%=f.getSurname()%> </b><br />
			Grado: <b><%=f.getLevel() %> </b><br />
			<div class="numbers">
				Stipendio mensile: <%=f.getSalary() %> &euro;
			</div>
			<a href="Index?cmd=firemandetails&id=<%=f.getId() %>" class="w3-btn redbackground">Detail</a>
		</div>
		<%
		}
		%>	
			
			
		
	</body>
</html>
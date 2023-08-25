<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>View Movies</title>
		<style type="text/css">
	*{
		margin: 0;
		padding: 0;
		box-sizing: border-box;
		list-style: none;
		text-decoration: none;
		font-family: 'Josefin sans', 'sans-serif'
	}

	body {
		background: #f3f5f9;
	}
	
	.wrapper {
		display: flex;
		position: relative;
	}
	
	.wrapper .sidebar {
		position: fixed;
		width: 200px;
		height: 100%;
		background: black;
		padding: 30px 0;
	}
	
	.wrapper .sidebar h2 {
		color: #fff;
		text-transform: uppercase;
		text-align: center;
		margin-bottom: 30px;
	}
	
	.wrapper .sidebar ul li {
		padding: 15px;
		border-bottom: 1px solid rgba(0,0,0,0.05);
		border-bottom: 1px solid rgba(255,255,255,0.05);
	}
	
	.wrapper .sidebar ul li a {
		color: #bdb8d7;
		display: block;
	}
	
	.wrapper .sidebar ul li:hover {
		background: #594f8d;
	}
	
	.wrapper .sidebar ul li:hover a{
		color: #fff;
	}
	
	.wrapper .main-content {
		width: 100%;
		margin-left: 200px;
	}
	
	.wrapper .main-content .header {
		padding: 20px;
		background: #fff;
		color: #717171; 
		border-bottom: 1px solid #e0e4e8;
	}
		
		</style>
	</head>
	<body>
		<div class="wrapper">
		<div class="sidebar">
			<h2>ADMIN</h2>
				<ul>
					<li><a href="add-employee-form.jsp">ADD EMPLOYEES</a></li>
					
					<li><a href="listEmployees.jsp">VIEW EMPLOYEES</a></li>
					
					<li><a href="add-movies.jsp">ADD MOVIES</a></li>
					
					<li><a href="listMovies.jsp">VIEW MOVIES</a></li>
					
					<li><a href="index.html">LOG OUT</a></li>
				</ul>
		</div>
		<div class="main-content">
			<div class="header">Welcome <% out.println(session.getAttribute("username")); %></div>
			
			<table>
			<thead>
				<tr> 
					<th>id</th>
					<th>Title</th>
					<th>Director</th>
					<th>Actors</th>
					<th>Genre</th>
					<th>Year Of Production</th>
					<th>Average Rating</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="tempMovie" items="${MOVIE_LIST}">
			
			<!-- set up a for each movie -->
	   
	   		<c:url var="tempLink" value="MovieControllerServlet">
	   	
					<c:param name="command" value="LOAD"/>
					<c:param name="movieId" value="${tempMovie.id}"/>
					
				</c:url>
				
			<c:url var="deleteLink" value="MovieControllerServlet">
			
					<c:param name="command" value="DELETE"/>
					<c:param name="movieId" value="${tempMovie.id}"/>
					
				</c:url>
				
				<tr><td>${tempMovie.id}</td></tr>
				<tr><td>${tempMovie.Title}</td></tr>
				<tr><td>${tempMovie.Director}</td></tr>
				<tr><td>${tempMovie.Actors}</td></tr>
				<tr><td>${tempMovie.genre}</td></tr>
				<tr><td>${tempMovie.year_of_production}</td></tr>
				<tr><td>${tempMovie.average_rate}</td></tr>
	
			</c:forEach>
			</tbody>
			</table>
			
		</div>
		
	</div>
	</body>
</html>
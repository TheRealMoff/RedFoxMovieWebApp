<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Admin Dashboard</title>
		<link type="text/css" rel="stylesheet" href="admin.css"/>
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
			<div class="header">Welcome</div>
			
		</div>
	</div>
	
	</body>
	
</html>
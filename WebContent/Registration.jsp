<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register</title>
		<link type="text/css" rel="stylesheet" href="registration.css"/>
	</head>
<body>
	<div class="container">
		<div class="title">REGISTRATION</div>
		
		<form action="RedFoxControllerServlet" method="POST">
		
			<input type="hidden" name="command" value="ADD"/>
			<div class="SubscriberDetails">
			
			<div class="input-box">
				<span class="details">First Name</span>
				<input type="text" name="firstName" placeholder="Enter Your First Name" required>
			</div>
			<div class="input-box">
				<span class="details">Last Name</span>
				<input type="text" name="surname" placeholder="Enter Your Last Name" required>
			</div>
				<div class="input-box">
				<span class="details">Email Address</span>
				<input type="email" name="emailAddress" placeholder="Enter Your Email Address" required>
			</div>
			<div class="input-box">
				<span class="details">List Of Genres</span>
				<input type="text" name="listOfGenres" placeholder="List Of Genres" required>
			</div>
			<div class="input-box">
				<span class="details">Password</span>
				<input type="password" name="password" placeholder="Enter Your Password" required>
			</div>
			<br>
			<div class="buttonREG">
				<input type="submit" value="Create Account"
				OnClick="window.location.href='subscriberDash.jsp'; return: false;" />
			</div>
			<a href="userLogIn.jsp">Already have an account? Sign In</a>
			</div>
		</form>
	</div>
</body>
</html>
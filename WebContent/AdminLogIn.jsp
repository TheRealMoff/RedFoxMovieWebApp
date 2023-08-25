<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Log In</title>
<link type="text/css" rel="stylesheet" href="registration.css"/>
</head>

<body>
	<div class="container">
		<div class="title">ADMIN LOG IN</div>
		
		<form action="RedFoxControllerServlet" method="POST">
		
			<input type="hidden" name="command" value="ADMIN">
			<div class="SubscriberDetails">
			
			<div class="input-box">
				<span class="details">Username</span>
				<input type="text" name="username" placeholder="Enter Your Username" required>
			</div>
			
			<div class="input-box">
				<span class="details">Password</span>
				<input type="password" name="password" placeholder="Enter Your Password" required>
			</div>
			<div class="buttonREG">
				<input type="submit" value="Log In"
				OnClick="window.location.href='adminPortal.jsp'; return=false;" />
			</div>
			</div>
		</form>
	</div>
</body>
</html>
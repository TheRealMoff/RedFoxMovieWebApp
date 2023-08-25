<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Sign In</title>
			<link type="text/css" rel="stylesheet" href="registration.css"/>
	</head>
<body>
	<div class="container">
		<div class="title">SIGN IN</div>
		
		<form action="RedFoxControllerServlet" method="POST">
		
			<input type="hidden" name="command" value="USERLOG"/>
			<div class="SubscriberDetails">
			
			<div class="input-box">
				<span class="details">Email Address</span>
				<input type="text" name="emailAddress" placeholder="Enter Your Email Address" required>
			</div>
			<div class="input-box">
				<span class="details">Password</span>
				<input type="password" name="password" placeholder="Enter Your Password" required>
			</div>
			<div class="buttonREG">
				<input type="submit" value="SIGN IN"
				OnClick="window.location.href='subscriberDash.jsp'; return: false;" />
			</div>
			</div>
		</form>
	</div>
</body>
</html>
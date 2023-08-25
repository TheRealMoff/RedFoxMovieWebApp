<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Confirmation</title>
	</head>
	<%
		//read form data
		String favGenre = request.getParameter("favoriteGenre");
		
		
		//create the cookie
		Cookie theCookie = new Cookie("myApp.favoriteGenre", favGenre);
		
		
		//set the life span of the cookie....total number of seconds
		theCookie.setMaxAge(60*60*24*365);
		
		//send the cookie to the browser
		response.addCookie(theCookie);
		
		%>
	
		<body>
			Thanks! We set your favorite genre to: ${param.favoriteGenre}
			
			<br/>
			
			<a href="subscriberDash.jsp">Return to the home-page</a>
		
		</body>
</html>
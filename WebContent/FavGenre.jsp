<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Set Favorite Genre</title>
	</head>
	<body>
		<h3>Favorite Genre</h3>
		<!-- Read the favorite genre cookie -->
		<%
		//The default...if there are no cookies
		
		String favGenre = "Comedy";
		
		//Get the cookie from the browser request
		
		Cookie [] theCookies = request.getCookies();
		
		//Find our favorite language cookie
		
		if (theCookies != null){
			for (Cookie tempCookie: theCookies ){
				if("myApp.favoriteGenre".equals(tempCookie.getName())){
					favGenre = tempCookie.getValue();
					break;
				}
			}
		}
		
		%>
	 <!-- now show a personilized page ... "favGenre" variable -->
	 
	 <h4>New Movies for <%=favGenre %></h4>
	 
		 <ul>
			 <li>Recommended Movie 1</li>
			 <li>Recommended Movie 2</li>
			 <li>Recommended Movie 3</li>
			 <li>Recommended Movie 4</li>
			 
		 </ul>
	
	<a href = "cookies-personilised-form.jsp">Personilise the page</a>
	</body>
		
	</body>
</html>
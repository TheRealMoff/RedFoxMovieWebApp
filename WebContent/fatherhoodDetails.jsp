<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Details</title>
		
		<style>
		
		body {
	
			background: #96a39b;
		}
		.container {
			transition: 0.3s;
			display: flex;
			justify-content: center;
			width: 30%;
			height: 490px;
			background-color: #FFFFFF;
			position: center;
			padding: 50px;
			margin: 75px;
			margin-top: 40px;
			border-radius: 5px;
		}
		
		.block {
			width: 200px;
			margin: 20px;
			display: block;
			float: left;
		}
		
		.container .block p {
			font-family: 'Roboto', sans-serif;
		}
		
		.movie {
			width: 100%;
		}
		
		.movie movie {
			width: 100%;
		}
		
		.movie-information {
			width: 100%;
			height: 5rem;
			text-align: center;
		}
		
		.movie img{
			width: 100%;
		}
		
		</style>
	</head>
	<body>
		<div class="container">
			<div class="block">
					<div class="movie">
						<a href="">
							<img alt="Fatherhood" src="https://upload.wikimedia.org/wikipedia/en/thumb/f/f5/Fatherhood_poster.jpg/220px-Fatherhood_poster.jpg"/>
						</a>
					</div>
					
				<p>Title: Fatherhood<br/>
				<br/>
				Actor: Kevin Hart<br/>
				<br/>
				Director: Paul Weitz<br/>
				<br/>
				Year: 2021<br/>
				<br/>
				Genre: Drama</p>
			</div>
		</div>
	</body>
</html>
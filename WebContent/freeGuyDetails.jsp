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
			height: 460px;
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
							<img alt="Free Guy" src="https://m.media-amazon.com/images/M/MV5BOTY2NzFjODctOWUzMC00MGZhLTlhNjMtM2Y2ODBiNGY1ZWRiXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg"/>
						</a>
					</div>
					
				<p>Title: Free Guy<br/>
				<br/>
				Actor: Ryan Reynolds<br/>
				<br/>
				Director: Shawn Levy<br/>
				<br/>
				Year: 2021<br/>
				<br/>
				Genre: Action</p>
			</div>
		</div>
	</body>
</html>
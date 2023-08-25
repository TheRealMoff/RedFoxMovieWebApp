<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>RedFox Movie App</title>
		
		<style>
		
		* {
			padding: 0px;
			margin: 0px;
		}
		
		body {
			background: #96a39b;
		}
		
		header {
			width: 100%;
			height: 3rem;
			background: red;
			display: flex;
			padding: 3px;
			justify-content: space-around;
			background: #577880;
		}
		 ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #577880;
}

 li {
  float: right;
}

 li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}


 li a:hover {
  background-color: #111;
}
		
		.container {
			margin-top: 90px;
			width: 100%;
			padding: 30px;
		}
		
		.block {
			width: 200px;
			margin: 20px;
			display: block;
			float: left;
		}
		
		.container .block h1 {
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
		<header>
			<h1>RedFox</h1>
			<ul>
					<li><a href="index.html">LOG OUT</a></li>
					<li><a href="FavGenre.jsp">Set Favorite Genre</a></li>
			</ul>
		</header>
		<section>
			<div class="container">
				<div class="block">
					<div class="movie">
						<a href="">
							<img alt="Hereditary" src="data:image/jpeg;base64,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"/>
						</a>
					</div>
					<div class="movie-information">
						<h1>Hereditary</h1>
						<a href="hereditaryDetails.jsp">View Details</a>
					</div>
				
				</div>
				
				<div class="block">
					<div class="movie">
						<a href="">
							<img alt="Free Guy" src="https://m.media-amazon.com/images/M/MV5BOTY2NzFjODctOWUzMC00MGZhLTlhNjMtM2Y2ODBiNGY1ZWRiXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg"/>
						</a>
					</div>
					<div class="movie-information">
						<h1>Free Guy</h1>
						<a href="freeGuyDetails.jsp">View Details</a>
					</div>
				
				</div>
				<div class="block">
					<div class="movie">
						<a href="">
							<img alt="Spider-Man: No Way Home" src="https://m.media-amazon.com/images/M/MV5BMDUzNWJhZWQtYzU3Zi00M2NjLThjZjEtMTRmMjRmNzBmMWI2XkEyXkFqcGdeQXVyODIyOTEyMzY@._V1_.jpg"/>
						</a>
					</div>
					<div class="movie-information">
						<h1>Spider-Man: No Way Home</h1>
						<a href="spiderManDetails.jsp">View Details</a>
					</div>
				
				</div>
				
				<div class="block">
					<div class="movie">
						<a href="">
							<img alt="Game Night" src="https://m.media-amazon.com/images/M/MV5BMjI3ODkzNDk5MF5BMl5BanBnXkFtZTgwNTEyNjY2NDM@._V1_.jpg"/>
						</a>
					</div>
					<div class="movie-information">
						<h1>Game Night</h1>
						<a href="gameNightDetails.jsp">View Details</a>
					</div>
				
				</div>
				
				<div class="block">
					<div class="movie">
						<a href="">
							<img alt="Fatherhood" src="https://upload.wikimedia.org/wikipedia/en/thumb/f/f5/Fatherhood_poster.jpg/220px-Fatherhood_poster.jpg"/>
						</a>
					</div>
					<div class="movie-information">
						<h1>Fatherhood</h1>
						<a href="fatherhoodDetails.jsp">View Details</a>
					</div>
				
				</div>
			</div>
			
		</section>
		
	</body>
</html>
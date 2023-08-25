<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add New Movie</title>
		
		<style>

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
		.box {
		/* width: 600px; */
		width: 100%;
		background-color: #fff;
		margin: auto;
		margin-top: 40px;
		border-radius: 5px;
		}
		
		.addMovieForm {
        display: flex;
        justify-content: center;
		top: 60px;
		left: 50%;
		width: 100%;
		}
		
		.addMovieForm input {
		font-size: 16px;
		padding: 15px 10px;
		width: 100%;
		left: 50%;
		border: 0;
		border-radius: 5px;
		outline: none;
        /* border: 1px solid black; */
        box-shadow: 0px 4px 2px 1px rgba(0, 0, 0, 0.363);
		}
		
		.addMovies button {
		font-size: 18px;
		font-weight: bold;
		margin: 20px 0;
		padding: 5px 10px;
		cursor: pointer;
		width: 40%;
		border: 0;
		border-radius: 5px;
		background-color: #fff;
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
			<div class="box">
				<div class="addMovieForm">
				
                   
					
					<form action="MovieControllerServlet" method="post">
                         <div class="header">
                        <h1>ADD Movie</h1>
                    </div>
						<input type="hidden" name="command" value="ADD">
						
						<input type="text" name="movieID" placeholder="Movie ID...">
						
						 <br><br/>
						
						<label for="avatar">Choose a picture:</label>
						<input type="file" id="image" name="image" accept="image/png, image/jpeg">
						<br><br/>
						
						<input type="text" name="title" placeholder="Title...">
						 <br><br/>
						
						<input type="text" name="director" placeholder="Director...">
						 <br><br/>
						
						<input type="text" name="actors" placeholder="Actors...">
						 <br><br/>
						
						<input type="text" name="genre" placeholder="Genre...">
						 <br><br/>
						
						<input type="date" name="date" placeholder="Year Of Production...">
						 <br><br/>
						
						<input type="text" name="rating" placeholder="Rating...">
						 <br><br/>
						
						<input type="submit"  value="ADD MOVIE"> 
					
					</form>
				</div>
                 
			</div>
           
			</div>
		</div>
	</body>
</html>
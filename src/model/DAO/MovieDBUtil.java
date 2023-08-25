package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.BEANS.Movie;

public class MovieDBUtil {
	
	private DataSource dataSource;
	
	public MovieDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public void addMovie(Movie movie) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql to insert movie
			String sql = "insert into movie" + "(id,image,Title,Director,Actors,genre,year_of_production,average_rate)" + "values(?,?,?,?,?,?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			
			//set param values
			myStmt.setString(1, movie.getId());
			myStmt.setString(2, movie.getImage());
			myStmt.setString(3, movie.getTitle());
			myStmt.setString(4, movie.getDirector());
			myStmt.setString(5, movie.getActors());
			myStmt.setString(6, movie.getGenre());
			myStmt.setString(7, movie.getYear_of_production());
			myStmt.setInt(8, movie.getAverage_rate());
			
			//execute query
			myStmt.execute();
		}
		finally {
			close(myConn,myStmt,myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if(myConn != null) {
				myConn.close();
			}
			if(myStmt != null) {
				myStmt.close();
			}
			if(myRs != null) {
				myRs.close();
			}
		}
		catch(Exception exec) {
			exec.printStackTrace();
		}
		
	}

	public List<Movie> getMovies() throws Exception {
		List<Movie> movies = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create a sql statement
			String sql = "Select * all from movie order by title";
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				//retrieve data from result set row
				String id = myRs.getString("id");
				String Title = myRs.getString("Title");
				String Director = myRs.getString("Director");
				String Actors = myRs.getString("Actors");
				String genre = myRs.getString("genre");
				String year_of_production = myRs.getString("year_of_production");
				int average_rate = myRs.getInt("average_rate");
				
				//create new movie object
				Movie tempMovie = new Movie(id,Title,Director,Actors,genre,year_of_production,average_rate);
				
				//add it to the list of movies
				movies.add(tempMovie);
			}
		}
		finally {
			close(myConn,myStmt,myRs);
		}
		
		return movies;
	}

}

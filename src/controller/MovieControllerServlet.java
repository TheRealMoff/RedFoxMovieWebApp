package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.BEANS.Movie;
import model.DAO.MovieDBUtil;

/**
 * Servlet implementation class MovieControllerServlet
 */
@WebServlet("/MovieControllerServlet")
public class MovieControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MovieDBUtil movieDBUtil;
	
	//define datasource/connection pool for resource injection
	@Resource(name = "jdbc/redfox")
	private DataSource dataSource;
	
	
       
    @Override
	public void init() throws ServletException {
		super.init();
		//create our MovieDBUtil and parse in the connection pool
		movieDBUtil = new MovieDBUtil(dataSource);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//read "the command parameter"
			String theCommand = request.getParameter("command");
			
			//if the command is missing then default to listing movies
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listMovies(request,response);
				break;
			
			default:
				listMovies(request,response);
			}
		}
		catch(Exception exec) {
			throw new ServletException(exec);
		}
	}

	private void listMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//get the movie list from MovieDBUtil
		List<Movie> movies = movieDBUtil.getMovies();
		
		//add the student to the request
		request.setAttribute("MOVIE_LIST", movies);
		
		//send to jsp page(view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listMovies.jsp");
		dispatcher.forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//read "the command parameter"
			String theCommand = request.getParameter("command");
			
			//route to the appropriate method
			switch(theCommand) {
			
			
			case "ADD":
				addMovie(request,response);
				break;
			}
		}
		catch(Exception exec) {
			throw new ServletException(exec);
		}
	}


	private void addMovie(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read movie data from form
		String movieID = request.getParameter("movieID");
		String image = request.getParameter("image");
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String actors = request.getParameter("actors");
		String genre = request.getParameter("genre");
		String date = request.getParameter("date");
		int rating = Integer.parseInt(request.getParameter("rating"));
		
		//create a new movie object
		Movie movie = new Movie(movieID,image,title,director,actors,genre,date,rating);
		
		//add the movie to the database
		movieDBUtil.addMovie(movie);
		
		//send to jsp page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPortal.jsp");
		dispatcher.forward(request, response);
		
	}

}

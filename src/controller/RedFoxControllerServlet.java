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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import model.BEANS.Admin;
import model.BEANS.Employee;
import model.BEANS.Subscriber;
import model.DAO.RedFoxDBUtil;

/**
 * Servlet implementation class RedFoxControllerServlet
 */
@WebServlet("/RedFoxControllerServlet")
public class RedFoxControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RedFoxDBUtil redFoxDBUtil;
       
	//define datasource/connection pool for resource injection
	@Resource(name = "jdbc/redfox")	
	private DataSource dataSource;	
		
	@Override
		public void init() throws ServletException {
			super.init();
			//create our RedFoxDBUtil and parse in the connection pool
			redFoxDBUtil = new RedFoxDBUtil(dataSource);
		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//read the "command parameter"
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing students
			
			if(theCommand == null) {
				
			theCommand = "list";
			
			}
			
			//route to the appropriate method
			
			switch(theCommand) {
			
			case "list":
				listEmployees(request,response);
				break;
			
			default:
				listEmployees(request,response);
			}
			}
			catch (Exception exec) {
			throw new ServletException(exec);
			}

	}
	
	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			//gets subscriber from DBUtil
			List<Employee> employees = redFoxDBUtil.getEmployees();
			
			//add subscriber to the request
			request.setAttribute("EMPLOYEE_LIST", employees);
			
			//send to jsp page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/listEmployees.jsp");
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
				addSubscriber(request,response);
				break;
				
			case "ADMIN":
				adminLogIn(request,response);
				break;
				
			case "USERLOG":
				subscriberLogIn(request,response);
				break;
			}
		}
		catch(Exception exec) {
			throw new ServletException(exec);
		}
	}

	private void subscriberLogIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read subscriber data from form
		String emailAddress = request.getParameter("emailAddress");
		String password = request.getParameter("password");
		
		//create a new subscriber object
		Subscriber theSubscriber = new Subscriber(emailAddress, password);
		
		//retrieve the subscriber from the database
		redFoxDBUtil.subscriberLogIn(theSubscriber);
		
		//retrieve the admin from the database
		redFoxDBUtil.subscriberLogIn(theSubscriber);
				
		RedFoxDBUtil login = new RedFoxDBUtil(dataSource);
				
		if(redFoxDBUtil.subscriberLogIn(theSubscriber)) {
			HttpSession session = request.getSession();
			session.setAttribute(emailAddress, session);
			response.sendRedirect("subscriberDash.jsp");
		}
		else {
			
			response.sendRedirect("userLogIn.jsp");
			
			}
		
		//send to view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subscriberDash.jsp");
		
	}

	private void adminLogIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read admin details from form data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//create a new admin object
		Admin admin = new Admin(username,password);
		
		//retrieve the admin from the database
		redFoxDBUtil.adminLogIn(admin);
		
		RedFoxDBUtil login = new RedFoxDBUtil(dataSource);
		
		if(redFoxDBUtil.adminLogIn(admin)) {
			HttpSession session1 = request.getSession();
			session1.setAttribute(username, session1);
			response.sendRedirect("adminPortal.jsp");
		}
		else {
			response.sendRedirect("AdminLogIn.jsp");
		}
		
		//send to view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPortal.jsp");
		//dispatcher.forward(request, response);
	}

	private void addSubscriber(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read subscriber info from form data
		String firstName = request.getParameter("firstName");
		String surname = request.getParameter("surname");
		String emailAddress = request.getParameter("emailAddress");
		String listOfGenres = request.getParameter("listOfGenres");
		String password = request.getParameter("password");
		
		//create a new subscriber object
		Subscriber theSubscriber = new Subscriber(firstName,surname,emailAddress,listOfGenres,password);
		
		//add the subscriber to the database
		redFoxDBUtil.addSubscriber(theSubscriber);
		
		//send to jsp page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subscriberDash.jsp");
		dispatcher.forward(request, response);
		
	}

}

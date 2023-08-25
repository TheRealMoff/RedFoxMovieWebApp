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

import model.BEANS.Employee;
import model.DAO.AdmindashboardDBUtil;

/**
 * Servlet implementation class adminDashServlet
 */
@WebServlet("/adminDashServlet")
public class AdmindashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdmindashboardDBUtil adminDashboardDBUtil;
	
	//define datasource/connection pool for resource injection
	@Resource(name = "jdbc/redfox")
	private DataSource dataSource;
	
	
       
    @Override
	public void init() throws ServletException {
		super.init();
		//create our AdmindashboardDBUtil and parse in the connection pool
		adminDashboardDBUtil = new AdmindashboardDBUtil(dataSource);
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
			
		theCommand = "LIST";
		
		}
		
		//route to the appropriate method
		
		switch(theCommand) {
		
		case "LIST":
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
		System.out.println("working...");
		//get the employee list from the DBUtil
		List<Employee> listEmployees = adminDashboardDBUtil.getEmployees();
		
		//add the employee to the request
		request.setAttribute("listEmployees", listEmployees);
		
		//send to jsp page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employees.jsp");
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
			
			case "addEmployee":
				addEmployee(request,response);
				break;
			}
		}
		catch(Exception exec) {
			throw new ServletException(exec);
		}
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read employee data from form
		
		String name = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String password = request.getParameter("password");
		
		//create a new employee object
		Employee theEmployee = new Employee(name,surname,password);
		
		//add the employee to the database
		adminDashboardDBUtil.addEmployee(theEmployee);
		
		//send to jsp page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/add-employee-form.jsp");
		dispatcher.forward(request, response);
	}

}

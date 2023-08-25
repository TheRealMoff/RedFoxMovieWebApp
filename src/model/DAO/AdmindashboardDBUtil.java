package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.BEANS.Employee;

public class AdmindashboardDBUtil {
	
	private DataSource dataSource;
	
	public AdmindashboardDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public void addEmployee(Employee theEmployee) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//get DB connection
			myConn = dataSource.getConnection();
			
			//create sql for insert employee
			String sql = "insert into employee" + "(firstName,surname,password)" + "values(?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			
			//set the param values for the employee
			myStmt.setString(1, theEmployee.getFirstName());
			myStmt.setString(2, theEmployee.getSurname());
			myStmt.setString(3, theEmployee.getPassword());
			
			//execute query
			myStmt.execute();
		}
		finally {
			//clean up jdbc objects
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) throws Exception {

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

	public List<Employee> getEmployees() throws Exception {
		List<Employee> listEmployees = new ArrayList<>();
		System.out.println("working out...");
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//get connection
			myConn = dataSource.getConnection();
			
			//create a sql statement
			String sql = "Select * from employee";
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			System.out.println(myStmt);
			//process the result set
			while(myRs.next()) {
				//retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("firstName");
				String surname = myRs.getString("surname");
				String password = myRs.getString("password");
				System.out.println(myStmt);
				//create new employee object
				Employee employees = new Employee(id,firstName,surname,password);
				
				//add it to the list of employees
				listEmployees.add(employees);
			}
		}
		finally {
			close(myConn,myStmt,myRs);
		}
		return listEmployees;
	}

}

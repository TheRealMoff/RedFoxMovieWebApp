package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.BEANS.Admin;
import model.BEANS.Employee;
import model.BEANS.Subscriber;

public class RedFoxDBUtil {
	
	private DataSource dataSource;
	
	public RedFoxDBUtil(DataSource theDataSource){
		dataSource = theDataSource;
	}

	public void addSubscriber(Subscriber theSubscriber) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//get DB connection
			myConn = dataSource.getConnection();
			
			//create sql for insert
			String sql = "insert into subscriber" + "(firstName,surname,emailAddress,listOfGenres,password)" + "values(?,?,?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			
			//set the param values for the subscriber
			myStmt.setString(1, theSubscriber.getFirstName());
			myStmt.setString(2, theSubscriber.getSurname());
			myStmt.setString(3, theSubscriber.getEmailAddress());
			myStmt.setString(4, theSubscriber.getListOfGenres());
			myStmt.setString(5, theSubscriber.getPassword());
			
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up jdbc objects
			close(myConn, myStmt, myRs);
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

	public boolean adminLogIn(Admin admin) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		boolean status = false;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql statement
			String sql = "Select * from admin where username = ? and password = ?";
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setString(1, admin.getUsername());;
			myStmt.setString(2, admin.getPassword());
			
			myRs = myStmt.executeQuery();
			status = myRs.next();
		}
		finally {
			close(myConn, myStmt, myRs);
		}
		
		return status;
	}

	public boolean subscriberLogIn(Subscriber theSubscriber) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		boolean status = false;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql statement
			String sql = "Select * from subscriber where emailAddress = ? and password = ?";
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setString(1, theSubscriber.getEmailAddress());
			myStmt.setString(2, theSubscriber.getPassword());
			
			myRs = myStmt.executeQuery();
			status = myRs.next();
		}
		finally {
			close(myConn, myStmt, myRs);
		}
		
		return status;
		
	}

	public List<Employee> getEmployees() throws Exception {
		
		List<Employee> employees = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//get connection
			myConn = dataSource.getConnection();
			
			//create a sql statement
			String sql = "Select * from employee order by surname";
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process the result set
			while(myRs.next()) {
				//retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("firstName");
				String surname = myRs.getString("surname");
				String password = myRs.getString("password");
				
				//create new employee object
				Employee tempEmployee = new Employee(id,firstName,surname,password);
				
				//add it to the list of employees
				employees.add(tempEmployee);
			}
		}
		finally {
			close(myConn,myStmt,myRs);
		}
		return employees;
	}

}

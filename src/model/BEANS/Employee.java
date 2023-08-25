package model.BEANS;

public class Employee {
	private int id;
	private String firstName;
	private String surname;
	private String password;
	public Employee(String firstName, String surname, String password) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.password = password;
	}
	public Employee(int id, String firstName, String surname, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", surname=" + surname + ", password=" + password
				+ "]";
	}
	
	
}

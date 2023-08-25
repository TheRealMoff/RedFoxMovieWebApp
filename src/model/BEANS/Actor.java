package model.BEANS;

public class Actor {
	private String firstName;
	private String surname;
	private String dateOfBirth;
	public Actor(String firstName, String surname, String dateOfBirth) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Actor [firstName=" + firstName + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}

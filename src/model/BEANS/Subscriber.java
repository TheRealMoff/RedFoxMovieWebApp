package model.BEANS;

public class Subscriber {
	private int userID;
	private String firstName;
	private String surname;
	private String emailAddress;
	private String listOfGenres;
	private String password;
	public Subscriber(int userID, String firstName, String surname, String emailAddress, String listOfGenres,
			String password) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.surname = surname;
		this.emailAddress = emailAddress;
		this.listOfGenres = listOfGenres;
		this.password = password;
	}
	public Subscriber(String firstName, String surname, String emailAddress, String listOfGenres, String password) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.emailAddress = emailAddress;
		this.listOfGenres = listOfGenres;
		this.password = password;
	}
	
	public Subscriber(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getListOfGenres() {
		return listOfGenres;
	}
	public void setListOfGenres(String listOfGenres) {
		this.listOfGenres = listOfGenres;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Subscriber [userID=" + userID + ", firstName=" + firstName + ", surname=" + surname + ", emailAddress="
				+ emailAddress + ", listOfGenres=" + listOfGenres + ", password=" + password + "]";
	}
	

}

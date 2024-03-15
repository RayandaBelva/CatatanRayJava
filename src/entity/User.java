package src.entity;

public class User {
	private String userID;
	private String userName;
	private String password;
	private String address;
	private String email;
	private int phoneNumber;
	private int debt;
	private int kredit;

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}

	public void setKredit(int kredit) {
		this.kredit = kredit;
	}

	public String getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public int getDebt() {
		return debt;
	}

	public int getKredit() {
		return kredit;
	}
}

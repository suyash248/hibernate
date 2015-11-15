package org.soni;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
	private int userID;
	private String userName;
	private static String companyName;
	private transient int atmPin;

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public static String getCompanyName() {
		return companyName;
	}
	public static void setCompanyName(String companyName) {
		UserDetails.companyName = companyName;
	}
	public int getAtmPin() {
		return atmPin;
	}
	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}
}

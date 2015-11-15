package org.soni;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userID;
	private String userName;
	private static String companyName;
	private transient int atmPin;
	//@Temporal(TemporalType.TIMESTAMP)	 Default, for date and time both
	//@Temporal(TemporalType.TIME)		For time only
	@Temporal(TemporalType.DATE)		// For date only
	private Date joinedDate;

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
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
}

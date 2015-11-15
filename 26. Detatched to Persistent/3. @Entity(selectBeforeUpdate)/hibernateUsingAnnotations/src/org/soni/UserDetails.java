package org.soni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.AccessType;

@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class UserDetails {
	@Id
	@GeneratedValue
	private int userID;
	private String userName;

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
}

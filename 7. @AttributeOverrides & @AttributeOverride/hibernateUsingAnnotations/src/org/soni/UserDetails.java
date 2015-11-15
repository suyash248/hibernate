package org.soni;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userID;
	private String userName;
	
	@AttributeOverrides({
		@AttributeOverride(name="cityName", column=@Column (name="HOME_CITY_NAME")),
		@AttributeOverride(name="stateName", column=@Column (name="HOME_STATE_NAME")),
		@AttributeOverride(name="pinCode", column=@Column (name="HOME_PIN_CODE"))
	})
	private Address homeAddress;
	
	@AttributeOverrides({
		@AttributeOverride(name="cityName", column=@Column (name="OFFICE_CITY_NAME")),
		@AttributeOverride(name="stateName", column=@Column (name="OFFICE_STATE_NAME")),
		@AttributeOverride(name="pinCode", column=@Column (name="OFFICE_PIN_CODE"))
	})
	private Address officeAddress;
	
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
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
}

package org.soni;

import java.util.HashSet;
import java.util.Set;

public class UserDetails {
	private int userID;
	private String userName;
	private Set<Vehicle> vehicles=new HashSet<Vehicle>();
	
	public int getUserID() {
		return userID;
	}
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
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

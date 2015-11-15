package org.soni;

import java.util.ArrayList;
import java.util.List;

public class UserDetails {
	private int userID;
	private String userName;
	private List<Vehicle> vehicles=new ArrayList<Vehicle>();
	
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
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}

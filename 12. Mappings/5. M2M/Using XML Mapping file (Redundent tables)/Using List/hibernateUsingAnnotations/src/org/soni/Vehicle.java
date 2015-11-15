package org.soni;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	private int vehicleId;
	private String vehicleName;
	private String vehicleOwner;
	private List<UserDetails> userDetailsCollection = new ArrayList<UserDetails>();
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleOwner() {
		return vehicleOwner;
	}
	public void setVehicleOwner(String vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}
	public List<UserDetails> getUserDetailsCollection() {
		return userDetailsCollection;
	}
	public void setUserDetailsCollection(List<UserDetails> userDetailsCollection) {
		this.userDetailsCollection = userDetailsCollection;
	}
}

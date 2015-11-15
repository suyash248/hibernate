package org.soni;

import java.util.HashSet;
import java.util.Set;

public class Vehicle {
	private int vehicleId;
	private String vehicleName;
	private String vehicleOwner;
	private Set<UserDetails> userDetailsCollection = new HashSet<UserDetails>();
	
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
	public Set<UserDetails> getUserDetailsCollection() {
		return userDetailsCollection;
	}
	public void setUserDetailsCollection(Set<UserDetails> userDetailsCollection) {
		this.userDetailsCollection = userDetailsCollection;
	}
}

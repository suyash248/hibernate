package org.soni;

public class Vehicle {
	private int vehicleId;
	private String vehicleName;
	private String vehicleOwner;
	private UserDetails userDetials;
	
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
	public UserDetails getUserDetials() {
		return userDetials;
	}
	public void setUserDetials(UserDetails userDetials) {
		this.userDetials = userDetials;
	}
}

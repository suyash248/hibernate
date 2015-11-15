package org.soni;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	private String vehicleOwner;
	@ManyToMany
	private Collection<UserDetails> userDetailsCollection = new ArrayList<UserDetails>();
	
	public int getVehicleId() {
		return vehicleId;
	}
	public Collection<UserDetails> getUserDetailsCollection() {
		return userDetailsCollection;
	}
	public void setUserDetailsCollection(
			Collection<UserDetails> userDetailsCollection) {
		this.userDetailsCollection = userDetailsCollection;
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
}

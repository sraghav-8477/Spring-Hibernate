/**
 * 
 */
package org.actuate.santhosh.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author user
 *
 */
@Entity
public class Vehicle {

	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	@ManyToMany
	@JoinTable(name="USER_VEHICLES",
		joinColumns=@JoinColumn(name="VEHICLE_ID"),
		inverseJoinColumns=@JoinColumn(name="USER_ID")
	)
	private Collection<UserDetails3> userList = new ArrayList<UserDetails3>();
	
	
	public Collection<UserDetails3> getUserList() {
		return userList;
	}
	public void setUserList(Collection<UserDetails3> userList) {
		this.userList = userList;
	}
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
	
	
}

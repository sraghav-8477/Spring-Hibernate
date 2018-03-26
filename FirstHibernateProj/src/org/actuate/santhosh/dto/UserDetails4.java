package org.actuate.santhosh.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity 
@Table (name="USER_DETAILS4")
public class UserDetails4 {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@OneToMany
	@NotFound (action=NotFoundAction.EXCEPTION)
	@JoinTable(name="USER_VEHICLE", 
	joinColumns=@JoinColumn (name="USER_ID"),
	inverseJoinColumns=@JoinColumn (name="VEHICLE_ID"))
	private Collection<Vehicle1> Vehicle = new ArrayList<Vehicle1>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<Vehicle1> getVehicle() {
		return Vehicle;
	}
	public void setVehicle(Collection<Vehicle1> vehicle) {
		Vehicle = vehicle;
	}
	
	
}
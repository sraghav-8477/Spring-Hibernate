/**
 * 
 */
package org.actuate.santhosh.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author user
 *
 */
@Entity 
@Table (name="USER_DETAILS2")
public class UserDetails2 {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USERID")
	private int userId;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Transient
	private String emailId;

	@ElementCollection
	@JoinTable(name="USER_ADDRESS",
		joinColumns=@JoinColumn(name="USER_ID")
		)
	@GenericGenerator(name = "sequence", strategy = "sequence")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "sequence", type = @Type(type = "long"))
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	
	
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

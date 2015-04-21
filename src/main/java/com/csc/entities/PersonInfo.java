package com.csc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "id", length = 12)
	private String id;
	
	@Column (name = "firstname")
	private String firstName;
	
	@Column (name = "lastname")
	private String lastName;
	
	@Column (name = "midname")
	private String midName;
	
	@Column (name = "phoneNum1")
	private String phoneNum1;
	
	@Column (name = "phoneNum2")
	private String phoneNum2;
	
	@Column (name = "address1")
	private String address1;
	
	@Column (name = "address2")
	private String address2;
	
	@Column (name = "email1")
	private String email1;
	
	@Column (name = "email2")
	private String email2;

	public PersonInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonInfo(String idCustomer, String firstName, String lastName,
			String midName, String phoneNum1, String phoneNum2,
			String address1, String address2, String email1, String email2) {
		super();
		this.id = idCustomer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midName = midName;
		this.phoneNum1 = phoneNum1;
		this.phoneNum2 = phoneNum2;
		this.address1 = address1;
		this.address2 = address2;
		this.email1 = email1;
		this.email2 = email2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getPhoneNum1() {
		return phoneNum1;
	}

	public void setPhoneNum1(String phoneNum1) {
		this.phoneNum1 = phoneNum1;
	}

	public String getPhoneNum2() {
		return phoneNum2;
	}

	public void setPhoneNum2(String phoneNum2) {
		this.phoneNum2 = phoneNum2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}
}

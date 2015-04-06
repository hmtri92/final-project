package com.csc.beans;

import java.io.Serializable;
import java.util.List;

public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long loginID;

	private String password;

	private long idCardNumber;

	private String firstName;

	private String lastName;

	private String midName;

	private long phoneNum1;

	private long phoneNum2;

	private String address1;

	private String address2;

	private String email1;

	private String email2;

	private StateBean state;

	private RoleBean role;
	
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserBean(long loginID, String password, long idCardNumber,
			String firstName, String lastName, String midName, long phoneNum1,
			long phoneNum2, String address1, String address2, String email1,
			String email2, StateBean state, RoleBean role) {
		super();
		this.loginID = loginID;
		this.password = password;
		this.idCardNumber = idCardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midName = midName;
		this.phoneNum1 = phoneNum1;
		this.phoneNum2 = phoneNum2;
		this.address1 = address1;
		this.address2 = address2;
		this.email1 = email1;
		this.email2 = email2;
		this.state = state;
		this.role = role;
	}



	public long getLoginID() {
		return loginID;
	}

	public void setLoginID(long loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(long idCardNumber) {
		this.idCardNumber = idCardNumber;
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

	public long getPhoneNum1() {
		return phoneNum1;
	}

	public void setPhoneNum1(long phoneNum1) {
		this.phoneNum1 = phoneNum1;
	}

	public long getPhoneNum2() {
		return phoneNum2;
	}

	public void setPhoneNum2(long phoneNum2) {
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

	public StateBean getState() {
		return state;
	}

	public void setState(StateBean state) {
		this.state = state;
	}

	public RoleBean getRole() {
		return role;
	}

	public void setRole(RoleBean role) {
		this.role = role;
	}
}

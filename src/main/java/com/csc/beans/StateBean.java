package com.csc.beans;

import java.io.Serializable;
import java.util.List;

public class StateBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String NEW = "NEW";
	
	public static final String ACTIVE = "ACTIVE";
	
	public static final String DISABLE = "DISABLE";
	
	public static final String REMOVEABLE = "REMOVEABLE";
	
	private int idState;
	
	private String name;
	
	private List<AccountBean> accounts;

	private List<UserBean> users;

	public StateBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StateBean(int idState, String name, List<AccountBean> accounts,
			List<UserBean> users) {
		super();
		this.idState = idState;
		this.name = name;
		this.accounts = accounts;
		this.users = users;
	}

	public int getIdState() {
		return idState;
	}

	public void setIdState(int idState) {
		this.idState = idState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccountBean> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountBean> accounts) {
		this.accounts = accounts;
	}

	public List<UserBean> getUsers() {
		return users;
	}

	public void setUsers(List<UserBean> users) {
		this.users = users;
	}
}

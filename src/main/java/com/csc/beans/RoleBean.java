package com.csc.beans;

import java.io.Serializable;
import java.util.List;

public class RoleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String USER_ADMIN = "USER_ADMIN";

	public static final String USER_SUPPORT = "USER_SUPPORT";

	public static final String ACCOUNT_ADMIN = "ACCOUNT_ADMIN";

	public static final String ACCOUNT_SUPPORT = "ACCOUNT_SUPPORT";

	public static final String REPORT_SUPPORT = "REPORT_SUPPORT";

	private int idRole;

	private String nameRole;

	private List<UserBean> users;

	private List<AccountBean> accounts;

	public RoleBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleBean(int idRole, String nameRole, List<UserBean> users,
			List<AccountBean> accounts) {
		super();
		this.idRole = idRole;
		this.nameRole = nameRole;
		this.users = users;
		this.accounts = accounts;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public List<UserBean> getUsers() {
		return users;
	}

	public void setUsers(List<UserBean> users) {
		this.users = users;
	}

	public List<AccountBean> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountBean> accounts) {
		this.accounts = accounts;
	}
}

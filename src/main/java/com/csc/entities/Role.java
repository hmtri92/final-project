package com.csc.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "role")
public class Role {

	@Transient
	public static final String USER_ADMIN = "USER_ADMIN";
	
	@Transient
	public static final String USER_SUPPORT = "USER_SUPPORT";
	
	@Transient
	public static final String ACCOUNT_ADMIN = "ACCOUNT_ADMIN";
	
	@Transient
	public static final String ACCOUNT_SUPPORT = "ACCOUNT_SUPPORT";
	
	@Transient
	public static final String REPORT_SUPPORT = "REPORT_SUPPORT";
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id_role")
	private int idRole;
	
	@NotEmpty
	@Column (name = "nameRole")
	private String nameRole;
	
	@OneToMany (mappedBy = "role")
	private List<User> users;
	
	@OneToMany (mappedBy = "role")
	private List<Account> accounts;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int idRole, String nameRole, List<User> users,
			List<Account> accounts) {
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}

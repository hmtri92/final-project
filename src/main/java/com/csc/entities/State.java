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
@Table (name = "state")
public class State {
	
	@Transient
	public static final int NEW = 1;
	
	@Transient
	public static final int ACTIVE = 2;
	
	@Transient
	public static final int DISABLE = 3;
	
	@Transient
	public static final int REMOVEABLE = 4;
	
	@Id
	private int idState;
	
	@NotEmpty
	@Column (name = "name")
	private String name;
	
	@OneToMany (mappedBy = "state")
	private List<Account> accounts;

	@OneToMany (mappedBy = "state")
	private List<User> users;

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(int idState, String name, List<Account> accounts,
			List<User> users) {
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}

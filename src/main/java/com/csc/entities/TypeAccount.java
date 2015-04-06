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
@Table (name = "typeAccount")
public class TypeAccount {

	@Transient
	public static final String DEPOSIT = "DEPOSIT";
	@Transient
	public static final String SAVING = "SAVING";
	@Transient
	public static final String OTHER = "OTHER";
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id_typeaccount")
	private int idType;
	
	@NotEmpty
	@Column (name = "type")
	private String type;
	
	@OneToMany (mappedBy = "typeAccount")
	private List<Account> accounts;

	public TypeAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeAccount(int idType, String type, List<Account> accounts) {
		super();
		this.idType = idType;
		this.type = type;
		this.accounts = accounts;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}

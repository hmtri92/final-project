package com.csc.beans;

import java.io.Serializable;
import java.util.List;

public class TypeAccountBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String DEPOSIT = "DEPOSIT";
	public static final String SAVING = "SAVING";
	public static final String OTHER = "OTHER";
	private int idType;
	
	private String type;
	
	private List<AccountBean> accounts;

	public TypeAccountBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeAccountBean(int idType, String type, List<AccountBean> accounts) {
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

	public List<AccountBean> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountBean> accounts) {
		this.accounts = accounts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

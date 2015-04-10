package com.csc.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table ( name = "account")
public class Account {

	@Id
	@Column (name = "id_acount", length = 12)
	private String accountNumber;
	
<<<<<<< .mine
=======
	@ManyToOne
	@JoinColumn (name = "id_type")
	private TypeAccount typeAccount;	
	
>>>>>>> .r26
	@Column (name = "availableAmount")
	private BigDecimal availableAmount;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name = "id_type")
	private TypeAccount typeAccount;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name = "id_state")
	private State state;
	
	@OneToMany (mappedBy = "account")
	private List<BalanceAmount> balanceAmounts;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name = "id_role")
	private Role role;
	
	@ManyToOne
	@JoinColumn (name = "accountOwner")
	private User accountOwner;
	
	@OneToMany (mappedBy = "sendAccount")
	private List<Transaction> sendTracsactions;
	
	@OneToMany (mappedBy = "receiveAccount")
	private List<Transaction> receiveTracsactions;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Account(String accountNumber, TypeAccount typeAccount,			
			BigDecimal availableAmount, State state) {
		super();
		this.accountNumber = accountNumber;
		this.typeAccount = typeAccount;
		this.availableAmount = availableAmount;
		this.state = state;
	}


	public Account(String accountNumber, TypeAccount typeAccount, State state,
			BigDecimal availableAmount,
			List<BalanceAmount> balanceAmounts, Role role,
			List<Transaction> sendTracsactions,
			List<Transaction> receiveTracsactions) {
		super();
		this.accountNumber = accountNumber;
		this.typeAccount = typeAccount;
		this.availableAmount = availableAmount;
		this.state = state;
		this.balanceAmounts = balanceAmounts;
		this.role = role;
		this.sendTracsactions = sendTracsactions;
		this.receiveTracsactions = receiveTracsactions;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public TypeAccount getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(TypeAccount typeAccount) {
		this.typeAccount = typeAccount;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<BalanceAmount> getBalanceAmounts() {
		return balanceAmounts;
	}

	public void setBalanceAmounts(List<BalanceAmount> balanceAmounts) {
		this.balanceAmounts = balanceAmounts;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}	
	
}

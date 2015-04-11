package com.csc.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
public class Account extends PersonInfo {

	
	@Column (name = "id_cardNumber")
	private String idCardNumber;
		
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
	
	@OneToMany (mappedBy = "sendAccount")
	private List<Transaction> sendTracsactions;
	
	@OneToMany (mappedBy = "receiveAccount")
	private List<Transaction> receiveTracsactions;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String idCustomer, String firstName, String lastName,
			String midName, String phoneNum1, String phoneNum2,
			String address1, String address2, String email1, String email2,
			String idCardNumber, BigDecimal availableAmount,
			TypeAccount typeAccount, State state,
			List<BalanceAmount> balanceAmounts, Role role,
			List<Transaction> sendTracsactions,
			List<Transaction> receiveTracsactions) {
		super(idCustomer, firstName, lastName, midName, phoneNum1, phoneNum2, address1,
				address2, email1, email2);
		this.idCardNumber = idCardNumber;
		this.availableAmount = availableAmount;
		this.typeAccount = typeAccount;
		this.state = state;
		this.balanceAmounts = balanceAmounts;
		this.role = role;
		this.sendTracsactions = sendTracsactions;
		this.receiveTracsactions = receiveTracsactions;
	}

	public Account(String idCardNumber, BigDecimal availableAmount,
			TypeAccount typeAccount, State state,
			List<BalanceAmount> balanceAmounts, Role role,
			List<Transaction> sendTracsactions,
			List<Transaction> receiveTracsactions) {
		super();
		this.idCardNumber = idCardNumber;
		this.availableAmount = availableAmount;
		this.typeAccount = typeAccount;
		this.state = state;
		this.balanceAmounts = balanceAmounts;
		this.role = role;
		this.sendTracsactions = sendTracsactions;
		this.receiveTracsactions = receiveTracsactions;
	}

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
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

	public List<Transaction> getSendTracsactions() {
		return sendTracsactions;
	}

	public void setSendTracsactions(List<Transaction> sendTracsactions) {
		this.sendTracsactions = sendTracsactions;
	}

	public List<Transaction> getReceiveTracsactions() {
		return receiveTracsactions;
	}

	public void setReceiveTracsactions(List<Transaction> receiveTracsactions) {
		this.receiveTracsactions = receiveTracsactions;
	}
}

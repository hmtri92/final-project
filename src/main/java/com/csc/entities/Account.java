package com.csc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table ( name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account extends PersonInfo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column (name = "id_cardNumber")
	private String idCardNumber;
		
	@Column (name = "availableAmount")
	private BigDecimal availableAmount;
	
	@ManyToOne
	@JoinColumn (name = "id_type")
	private TypeAccount typeAccount;
	
	@ManyToOne
	@JoinColumn (name = "id_state")
	private State state;
	
	@OneToMany (mappedBy = "account")
	@JsonIgnore
	private List<BalanceAmount> balanceAmounts;
	
	@OneToMany (mappedBy = "sendAccount")
	@JsonIgnore
	private List<Transaction> sendTracsactions;
	
	@OneToMany (mappedBy = "receiveAccount")
	@JsonIgnore
	private List<Transaction> receiveTracsactions;
	
	@OneToMany (mappedBy = "accountOwner")
	@JsonIgnore
	private List<TargetAccount> targetAccounts;
	
	@OneToMany (mappedBy = "accountTarget")
	@JsonIgnore
	private List<TargetAccount> targetOfAccounts;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String idCustomer, String firstName, String lastName,
			String midName, String phoneNum1, String phoneNum2,
			String address1, String address2, String email1, String email2,
			String idCardNumber, BigDecimal availableAmount,
			TypeAccount typeAccount, State state,
			List<BalanceAmount> balanceAmounts,
			List<Transaction> sendTracsactions,
			List<Transaction> receiveTracsactions,
			List<TargetAccount> targetAccounts,
			List<TargetAccount> targetOfAccounts) {
		super(idCustomer, firstName, lastName, midName, phoneNum1, phoneNum2, address1,
				address2, email1, email2);
		this.idCardNumber = idCardNumber;
		this.availableAmount = availableAmount;
		this.typeAccount = typeAccount;
		this.state = state;
		this.balanceAmounts = balanceAmounts;
		this.sendTracsactions = sendTracsactions;
		this.receiveTracsactions = receiveTracsactions;
		this.targetAccounts = targetAccounts;
		this.targetOfAccounts = targetOfAccounts;
	}

	public Account(String idCardNumber, BigDecimal availableAmount,
			TypeAccount typeAccount, State state,
			List<BalanceAmount> balanceAmounts,
			List<Transaction> sendTracsactions,
			List<Transaction> receiveTracsactions) {
		super();
		this.idCardNumber = idCardNumber;
		this.availableAmount = availableAmount;
		this.typeAccount = typeAccount;
		this.state = state;
		this.balanceAmounts = balanceAmounts;
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

	public List<TargetAccount> getTargetAccounts() {
		return targetAccounts;
	}

	public void setTargetAccounts(List<TargetAccount> targetAccounts) {
		this.targetAccounts = targetAccounts;
	}

	public List<TargetAccount> getTargetOfAccounts() {
		return targetOfAccounts;
	}

	public void setTargetOfAccounts(List<TargetAccount> targetOfAccounts) {
		this.targetOfAccounts = targetOfAccounts;
	}
}

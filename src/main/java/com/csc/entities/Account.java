package com.csc.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table ( name = "account")
public class Account {

	@Id
	@Column (name = "id_acount", length = 12)
	private String accountNumber;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn (name = "id_type")
	private TypeAccount typeAccount;
	
	@NotEmpty
	@Column (name = "id_cardNumber")
	private String idCardNumber;
	
	@NotEmpty
	@Column (name = "firstname")
	private String firstName;
	
	@NotEmpty
	@Column (name = "lastname")
	private String lastName;
	
	@NotEmpty
	@Column (name = "midname")
	private String midName;
	
	@NotEmpty
	@Column (name = "phoneNum1")
	private long phoneNum1;
	
	@NotEmpty
	@Column (name = "phoneNum2")
	private long phoneNum2;
	
	@NotEmpty
	@Column (name = "address1")
	private String address1;
	
	@NotEmpty
	@Column (name = "address2")
	private String address2;
	
	@NotEmpty
	@Column (name = "email1")
	private String email1;
	
	@NotEmpty
	@Column (name = "email2")
	private String email2;
	
	@NotEmpty
	@Column (name = "availableAmount")
	private Long availableAmount;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn (name = "id_state")
	private State state;
	
	@OneToMany (mappedBy = "account")
	private List<BalanceAmount> balanceAmounts;
	
	@NotEmpty
	@ManyToOne
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

	public Account(String accountNumber, TypeAccount typeAccount,
			String idCardNumber, String firstName, String lastName,
			String midName, long phoneNum1, long phoneNum2, String address1,
			String address2, String email1, String email2, State state,
			List<BalanceAmount> balanceAmounts, Role role,
			List<Transaction> sendTracsactions,
			List<Transaction> receiveTracsactions) {
		super();
		this.accountNumber = accountNumber;
		this.typeAccount = typeAccount;
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

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
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

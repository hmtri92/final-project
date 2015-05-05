package com.csc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "balanceAmounts")
public class BalanceAmount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id_balance")
	private long idBalanceAmount;
	
	@Column (name = "balance")
	private BigDecimal balance;
	
	@Column (name = "period")
	private Date period;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn (name = "id_Account")
	private Account account;

	public BalanceAmount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BalanceAmount( BigDecimal balance, Date period, Account account) {
		super();
		this.balance = balance;
		this.period = period;
		this.account = account;
	}

	public long getIdBalanceAmount() {
		return idBalanceAmount;
	}

	public void setIdBalanceAmount(long idBalanceAmount) {
		this.idBalanceAmount = idBalanceAmount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}

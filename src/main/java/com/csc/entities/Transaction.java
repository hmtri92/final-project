package com.csc.entities;

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

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "logTransaction")
public class Transaction {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id_transaction")
	private long idTransaction;
	
//	@NotEmpty
	@Column (name = "date")
	private Date date;
	
	@Column (name = "amount")
	private BigDecimal amount;
	
	@NotEmpty
	@Column (name = "content")
	private String content;
	
	@ManyToOne
	@JoinColumn (name = "sendAccount")
	private Account sendAccount;
	
	@ManyToOne
	@JoinColumn (name = "receiveAccount")
	private Account receiveAccount;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(long idTransaction, Date date, BigDecimal amount,
			String content, Account sourceAccount, Account targetAccount) {
		super();
		this.idTransaction = idTransaction;
		this.date = date;
		this.amount = amount;
		this.content = content;
		this.sendAccount = sourceAccount;
		this.receiveAccount = targetAccount;
	}

	public long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Account getSendAccount() {
		return sendAccount;
	}

	public void setSendAccount(Account sourceccount) {
		this.sendAccount = sourceccount;
	}

	public Account getReceiveAccount() {
		return receiveAccount;
	}

	public void setReceiveAccount(Account targetAccount) {
		this.receiveAccount = targetAccount;
	}
}

package com.csc.beans;

import java.io.Serializable;
import java.util.Date;

public class LogTransactionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long idTransaction;

	private Date date;

	private Date timeStart;

	private Date timeEnd;

	private String content;

	private AccountBean account;

	public LogTransactionBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogTransactionBean(long idTransaction, Date date, Date timeStart,
			Date timeEnd, String content, AccountBean account) {
		super();
		this.idTransaction = idTransaction;
		this.date = date;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.content = content;
		this.account = account;
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

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public AccountBean getAccount() {
		return account;
	}

	public void setAccount(AccountBean account) {
		this.account = account;
	}
}

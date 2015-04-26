package com.csc.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class User extends Account {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column (name = "login_id")
    private String loginID;

    @Column (name = "password")
    private String password;
    
    @ManyToOne
	@JoinColumn (name = "id_role")
	private Role role;
    
    @JoinColumn (name = "endDateTimeLogin")
    private Date endDateTimeLogin;
    
    @JoinColumn (name = "countLogin")
    private int countLogin;

	public User() {
        super();
    }

	public User(String idCardNumber, BigDecimal availableAmount,
			TypeAccount typeAccount, State state,
			List<BalanceAmount> balanceAmounts,
			List<TransactionHistory> sendTracsactions,
			List<TransactionHistory> receiveTracsactions) {
		super(idCardNumber, availableAmount, typeAccount, state, balanceAmounts,
				sendTracsactions, receiveTracsactions);
		// TODO Auto-generated constructor stub
	}

	public User(String id, String firstName, String lastName, String midName,
			String phoneNum1, String phoneNum2, String address1,
			String address2, String email1, String email2, String idCardNumber,
			BigDecimal availableAmount, TypeAccount typeAccount, State state,
			List<BalanceAmount> balanceAmounts,
			List<TransactionHistory> sendTracsactions,
			List<TransactionHistory> receiveTracsactions,
			List<TargetAccount> targetAccounts,
			List<TargetAccount> targetOfAccounts) {
		super(id, firstName, lastName, midName, phoneNum1, phoneNum2, address1,
				address2, email1, email2, idCardNumber, availableAmount, typeAccount,
				state, balanceAmounts, sendTracsactions, receiveTracsactions,
				targetAccounts, targetOfAccounts);
		// TODO Auto-generated constructor stub
	}

	public User(String loginID, String password, Role role,
			Date endDateTimeLogin, int countLogin) {
		super();
		this.loginID = loginID;
		this.password = password;
		this.role = role;
		this.endDateTimeLogin = endDateTimeLogin;
		this.countLogin = countLogin;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getEndDateTimeLogin() {
		return endDateTimeLogin;
	}

	public void setEndDateTimeLogin(Date endDateTimeLogin) {
		this.endDateTimeLogin = endDateTimeLogin;
	}

	public int getCountLogin() {
		return countLogin;
	}

	public void setCountLogin(int countLogin) {
		this.countLogin = countLogin;
	}
}
package com.csc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "user")
public class User extends PersonInfo {

    
    @Column (name = "login_id")
    private String loginID;

    @Column (name = "password")
    private String password;

    @Column (name = "id_cardnumber")
    private String idCardNumber;

    @ManyToOne
    @JoinColumn (name = "id_state")
    private State state;

    @ManyToOne
    @JoinColumn (name = "id_role")
    private Role role;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	public User(String idCustomer, String firstName, String lastName,
			String midName, String phoneNum1, String phoneNum2,
			String address1, String address2, String email1, String email2,
			String loginID, String password, String idCardNumber,
			State state, Role role) {
		super(idCustomer, firstName, lastName, midName, phoneNum1, phoneNum2, address1,
				address2, email1, email2);
		this.loginID = loginID;
		this.password = password;
		this.idCardNumber = idCardNumber;
		this.state = state;
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

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
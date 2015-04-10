package com.csc.ultil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.entities.Account;
import com.csc.entities.Role;
import com.csc.entities.State;
import com.csc.entities.TypeAccount;
import com.csc.entities.User;

@Repository
public class CreateDatabase {
	@PersistenceContext//(unitName="final-project")
	EntityManager em;
	
	@Transactional
	public void createRole() {
		Role roleUserAdmin = new Role();
		roleUserAdmin.setIdRole(1);
		roleUserAdmin.setNameRole("USER_ADMIN");
		
		Role roleUserSupport = new Role();
		roleUserSupport.setIdRole(2);
		roleUserSupport.setNameRole("USER_SUPPORT");
		
		Role roleAccountAdmin = new Role();
		roleAccountAdmin.setIdRole(3);
		roleAccountAdmin.setNameRole("ACCOUNT_ADMIN");
		
		Role roleAccountSupport = new Role();
		roleAccountSupport.setIdRole(4);
		roleAccountSupport.setNameRole("ACCOUNT_SUPPORT");
		
		Role roleReportSupport = new Role();
		roleReportSupport.setIdRole(5);
		roleReportSupport.setNameRole("REPORT_SUPPORT");
		
		try {
			em.persist(roleUserAdmin);
			em.persist(roleUserSupport);
			em.persist(roleAccountAdmin);
			em.persist(roleAccountSupport);
			em.persist(roleReportSupport);
		} catch ( Exception e) {
			
		}
	}
	
	@Transactional
	public void createTypeAccount() {
		TypeAccount deposit = new TypeAccount();
		deposit.setIdType(1);
		deposit.setType("DEPOSIT");
		
		TypeAccount saving = new TypeAccount();
		saving.setIdType(2);
		saving.setType("SAVING");
		
		TypeAccount other = new TypeAccount();
		other.setIdType(3);
		other.setType("OTHER");
		
		try {
			em.persist(deposit);
			em.persist(saving);
			em.persist(other);
		} catch (Exception e) {
			
		}
	}
	
	@Transactional
	public void createState() {
		State snew = new State();
		snew.setIdState(1);
		snew.setName("NEW");
		
		State active = new State();
		active.setIdState(2);
		active.setName("ACTIVE");
		
		State disable = new State();
		disable.setIdState(3);
		disable.setName("DISABLE");
		
		State removeable = new State();
		removeable.setIdState(4);
		removeable.setName("REMOVEABLE");
		
		State removed = new State();
		removed.setIdState(5);
		removed.setName("REMOVED");
		
		try {
			em.persist(snew);
			em.persist(active);
			em.persist(disable);
			em.persist(removeable);
			em.persist(removed);
		} catch (Exception e) {}
		
	}
	
	@Transactional
	public void createAccount() {
		Role roleSupport = em.find(Role.class, Role.ACCOUNT_SUPPORT);
		TypeAccount type = em.find(TypeAccount.class, TypeAccount.SAVING);
		State state = em.find(State.class, State.ACTIVE);
		
		Account minhtri = new Account();
		minhtri.setAccountNumber("123456789012");
		minhtri.setIdCardNumber("123456789012");
		minhtri.setFirstName("Huynh");
		minhtri.setMidName("Minh");
		minhtri.setLastName("Tri");
		minhtri.setAddress1("Tan Binh");
		minhtri.setAddress2("Thu Duc");
		minhtri.setEmail1("hmtri92@gmail.com");
		minhtri.setEmail2("minhtri@gmail.com");
		minhtri.setAvailableAmount(1234567L);
		minhtri.setPhoneNum1(975115833L);
		minhtri.setPhoneNum2(975115833L);
		minhtri.setRole(roleSupport);
		minhtri.setTypeAccount(type);
		minhtri.setState(state);
		
		try {
			em.persist(minhtri);
		} catch (Exception e) {}
	}
	
	@Transactional
	public void createUser() {
		Role roleSupport = em.find(Role.class, Role.ACCOUNT_ADMIN);
		State state = em.find(State.class, State.ACTIVE);
		
		User minhtri = new User();
		minhtri.setLoginID(12345L);
		minhtri.setPassword("12345");
		minhtri.setIdCardNumber(123456789012L);
		minhtri.setFirstName("Huynh");
		minhtri.setMidName("Minh");
		minhtri.setLastName("Tri");
		minhtri.setAddress1("Tan Binh");
		minhtri.setAddress2("Thu Duc");
		minhtri.setEmail1("hmtri92@gmail.com");
		minhtri.setEmail2("minhtri@gmail.com");
		minhtri.setPhoneNum1(975115833L);
		minhtri.setPhoneNum2(975115833L);
		minhtri.setRole(roleSupport);
		minhtri.setState(state);
		
		try {
			em.persist(minhtri);
		} catch (Exception e) {}
	}
}

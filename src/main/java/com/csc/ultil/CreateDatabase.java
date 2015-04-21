package com.csc.ultil;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		Role roleUser = new Role();
		roleUser.setIdRole(1);
		roleUser.setNameRole("CUSTOMER");
		
		Role roleAdmin = new Role();
		roleAdmin.setIdRole(2);
		roleAdmin.setNameRole("ADMIN");
		
		Role roleAccountSupport = new Role();
		roleAccountSupport.setIdRole(3);
		roleAccountSupport.setNameRole("ACCOUNT_SUPPORT");
		
		Role roleUserSupport = new Role();
		roleUserSupport.setIdRole(4);
		roleUserSupport.setNameRole("CUSTOMER_SUPPORT");
		
		Role roleReportSupport = new Role();
		roleReportSupport.setIdRole(5);
		roleReportSupport.setNameRole("REPORT_SUPPORT");
		
		try {
			em.persist(roleUser);
			em.persist(roleAdmin);
			em.persist(roleAccountSupport);
			em.persist(roleUserSupport);
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
	public void createUser() {
		Role roleAdmin = em.find(Role.class, Role.ADMIN);
		State state = em.find(State.class, State.ACTIVE);
		
		User minhtri = new User();
		minhtri.setId("01234567892");
		minhtri.setLoginID("admin");
		minhtri.setPassword("$2a$10$4HKVeFVczIQOoRMQ7tCb0OIob6GE7RgmcIqh1VKmuRFJApnmnampi");
		minhtri.setIdCardNumber("272015010"); 
		minhtri.setFirstName("Tri");
		minhtri.setMidName("Minh");
		minhtri.setLastName("Huynh");
		minhtri.setAddress1("Tan Binh");
		minhtri.setAddress2("Thu Duc");
		minhtri.setEmail1("hmtri92@gmail.com");
		minhtri.setEmail2("minhtri@gmail.com");
		minhtri.setPhoneNum1("0913131313");
		minhtri.setPhoneNum2("09090909");
		minhtri.setRole(roleAdmin);
		minhtri.setState(state);
		minhtri.setRole(roleAdmin);
		
		try {
			em.persist(minhtri);
			System.err.println("add Admin successfully!");
		} catch (Exception e) {}
		
		Role roleSupport = em.find(Role.class, Role.ACCOUNT_SUPPORT);
		State state2 = em.find(State.class, State.ACTIVE);
		
		User phuc = new User();
		phuc.setId("01234567891");
		phuc.setIdCardNumber("272015010"); 
		phuc.setFirstName("Tri");
		phuc.setMidName("Minh");
		phuc.setLastName("Huynh");
		phuc.setAddress1("Tan Binh");
		phuc.setAddress2("Thu Duc");
		phuc.setEmail1("hmtri92@gmail.com");
		phuc.setEmail2("minhtri@gmail.com");
		phuc.setPhoneNum1("0913131313");
		phuc.setPhoneNum2("09090909");
		phuc.setRole(roleSupport);
		phuc.setState(state2);
		phuc.setLoginID("support");
		phuc.setPassword("$2a$10$4HKVeFVczIQOoRMQ7tCb0OIob6GE7RgmcIqh1VKmuRFJApnmnampi");
		
		try {
			em.persist(phuc);
			System.err.println("add supporter successfully!");
		} catch (Exception e) {}
		
		Role roleCustomer = em.find(Role.class, Role.CUSTOMER);
		State state3 = em.find(State.class, State.ACTIVE);
		
		User quocanh = new User();
		quocanh.setId("01234567890");
		quocanh.setLoginID("customer");
		quocanh.setPassword("$2a$10$4HKVeFVczIQOoRMQ7tCb0OIob6GE7RgmcIqh1VKmuRFJApnmnampi");
		quocanh.setIdCardNumber("272015010"); 
		quocanh.setFirstName("Tri");
		quocanh.setMidName("Minh");
		quocanh.setLastName("Huynh");
		quocanh.setAddress1("Tan Binh");
		quocanh.setAddress2("Thu Duc");
		quocanh.setEmail1("hmtri92@gmail.com");
		quocanh.setEmail2("minhtri@gmail.com");
		quocanh.setPhoneNum1("0913131313");
		quocanh.setPhoneNum2("09090909");
		quocanh.setRole(roleCustomer);
		quocanh.setState(state3);
		
		try {
			em.persist(quocanh);
			System.err.println("add customer successfully!");
		} catch (Exception e) {}
	}
	
	@Transactional
	public void createAccount() {
		State state = em.find(State.class, State.ACTIVE);
		TypeAccount type = em.find(TypeAccount.class, TypeAccount.OTHER);
		
		Account minhtri = new Account();
		minhtri.setId("1234567890");
		minhtri.setIdCardNumber("272015010"); 
		minhtri.setFirstName("Huynh");
		minhtri.setMidName("Minh");
		minhtri.setLastName("Tri");
		minhtri.setAddress1("Tan Binh");
		minhtri.setAddress2("Thu Duc");
		minhtri.setEmail1("hmtri92@gmail.com");
		minhtri.setEmail2("minhtri@gmail.com");
		minhtri.setPhoneNum1("0913131313");
		minhtri.setPhoneNum2("09090909");
		minhtri.setState(state);
		minhtri.setTypeAccount(type);
		minhtri.setAvailableAmount( BigDecimal.valueOf(1000000));
		
		Account pug = new Account();
		pug.setId("123456789013");
		pug.setIdCardNumber("272015010"); 
		pug.setFirstName("Tran");
		pug.setMidName("Quoc");
		pug.setLastName("Thao");
		pug.setAddress1("Tan Binh");
		pug.setAddress2("Thu Duc");
		pug.setEmail1("pugTran@gmail.com");
		pug.setPhoneNum1("0913131313");
		pug.setState(state);
		pug.setTypeAccount(type);
		pug.setAvailableAmount( BigDecimal.valueOf(1000000));
		
		try {
			em.persist(minhtri);
//			em.persist(pug);
			System.err.println("add customer successfully!");
		} catch (Exception e) {}
	}
}

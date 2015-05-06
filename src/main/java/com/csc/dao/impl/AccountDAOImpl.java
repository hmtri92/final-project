package com.csc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.csc.dao.AccountDAO;
import com.csc.entities.Account;
import com.csc.entities.Role;
import com.csc.entities.State;
import com.csc.entities.TypeAccount;
import com.csc.entities.User;
/**
 * 
 * @author Quocanh
 *
 */

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public boolean addAccount(Account account, int idRole, int idType) {

		TypeAccount type = em.find(TypeAccount.class, idType);
		State state = em.find(State.class, State.NEW);

		account.setTypeAccount(type);
		account.setState(state);
		em.persist(account);
	
		return true;
	}
	/*
	 * (non-Javadoc)
	 * @see com.csc.dao.AccountDAO#getAccountById(java.lang.String)
	 */
	@Override
	public Account getAccountById(String id) {
		return em.find(Account.class, id);
		//get account by id 
	}
	/*
	 * (non-Javadoc)
	 * @see com.csc.dao.AccountDAO#updateStateAccountById(java.lang.String, int)
	 */
	@Override
	@Transactional
	public Account updateStateAccountById(String id,int idstate) {
			Account account = em.find(Account.class, id);
			State state = em.find(State.class, idstate);
			account.setState(state);
			em.persist(account);
			//change State
			return account;
	}
	/*
	 * (non-Javadoc)
	 * @see com.csc.dao.AccountDAO#updateAccount(java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public Account updateAccount(String id, int idstate, int idRole,String firtname,String lastname,String midname,
			int idType,String email1,String email2,String address1,String address2,String phoneNumber1,String phoneNumber2,String idcardNumber) {
		//modify account
			Account account = em.find(Account.class, id);
			State state = em.find(State.class, idstate);
			TypeAccount type = em.find(TypeAccount.class, idType);
			account.setState(state);
			account.setTypeAccount(type);
			account.setAddress1(address1);
			account.setAddress2(address2);
			account.setEmail1(email1);
			account.setEmail2(email2);
			account.setFirstName(firtname);
			account.setLastName(lastname);
			account.setMidName(midname);
			account.setPhoneNum1(phoneNumber1);
			account.setPhoneNum2(phoneNumber2);
			account.setIdCardNumber(idcardNumber);
			em.persist(account);
			return account;
	}
	/*
	 * (non-Javadoc)
	 * @see com.csc.dao.AccountDAO#getStateNew()
	 */
	@Override
	@Transactional
	public List<Account> getStateNew() {
		String sql = "SELECT t FROM Account t WHERE t.state.idState = :state";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("state", State.NEW);
		//.get state new
		List<Account> listState = query.getResultList();
		
		return listState;
		
	}
	/*
	 * (non-Javadoc)
	 * @see com.csc.dao.AccountDAO#getStateDis()
	 */
	@Override
	@Transactional
	public List<Account> getStateDis() {
		String sql = "SELECT t FROM Account t WHERE t.state.idState = :state";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("state", State.DISABLE);
		//get state Disable
		List<Account> listState = query.getResultList();
		
		return listState;		
	}
	/*
	 * (non-Javadoc)
	 * @see com.csc.dao.AccountDAO#getStateActive()
	 */
	@Override
	@Transactional
	public List<Account> getStateActive() {
		String sql = "SELECT t FROM Account t WHERE t.state.idState = :state";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("state", State.ACTIVE);
		//get state acctive
		List<Account> listState = query.getResultList();
		
		return listState;		
	}
/*
 * (non-Javadoc)
 * @see com.csc.dao.AccountDAO#addUser(com.csc.entities.User, int, int)
 */
	@Override
	@Transactional
	public boolean addUser(User user, int idRole, int idType) {

		Role role = em.find(Role.class, idRole);
		TypeAccount type = em.find(TypeAccount.class, idType);
		State state = em.find(State.class, State.NEW);

		user.setRole(role);
		user.setTypeAccount(type);
		user.setState(state);
		em.persist(user);
	
		return true;
	}
/*
 * (non-Javadoc)
 * @see com.csc.dao.AccountDAO#getAllUser()
 */
	@Override
	public List<User> getAllUser() {
		String sql = "SELECT t FROM User t ";
		TypedQuery<User> query = em.createQuery(sql, User.class);
	
		List<User> listUser = query.getResultList();
		
		return listUser;		
	}
/*
 * (non-Javadoc)
 * @see com.csc.dao.AccountDAO#checkLoginid(java.lang.String)
 */
	@Override
	public boolean checkLoginid(String LoginId) {
		try {
			String sql = "SELECT t FROM User t WHERE t.loginID = :LoginId";
			TypedQuery<User> query = em.createQuery(sql, User.class);
			query.setParameter("LoginId", LoginId);
			
			User user = query.getSingleResult();
			if (user == null) {
				return false;
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.csc.dao.AccountDAO#getRecomendedKeyList(int)
	 */
	@Override
	public List<String> getRecomendedKeyList(int searchType) {
		String sql1 = null;
		String sql2 = null;
		
		switch (searchType) {
		case 1:
			sql1 = "SELECT a.id FROM Account a";
			break;
		case 2:
			sql1 = "SELECT DISTINCT a.idCardNumber FROM Account a";
			break;
		case 3:
			sql1 = "SELECT DISTINCT CONCAT( a.firstName, ' ', a.midName, ' ', a.lastName)  FROM Account a";
			break;
		case 6:
			sql1 = "SELECT DISTINCT a.phoneNum1 FROM Account a";
			sql2 = "SELECT DISTINCT a.phoneNum2 FROM Account a";			
			break;
		case 7:
			sql1 = "SELECT DISTINCT a.address1 FROM Account a";
			sql2 = "SELECT DISTINCT a.address2 FROM Account a";
			break;
		case 8:
			sql1 = "SELECT DISTINCT a.email1 FROM Account a";
			sql2 = "SELECT DISTINCT a.email2 FROM Account a";
			break;
		default:
			break;
		}
		
		TypedQuery<String> query = em.createQuery(sql1, String.class);
		
		List<String> listRecomend = query.getResultList();
		
		if (sql2 != null) {
			query = em.createQuery(sql2, String.class);
			listRecomend.addAll(query.getResultList());
		}
		
		return listRecomend;
	}

	@Override
	public List<Account> searchAccountByAccountNumber(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.id LIKE :key1 OR a.id LIKE :key2 OR a.id LIKE :key3";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByIdCardNumber(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.idCardNumber LIKE :key1 OR a.idCardNumber LIKE :key2 OR a.idCardNumber LIKE :key3";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByOwnerName(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a "
				+ "WHERE CONCAT( a.firstName, ' ', a.midName, ' ', a.lastName) LIKE :key1 "
				+ "OR CONCAT( a.firstName, ' ', a.midName, ' ', a.lastName) LIKE :key2 "
				+ "OR CONCAT( a.firstName, ' ', a.midName, ' ', a.lastName) LIKE :key3";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByType(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.typeAccount.idType = :key";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key", Integer.parseInt(key));
	
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByState(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.state.idState = :key";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key", Integer.parseInt(key));
	
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByPhone(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.phoneNum1 LIKE :key1 OR a.phoneNum1 LIKE :key2 OR a.phoneNum1 LIKE :key3 "
				+ "OR a.phoneNum2 LIKE :key1 OR a.phoneNum2 LIKE :key2 OR a.phoneNum2 LIKE :key3 ";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByAddress(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.address1 LIKE :key1 OR a.address1 LIKE :key2 OR a.address1 LIKE :key3 "
				+ "OR a.address2 LIKE :key1 OR a.address2 LIKE :key2 OR a.address2 LIKE :key3 ";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByEmail(String key) {
		// TODO Auto-generated method stub
List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.email1 LIKE :key1 OR a.email1 LIKE :key2 OR a.email1 LIKE :key3 "
				+ "OR a.email2 LIKE :key1 OR a.email2 LIKE :key2 OR a.email2 LIKE :key3 ";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;	
		
	}
/*
 * (non-Javadoc)
 * @see com.csc.dao.AccountDAO#getStateRemvo()
 */
	@Override
	@Transactional
	public List<Account> getStateRemvo() {
		String sql = "SELECT t FROM Account t WHERE t.state.idState = :state";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("state", State.REMOVEABLE);
		//get state removeable
		List<Account> listState = query.getResultList();
		
		return listState;
	}

}


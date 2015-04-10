package com.csc.dao;



import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;





import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.entities.Account;



/**
 * DAO class for Account entity. This class contains all methods that
 * inserts/updates/deletes account info
 * 
 * @author TT
 *
 */
@Repository
public class AccountDAO {
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public boolean addAccount(String accountNumber, int typeAccount,
			String idCardNumber, String firstName, String lastName,
			String midName, long phoneNum1, long phoneNum2,
			String address1, String address2, String email1, String email2,
			Long availableAmount, int state, int role) {
		try {
			String sql = "INSERT INTO account(id_acount,id_type,id_cardNumber,firstname,lastName,midname,phoneNum1,phoneNum2,address1,address2,email1,email2,availableAmount,id_state,id_role) "
					+ "VALUE(:accountNumber,:typeAccount,:idCardNumber,:firstName,:lastName,:midName,:phoneNum1,:phoneNum2,:address1,:address2,:email1,:email2,:availableAmount,:state,:role)";
			entityManager.createNativeQuery(sql)
					.setParameter("accountNumber", accountNumber )
					.setParameter("typeAccount", typeAccount)
					.setParameter("idCardNumber", idCardNumber)
					.setParameter("firstName", firstName).
					setParameter("lastName", lastName)
					.setParameter("midName", midName)
					.setParameter("phoneNum1", phoneNum1)
					.setParameter("phoneNum2", phoneNum2)
					.setParameter("address1", address1)
					.setParameter("address2", address2)
					.setParameter("email1", email1)
					.setParameter("email2", email2)
					.setParameter("availableAmount", availableAmount)
					.setParameter("state", state)
					.setParameter("role", role)
					.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

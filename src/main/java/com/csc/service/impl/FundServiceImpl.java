package com.csc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.bean.AdminReponse;
import com.csc.dao.AccountDAO;
import com.csc.dao.AdminInfoDAO;
import com.csc.dao.FundDAO;
import com.csc.dao.ITargetAccountDAO;
import com.csc.dao.TransactionHistoryDAO;
import com.csc.entities.Account;
import com.csc.entities.State;
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;
import com.csc.entities.TransactionHistory;
import com.csc.service.FundService;

/**
 * 
 * @author MinhTri
 *
 */
@Service
public class FundServiceImpl implements FundService {

	@Autowired
	FundDAO fundDao;
	
	@Autowired
	TransactionHistoryDAO transactionDao;
	
	@Autowired
	ITargetAccountDAO targetAccountDao;
	
	@Autowired
	AccountDAO accountDao;
	
	@Autowired
	AdminInfoDAO adminInfoDao;
	
	@Override
	@Transactional
	public StateResult addFund(String id, BigDecimal amount) {
		return transactionDao.addFundTransaction(id, amount);
	}

	/**
	 * transfer from sendAccount_ID to targetAccount_ID with amount
	 * @param sendAccount_ID
	 * @param targetAccount_ID
	 * @param amount
	 * 
	 */
	@Override
	@Transactional
	public StateResult transfer(String sendAccount_ID, String targetAccount_ID, BigDecimal amount) {
		StateResult result = new StateResult();
		Account sendAccount = accountDao.getAccountById(sendAccount_ID);
		Account targetAccount = accountDao.getAccountById(targetAccount_ID);
		
		// check account
		if (targetAccount == null || sendAccount == null) {
			result.setState(false);
			result.setMessage("Account not found!");
			return result;
		}
		
		// Check money and state in sendAccount
		StateResult state = checkAccountSource(sendAccount, amount);
		if (!state.getState()) {
			return state;
		}
		
		// Add transaction transfer to TransactionHistory
		return transactionDao.saveTransfer(sendAccount, targetAccount, amount);
	}

	/**
	 * transfer from sendAccount_ID to account in targetAccount with amount
	 * @param sendAccount_ID
	 * @param targetAccount_ID
	 * @param amount
	 */
	@Override
	@Transactional
	public StateResult transferTargetID(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
		
		// get sendAccount
		Account sendAccount = accountDao.getAccountById(sendAccount_ID);
		
		// check atate and money of sendAccount
		StateResult state = checkAccountSource(sendAccount, amount);
		if (!state.getState()) {
			return state;
		}
		
		// Get account target in TargetAccount
		TargetAccount target = targetAccountDao.getTargetAccountById(targetAccount_ID);
		Account targetAccount = target.getAccountTarget();
		
		// Add transaction transfer to TransactionHistory
		return transactionDao.saveTransfer(sendAccount, targetAccount, amount);
	}

	/**
	 * withdraw account with amount
	 * @param account_id
	 * @param amount
	 * @return StateResult
	 */
	@Override
	@Transactional
	public StateResult withdraw(String account_id, BigDecimal amount) {
		
		// get Account by account_id
		Account account = accountDao.getAccountById(account_id);
		
		// check state and amount in account
		StateResult state = checkAccountSource(account, amount);
		if (!state.getState()) {
			return state;
		}
		
		// Add transaction withdraw to TransactionHistory
		return transactionDao.withdrawTransaction(account, amount);
	}

	/**
	 * get all transaction have new state
	 * @return List<TransactionHistory>
	 */
	@Override
	@Transactional
	public List<TransactionHistory> getNewTransaction() {
		return transactionDao.getNewTransaction();
	}

	/**
	 * verify transaction by id
	 * @param idTransaction
	 * @return StateResult
	 */
	@Override
	@Transactional
	public StateResult verifyTransaction(long idTransaction) {
		StateResult result = new StateResult(true, "Success");
		
		
		try {
			TransactionHistory transaction = transactionDao.getTransaction(idTransaction);
			
			// Transaction had active
			if (transaction.getState().getIdState() != State.ACTIVE) {
				result.setMessage("Transaction had active");
				return result;
			}
			
			// transaction had ignore
			if (transaction.getState().getIdState() != State.DISABLE) {
				result.setMessage("Transaction had ignore");
				return result;
			}
			
			// if transaction is add_fund
			if (transaction.getTypeTransaction() == TransactionHistory.ADD_FUND)
			{
				result = fundDao.addFund(transaction.getSendAccount(), transaction.getAmount());
				
			} else if (transaction.getTypeTransaction() == TransactionHistory.TRANSFER) {
				// if transaction is transfer
				
				// Check state account and money
				result = checkAccountSource(transaction.getSendAccount(), transaction.getAmount());
				if (!result.getState()) {
					return result;
				}
				
				result = fundDao.transfer(transaction.getSendAccount(), 
						transaction.getReceiveAccount(), transaction.getAmount());
			} else {
				//else transaction is withdraw
				
				//Check state account and money
				result = checkAccountSource(transaction.getSendAccount(), transaction.getAmount());
				if (!result.getState()) {
					return result;
				}
				
				result = fundDao.withdraw(transaction.getSendAccount(), transaction.getAmount());
			}
			
			if (result.getState()) {
				result = transactionDao.changeStateTransaction(transaction, State.ACTIVE);
			}
		} catch(NullPointerException e) {
			result.setState(false);
			result.setMessage("Transaction not found!");
		}
		
		
		return result;
	}
	
	/**
	 * get list target Account by owner
	 * @param idAccountOwner
	 * @see com.csc.service.FundService#getListTargetByAccountOwnerId(java.lang.String)
	 * @return List<TargetAccount>
	 */
	@Override
	public List<TargetAccount> getListTargetByAccountOwnerId(String id) {
		return targetAccountDao.getListTargetByAccountOwnerId(id);
	}

	/**
	 * add target account in to account owner
	 * @param idAccountOwner, idAccountTarget, name
	 * @return StateResult
	 */
	@Override
	@Transactional
	public StateResult addTargetAccount(String idAccountOwner,
			String idAccountTarget, String name) {
		StateResult result = new StateResult();
		
		// check account
		Account accountOwner = accountDao.getAccountById(idAccountOwner);
		Account accountTarget = accountDao.getAccountById(idAccountTarget);
		if (accountTarget == null || accountOwner == null) {
			result.setState(false);
			result.setMessage("Account not fund!");
			return result;
		}
		
		// add targetAccount in TargetAccount
		return targetAccountDao.addTargetAccount(idAccountOwner, idAccountTarget, name);
	}

	/**
	 * modify targetAccount
	 * @param idtargetAccount, idAccountTarget, name
	 * @return StateResult
	 */
	@Override
	@Transactional
	public StateResult modifyTarget(String id, String idAccountTarget,
			String name) {
		StateResult result = new StateResult();
		
		Account account = accountDao.getAccountById(idAccountTarget);
		if (account == null) {
			result.setState(false);
			result.setMessage("Account not found!");
			return result;
		}
		
		return targetAccountDao.modifyTarget(id, idAccountTarget, name);
	}

	/**
	 * delete targetAccount
	 * @param idtarget
	 */
	@Override
	@Transactional
	public StateResult deleteTarget(String id) {
		return targetAccountDao.deleteTarget(id);
	}

	/**
	 * ignore transaction by idtransaction
	 * @param idTransaction
	 */
	@Override
	@Transactional
	public StateResult ignoreTransaction(long idTransaction) {
		TransactionHistory tran = transactionDao.getTransaction(idTransaction);
		if (tran == null) {
			StateResult result = new StateResult(false, "Error. Transaction not found!");
			return result;
		} else {
			return transactionDao.changeStateTransaction(tran, State.DISABLE);
		}
	}

	/**
	 * get infomation in home page admin
	 * count transaction new state. count change state account
	 * @return bean AdminReponse
	 */
	@Override
	@Transactional
	public AdminReponse getHomeAdminInfo() {
		AdminReponse result = new AdminReponse();
		
		result.setCountverifyTransaction(adminInfoDao.getCountVerifyTransaction());
		result.setCountChangeStateNewToActive(adminInfoDao.getCountAccountNew());
		result.setCountChangeStateDisableToRemove(adminInfoDao.getCountAccountDisable());
		
		return result;
	}
	
	/**
	 * check state and money account
	 * @param account
	 * @param amount
	 * @return
	 */
	private StateResult checkAccountSource(Account account, BigDecimal amount) {
		StateResult result = new StateResult();
		
		// if availableAmount - sendAmount < 50000 return false;
		try {
			BigDecimal money = account.getAvailableAmount().subtract(amount);
			if (money.compareTo(BigDecimal.valueOf(50000)) < 0) {
				result.setState(false);
				result.setMessage("The amount in the account is not enough to transfer");
				return result;
			}
			
			// Check state sendAccount
			if (account.getState().getIdState() != State.ACTIVE) {
				result.setState(false);
				result.setMessage("Account is not ACTIVE");
				return result;
			}
		} catch (NullPointerException e) {
			result.setMessage("Account not found!");
			return result;
		}
		
		result.setState(true);
		return result;
	}

}

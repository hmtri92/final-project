package com.csc.dao;

import java.util.List;

import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;

/**
 * 
 * @author MinhTri
 *
 */
public interface ITargetAccountDAO {

	/**
	 * get list targetAccount by id account owner
	 * @param id
	 * @return List<TargetAccount>
	 */
	List<TargetAccount> getListTargetByAccountOwnerId(String id);
	
	/**
	 * add new targetAccount
	 * @param idAccountOwner
	 * @param idAccountTarget
	 * @param name
	 * @return StateResult
	 */
	StateResult addTargetAccount(String idAccountOwner, String idAccountTarget, String name);
	
	/**
	 * modify target by idTarget, modify accountTarget and name, not change accountOwner
	 * @param id
	 * @param idAccountTarget
	 * @param name
	 * @return StateResult
	 */
	StateResult modifyTarget(String id, String idAccountTarget, String name);
	
	/**
	 * delete targetAccount by id
	 * @param id
	 * @return
	 */
	StateResult deleteTarget(String id);
	
	/**
	 * get targetAccount
	 * @param idOwner
	 * @param idTarget
	 * @return StateResult
	 */
	TargetAccount getTargetAccountByOwnerAndTarget(String idOwner, String idTarget);
	
	/**
	 * get targetAccount by id
	 * @param id
	 * @return StateResult
	 */
	TargetAccount getTargetAccountById(String id);
}

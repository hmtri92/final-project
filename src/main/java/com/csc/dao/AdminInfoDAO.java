package com.csc.dao;

/**
 * 
 * @author MinhTri
 *
 */
public interface AdminInfoDAO {

	/**
	 * count transaction have new state
	 * @return count
	 */
	int getCountVerifyTransaction();
	
	/**
	 * count account have new state
	 * @return count account
	 */
	int getCountAccountNew();
	
	/**
	 * count account have disable account
	 * @return count
	 */
	int getCountAccountDisable();
}

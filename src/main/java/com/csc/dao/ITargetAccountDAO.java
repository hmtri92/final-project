package com.csc.dao;

import java.util.List;

import com.csc.entities.TargetAccount;

public interface ITargetAccountDAO {

	List<TargetAccount> getListTargetByAccountOwnerId(String id);
}

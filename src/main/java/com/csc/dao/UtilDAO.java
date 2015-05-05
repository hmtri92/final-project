package com.csc.dao;

import javax.persistence.EntityManager;

public interface UtilDAO {
	public boolean addEntity(Object obj);

	public boolean updateEntity(Object obj);
	
	public boolean removeEntity(Object obj);
	 
}

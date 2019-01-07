package com.uossene.dao.interfaces;

import javax.persistence.EntityManager;

public interface GenericDao <T> {
	
	public EntityManager getEntityManager();
	public void setEntityManager(EntityManager entityManager);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public T create(T t );
	/**
	 * 
	 * @param t
	 */
	public void delete(T t );
	/**
	 * 
	 * @param t
	 * @return
	 */
	public T update(T t );
	/**
	 * 
	 * @param id
	 * @return
	 */
	public T getById(Integer id );
}

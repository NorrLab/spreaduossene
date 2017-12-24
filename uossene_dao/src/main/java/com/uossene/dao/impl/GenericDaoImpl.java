package com.uossene.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uossene.dao.Utils;
import com.uossene.dao.interfaces.GenericDao;

public class GenericDaoImpl<T> implements GenericDao<T>{
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected Class<T> type;
	
	
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		super();
		 type = (Class<T>) Utils.gerGenericClass(getClass());
	}

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return this.entityManager;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public T create(T t) {
		entityManager.persist(t);
		return t;
	}

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void delete(T t) {
		entityManager.remove(t);
		
	}

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public T update(T t) {
		entityManager.merge(t);
		return t;
	}

	@Override
	public T getById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(type, id);
	}

}

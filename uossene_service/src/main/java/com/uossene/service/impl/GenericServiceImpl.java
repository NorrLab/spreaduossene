package com.uossene.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.uossene.dao.interfaces.GenericDao;
import com.uossene.service.interfaces.GenericService;

public  abstract class GenericServiceImpl<T> implements GenericService<T> {

	public GenericServiceImpl()
	{
	
	}
	
	@Transactional 
	@Override
	public T create(@RequestBody T t) {
		// TODO Auto-generated method stub
		return getDao().create(t);
	}

	@Override
	public void delete(T t) {
		getDao().delete(t);
		
	}

	@Override
	public T update(T t) {
		getDao().update(t);
		return t;
	}

	@Override
	public T getById(Integer id) {
		return getDao().getById(id);
	}
	/**
	 * Renvoie le DAO associé au service.
	 * @return le DAO associé au service.
	 */
	public abstract GenericDao<T> getDao();
}

package com.uossene.service.interfaces;

import java.util.List;

public interface GenericService<T> {
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
	/**
	 * 
	 * @return
	 */
	public List<T> getAll();
}

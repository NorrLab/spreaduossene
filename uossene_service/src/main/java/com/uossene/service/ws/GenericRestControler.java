package com.uossene.service.ws;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uossene.service.interfaces.GenericService;

@CrossOrigin
public abstract class GenericRestControler<T> {
	
	public abstract GenericService<T> getService();
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public T create( T t ) throws ServerException
	{
		
		return getService().create(t);
		
	}
	/**
	 * 
	 * @param t
	 */
	@RequestMapping(method=RequestMethod.DELETE)
	public void delete(T t )
	{
		 getService().delete(t);
	}
	/**
	 * 
	 * @param t
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public T update(T t ) throws ServerException
	{
		return  getService().update(t);
		
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public T getById(Integer id )
	{
		return  getService().getById(id);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T> getAll() {
		return getService().getAll();
	}
}

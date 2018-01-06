package com.uossene.dao.interfaces;

import java.util.List;

import com.uossene.dao.entity.UosUser;
import com.uossene.dao.exceptions.UosUserLoginException;

public interface UosUserDao extends GenericDao<UosUser>{
	
	public UosUser userLogin(String userEmail,String userPassword) throws UosUserLoginException;
//	public UosUser userLogin(String userEmail,String userPassword);
	public List<UosUser> getAllUsers() ;
	public List<UosUser> getAllUsersWithComment();
}

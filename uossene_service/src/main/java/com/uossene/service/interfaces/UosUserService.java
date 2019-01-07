package com.uossene.service.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.uossene.dao.entity.UosUser;
import com.uossene.dao.exceptions.UosUserLoginException;

public interface UosUserService extends GenericService<UosUser>{
	
	public UosUser userLogin(String userEmail,String userPassword) throws UosUserLoginException;
	public List<UosUser> getAllUsers(); //throws UosUserLoginException;
	public UosUser register(UosUser user, String repeatedPassword) throws UosUserLoginException;
	public String checkEmailPassword(String userEmail, String userPassword) throws UosUserLoginException;
	public List<UosUser> getAllUsersWithComment() throws UosUserLoginException;
	public List<UosUser> validateComment(Integer userId,String comment)throws UosUserLoginException;
}

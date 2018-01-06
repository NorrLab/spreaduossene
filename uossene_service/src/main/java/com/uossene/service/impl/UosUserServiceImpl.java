package com.uossene.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.uossene.dao.entity.Comment;
import com.uossene.dao.entity.UosUser;
import com.uossene.dao.exceptions.UosUserLoginException;
import com.uossene.dao.interfaces.CommentDao;
import com.uossene.dao.interfaces.GenericDao;
import com.uossene.dao.interfaces.UosUserDao;
import com.uossene.service.interfaces.UosUserService;

@Service("uosUserService")
public class UosUserServiceImpl extends GenericServiceImpl<UosUser> implements UosUserService{
	
	@Autowired
	private UosUserDao uosUserDao;
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<UosUser> getAll() {
		return uosUserDao.getAllUsers();
	}

	@Override
	public UosUser userLogin(String userEmail, String userPassword) throws UosUserLoginException {
		return uosUserDao.userLogin(userEmail, userPassword);
	}

	@Override
	public GenericDao<UosUser> getDao() {
		return this.uosUserDao;
	}

	@Override
	public List<UosUser> getAllUsers() {
		// TODO Auto-generated method stub
		return uosUserDao.getAllUsers();
	}

	@Override
	public UosUser register(UosUser user, String repeatedPassword) throws UosUserLoginException {
		
		if(!checkUser(user, repeatedPassword))
			throw new UosUserLoginException();
			
		return uosUserDao.create(user);
	}

	private boolean checkUser(UosUser user, String repeatedPassword) {
		
		if(StringUtils.isEmpty(user.getUserEmail()))
			return false;
		
		if(StringUtils.isEmpty(user.getUserCompany()))
			return false;
		if(StringUtils.isEmpty(user.getUserGrade()))
			return false;
		if(StringUtils.isEmpty(user.getUserGrade()))
			return false;
		if(StringUtils.isEmpty(user.getUserFirstName()))
			return false;
		if(StringUtils.isEmpty(user.getUserLastName()))
			return false;
		if(user.getUserPassWord()!= repeatedPassword)
			return false;
		
		return true;
	}

	@Override
	public String checkEmailPassword(String userEmail, String userPassword) throws UosUserLoginException 
	{
		if(StringUtils.isEmpty(userEmail) )
			return "Email can't be empty or null!!!";
		if( StringUtils.isEmpty(userPassword))
			return "Password can't be empty or null!!!";
		if(!EmailValidator.getInstance().isValid(userEmail))
			return "Email not valide!!!";
		return "";
	}

	@Override
	public List<UosUser> getAllUsersWithComment() throws UosUserLoginException {
		return uosUserDao.getAllUsersWithComment();
	}

	@Override
//	@Transactional(propagation = Propagation.MANDATORY)
	public List<UosUser> validateComment(Integer userId, String comment) throws UosUserLoginException {
		UosUser user = uosUserDao.getById(userId);
		Comment message = new Comment();
		message.setUserComment(comment);
		message.setDateComment(new Date());
		message = commentDao.create(message);
		user.setUserComment(message);
		uosUserDao.update(user);
		return null;
	}
	

}

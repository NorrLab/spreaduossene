package com.uossene.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.uossene.dao.entity.UosUser;
import com.uossene.dao.exceptions.UosUserLoginException;
import com.uossene.dao.interfaces.UosUserDao;

@Repository("uosUserDao")
public class UosUserDaoImpl extends GenericDaoImpl<UosUser> implements UosUserDao{
	
	private static String SELECT_BY_LOGIN = "FROM UosUser m WHERE userEmail = :userEmail AND userPassWord = :userPassWord";
	private static String SELECT_ALL = "FROM UosUser ORDER BY userId";
	private static String SELECT_ALL_WITH_COMMENTS = "FROM UosUser WHERE userComment <> NULL ORDER BY userId";
	
	@Override
	public UosUser userLogin(String userEmail, String userPassWord) throws UosUserLoginException {
		TypedQuery<UosUser>query = entityManager.createQuery(SELECT_BY_LOGIN, UosUser.class);
		query.setParameter("userEmail", userEmail);
		query.setParameter("userPassWord", userPassWord);
		return  query.getSingleResult();
	}

	@Override
	public List<UosUser> getAllUsers() {
		return entityManager.createQuery(SELECT_ALL, UosUser.class).getResultList();
	}
	
	@Override
	public List<UosUser> getAllUsersWithComment() {
		return entityManager.createQuery(SELECT_ALL_WITH_COMMENTS, UosUser.class).getResultList();
	}

}

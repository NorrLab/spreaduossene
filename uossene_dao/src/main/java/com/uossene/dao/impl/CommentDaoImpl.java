package com.uossene.dao.impl;

import org.springframework.stereotype.Repository;

import com.uossene.dao.entity.Comment;
import com.uossene.dao.interfaces.CommentDao;

@Repository("commentDao")
public class CommentDaoImpl extends GenericDaoImpl<Comment> implements CommentDao{
	
}

package com.uossene.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uossene.dao.entity.Comment;
import com.uossene.dao.interfaces.CommentDao;
import com.uossene.dao.interfaces.GenericDao;
import com.uossene.service.interfaces.CommentService;

@Service("commentService")
public class CommentServiceImpl extends GenericServiceImpl<Comment> implements CommentService{
	
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericDao<Comment> getDao() {
		return this.commentDao;
	}

}

package com.uossene.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commenId;
	@Column(length = 98)
	private String userComment;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateComment;
	
	
	public Comment() {
		super();
	}


	public Integer getCommenId() {
		return commenId;
	}


	public void setCommenId(Integer commenId) {
		this.commenId = commenId;
	}


	public String getUserComment() {
		return userComment;
	}


	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}


	public Date getDateComment() {
		return dateComment;
	}


	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}
	
	
	//just a comment
}

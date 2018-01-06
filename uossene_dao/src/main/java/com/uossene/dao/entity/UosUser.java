package com.uossene.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UosUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userFirstName;
	private String userLastName;
	private String userGrade;
	private String userCompany;
	
	@Column(unique = true)
	private String userEmail;
	private String userPassWord;
	private String userPictureUrl;
	
	@OneToOne
	private Comment userComment;


	public UosUser() {
		super();
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getUserGrade() {
		return userGrade;
	}


	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}


	public String getUserCompany() {
		return userCompany;
	}


	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@JsonIgnore
	public String getUserPassWord() {
		return userPassWord;
	}


	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}


	public String getUserPictureUrl() {
		return userPictureUrl;
	}


	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}


	public Comment getUserComment() {
		return userComment;
	}


	public void setUserComment(Comment userComment) {
		this.userComment = userComment;
	}
	
	
	
}

package com.uossene.dao.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Company implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;
	@Transient
	private String companyBase64;
	private String companyPictureUrl;
	private String companyName;
	private String companyFullName;
	private String city;
	private String country;
	
	public Company() 
	{

	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyBase64() {
		return companyBase64;
	}

	public void setCompanyBase64(String companyBase64) {
		this.companyBase64 = companyBase64;
	}

	public String getCompanyPictureUrl() {
		return companyPictureUrl;
	}

	public void setCompanyPictureUrl(String companyPictureUrl) {
		this.companyPictureUrl = companyPictureUrl;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompanyFullName() {
		return companyFullName;
	}

	public void setCompanyFullName(String companyFullName) {
		this.companyFullName = companyFullName;
	}
	
	
}

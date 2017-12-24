package com.uossene.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Mission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer missionId;
	private String missiontitle;
	private String missionIntro;
	private String missionDuration;
	private String missionGrade;
	private String missionDetail;
	private String missionTaskDone;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date missionStartDate;
	private Date missionEndDate;
	
	@OneToOne
	private Company company;
	 
	public Mission() 
	{
		
	}

	public Integer getMissionId() {
		return missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

	public String getMissiontitle() {
		return missiontitle;
	}

	public void setMissiontitle(String missiontitle) {
		this.missiontitle = missiontitle;
	}

	public String getMissionIntro() {
		return missionIntro;
	}

	public void setMissionIntro(String missionIntro) {
		this.missionIntro = missionIntro;
	}

	public String getMissionDuration() {
		return missionDuration;
	}

	public void setMissionDuration(String missionDuration) {
		this.missionDuration = missionDuration;
	}

	public String getMissionGrade() {
		return missionGrade;
	}

	public void setMissionGrade(String missionGrade) {
		this.missionGrade = missionGrade;
	}

	public String getMissionDetail() {
		return missionDetail;
	}

	public void setMissionDetail(String missionDetail) {
		this.missionDetail = missionDetail;
	}

	public String getMissionTaskDone() {
		return missionTaskDone;
	}

	public void setMissionTaskDone(String missionTaskDone) {
		this.missionTaskDone = missionTaskDone;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getMissionStartDate() {
		return missionStartDate;
	}

	public void setMissionStartDate(Date missionStartDate) {
		this.missionStartDate = missionStartDate;
	}

	public Date getMissionEndDate() {
		return missionEndDate;
	}

	public void setMissionEndDate(Date missionEndDate) {
		this.missionEndDate = missionEndDate;
	}

}

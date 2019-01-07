package com.uossene.dao.interfaces;

import java.util.List;

import com.uossene.dao.entity.Company;

public interface CompanyDao extends GenericDao<Company>{
	
	public List<Company> getCompanyByCity(String city);
	public Company getCompanyByName(String name);
	public Company getCompanyByMission(Integer missionId);
}

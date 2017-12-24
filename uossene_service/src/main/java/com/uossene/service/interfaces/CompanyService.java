package com.uossene.service.interfaces;

import java.util.List;

import com.uossene.dao.entity.Company;

public interface CompanyService extends GenericService<Company> {
	public List<Company> getCompanyByCity(String city);
	public Company getCompanyByName(String name);
	public Company getCompanyByMission(Integer missionId);
}

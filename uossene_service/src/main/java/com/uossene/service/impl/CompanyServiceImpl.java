package com.uossene.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uossene.dao.entity.Company;
import com.uossene.dao.interfaces.CompanyDao;
import com.uossene.dao.interfaces.GenericDao;
import com.uossene.service.interfaces.CompanyService;

@Service("companyServcive")
public class CompanyServiceImpl extends GenericServiceImpl<Company> implements CompanyService{
	
	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public List<Company> getAll() {
		return null;
	}

	@Override
	public GenericDao<Company> getDao() {
		// TODO Auto-generated method stub
		return companyDao;
	}

	@Override
	public List<Company> getCompanyByCity(String city) {
		return companyDao.getCompanyByCity(city);
	}

	@Override
	public Company getCompanyByName(String name) {
		return companyDao.getCompanyByName(name);
	}

	@Override
	public Company getCompanyByMission(Integer missionId) {
		return companyDao.getCompanyByMission(missionId);
	}
	
	

}

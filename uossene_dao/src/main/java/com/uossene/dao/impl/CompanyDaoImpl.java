package com.uossene.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.uossene.dao.entity.Company;
import com.uossene.dao.interfaces.CompanyDao;

@Repository("companyDao")
public class CompanyDaoImpl extends GenericDaoImpl<Company> implements CompanyDao{
	private static String SELECT_BY_CITY= " FROM Company WHERE city LIKE '% :city %'";
	private static String SELECT_BY_NAME= " FROM Company WHERE companyName LIKE '% :name %'";
	private static String SELECT_BY_MISSION = "FROM company WHERE missionid = :missionId";	
	@Override
	public List<Company> getCompanyByCity(String city) {
		TypedQuery<Company> query = entityManager.createQuery(SELECT_BY_CITY,Company.class);
		query.setParameter("city", city);
		return query.getResultList();
	}

	@Override
	public Company getCompanyByName(String name) {
		TypedQuery<Company> query = entityManager.createQuery(SELECT_BY_NAME,Company.class);
		query.setParameter("city", name);
		return query.getSingleResult();
	}

	@Override
	public Company getCompanyByMission(Integer missionId) {
		TypedQuery<Company> query = entityManager.createQuery(SELECT_BY_MISSION,Company.class);
		query.setParameter("missionId", missionId);
		return query.getSingleResult();
	}

}

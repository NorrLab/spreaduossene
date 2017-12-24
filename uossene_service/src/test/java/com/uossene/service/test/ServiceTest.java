package com.uossene.service.test;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uossene.dao.entity.Company;
import com.uossene.dao.entity.Mission;
import com.uossene.service.interfaces.CompanyService;
import com.uossene.service.interfaces.MissionService;
 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class ServiceTest 
{
	@Autowired
	private MissionService missionService;
	@Autowired
	private CompanyService companyService;
	
//	@Test
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	@Rollback(value=false)
	public void test1() throws Exception
	{
		Mission mission = new Mission();
		mission.setMissiontitle("Testing Service");
		mission.setMissionStartDate(new Date());
		missionService.create(mission);
	}
	
	@Test
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Rollback(value=false)
	public void test2()
	{	
		Mission inMission = missionService.getById(1);
		
		Company company = new Company();
		company.setCity("Clermont-Ferrand");
		company.setCompanyPictureUrl("img/sncf_infra.jpg");
		company.setCompanyName("SNCF");
		company.setCompanyFullName("Sociéte Nationale des Chemins de Fer");
		companyService.create(company);
		inMission.setCompany(company);
		missionService.update(inMission);
		
//		Mission mission = new Mission();
//		mission.setMissiontitle("Testing Service");
//		mission.setMissionStartDate(new Date());
//		missionService.create(mission);
//		mission.setCompany(company);
	}
	
}

package com.uossene.service.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import com.uossene.dao.entity.UosUser;
import com.uossene.dao.exceptions.UosUserLoginException;
import com.uossene.service.interfaces.CompanyService;
import com.uossene.service.interfaces.MissionService;
import com.uossene.service.interfaces.UosUserService;
 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class ServiceTest 
{
	@Autowired
	private MissionService missionService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private UosUserService uosUserService;
	
	private Logger LOG = Logger.getLogger(getClass().getName());
//	@Test
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	@Rollback(value=false)
	public void test1() throws Exception
	{
		Mission mission = new Mission();
		mission.setMissionTitle("Testing Service");
		mission.setMissionStartDate(new Date());
		missionService.create(mission);
	}
	
//	@Test
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	@Rollback(value=false)
	public void test2()
	{	
		Mission inMission = missionService.getById(4);
		
		Company company = new Company();
		company.setCity("Strasbourg");
		company.setCompanyPictureUrl("img/coe.png");
		company.setCompanyName("COE");
		company.setCompanyWebSite("https://www.coe.int/fr/web/portal/home");
		company.setCompanyFullName("Conseil De l'Europe");
		companyService.create(company);
		inMission.setCompany(company);
		missionService.update(inMission);
		
//		Mission mission = new Mission();
//		mission.setMissiontitle("Testing Service");
//		mission.setMissionStartDate(new Date());
//		missionService.create(mission);
//		mission.setCompany(company);
	}
	
//	@Test
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	@Rollback(value = false)
	public void test3()
	{
		Mission mission = missionService.getById(4);
//		Mission mission2 = missionService.getById(2);
//		Mission mission3 = missionService.getById(3);
//		Mission mission4 = missionService.getById(4);
//		
		Date startDate = new Date();

		Date endDate = new Date();
		
		String dateFormat = "dd/MM/yyyy";
		String start = "12/10/2017";
		String end = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		
		try {
			startDate = new SimpleDateFormat(dateFormat, Locale.FRANCE).parse(start);
//			endDate = new SimpleDateFormat(dateFormat, Locale.FRANCE).parse(end);
			LOG.log(Level.INFO, "start:= "+sdf.format(startDate));
//			LOG.log(Level.INFO, "end:= "+sdf.format(endDate));
		}catch (ParseException pe) {
			LOG.log(Level.SEVERE, "parsing Date failed: ", pe);
			pe.printStackTrace();
		}
		mission.setMissionIntro("");
		mission.setMissionGrade("Développeur Java/J2EE");
		mission.setMissionTitle("Développement d'applications web Liferay/AngularJS");
		mission.setMissionStartDate(startDate);
//		mission.setMissionEndDate(endDate);
		mission.setMissionDuration("en cours");
		
		mission.setMissionTaskDone("Maintenance corrective et évolutive sur une app web CRM existante en J2EE Développement en méthode Agile (Scrum) d'une application web en AngularJS et Play! Prise de lead technique côté Front AngularJS Propositions ergonomie/design Intégration continue avec Jenkins et Sonar Suivi de recette et déploiement en production");
		mission.setMissionDetail("Cette mission été effectuée en tant que consultant pour la société Technology&strategy \r\n" + 
				"Dans premier temps j'ai fait de la maintenant évolutive et corrective sur une application web en J2EE. Il s'agissait d'un CRM-ERP utilisant notamment Struts et Hibernate. La technologie de base de donnée était DB2. J'étais d'abord seul pendant 2-3 mois puis d'autres consultants m'ont rejoint.\r\n" + 
				"Avec ces mêmes personnes nous avons ensuite travaillé sur une application web de gestion d'objet connecté. Pour ce second projet, le framework backend Play! (java) nous a été imposé, ainsi que la technologie de base de donnée PostgreSQL. Ayant déjà travaillé avec AngularJS par le passé j'ai proposé ce framework pour le côté client et nous sommes alors parti dessus. J'ai alors naturellement pris le lead technique côté AngularJS Malgré mon penchant pour le Front End, j'ai participé à tous les aspects du projet : Architecture de la base de données, création de Web Service, sécurisation des données, UI/UX, ... Pour le développement nous avons suivi la méthode Agile Scrum Le code était versionné sous Git, et nous utilisions Jenkins et Sonar pour l'intégration continue Pour améliorer la qualité du code j'ai initié mes collègues à Postman pour faire des tests d'intégration et à Karma/Jasmine pour faire des tests unitaires sur Angular");
		
		missionService.update(mission);
	}
	
	@Test
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Rollback(value = false)
	public void testUser()
	{	
//	UosUser user = null;
//		try {
//			user = uosUserService.userLogin("admin@uos.com", "tresor1tx");
//		} catch (UosUserLoginException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		LOG.log(Level.INFO, "user.email:="+user.getUserEmail());
//		LOG.log(Level.INFO, "user.email:="+user.getUserFirstName());
		UosUser user = new UosUser();
		user.setUserCompany("sncf");
		user.setUserEmail("jenn@uos.com");
		user.setUserPassWord("jen");
		user.setUserFirstName("Jen");
		user.setUserGrade("Scrum master");
		user.setUserLastName("Romain");
		user.setUserPictureUrl("img/jenn.jpg");
		
		try {
			uosUserService.register(user, "jen");
		} catch (UosUserLoginException e) {
			
			e.printStackTrace();
		}
		
	}
}

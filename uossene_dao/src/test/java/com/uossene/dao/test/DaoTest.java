package com.uossene.dao.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.core.Logger;
import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import com.uossene.dao.entity.Mission;
import com.uossene.dao.impl.MissionDaoImpl;
import com.uossene.dao.interfaces.MissionDao;

@FixMethodOrder
public class DaoTest {
	
	private static EntityManagerFactory emf;
	private static MissionDao missionDao;
	
//	private static org.jboss.logging.Logger LOG =LoggerFactory.logger(DaoTest.class);
	
	@BeforeClass
	public static void initClass()
	{
		emf = Persistence.createEntityManagerFactory("persistenceUnit");
		missionDao = new MissionDaoImpl();
		
	}
	
	@AfterClass
	public  static void destroyClass()
	{
		emf.close();
	}
	
	@Before
	public  void init()
	{
		EntityManager entityManager = emf.createEntityManager();
		missionDao.setEntityManager(entityManager);
		entityManager.getTransaction().begin();
	}
	
	@After
	public  void destroy()
	{
		missionDao.getEntityManager().getTransaction().commit();
		missionDao.getEntityManager().close();
	}
	
	@Test
	public  void test1()
	{
		Mission mission = new Mission();
//		LOG.info("creatin Mission");
		mission.setMissionDetail("any detail");
		mission.setMissionDuration("9 months");
		mission.setMissionIntro("missoin1 intro");
		mission.setMissionTaskDone("much");
		mission.setMissiontitle("I am rich");
		mission.setMissionStartDate(new Date());
		missionDao.create(mission);
		
	}
}

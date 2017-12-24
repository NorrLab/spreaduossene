package com.uossene.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.uossene.dao.entity.Mission;
import com.uossene.dao.interfaces.MissionDao;

@Repository("missionDao")
public class MissionDaoImpl extends GenericDaoImpl<Mission> implements MissionDao{
	
	private static String SELECT_BY_KEY_WORDS = "FROM Mission m WHERE missionDetail LIKE '% :keyWord %'";
	private static String SELECT_ALL= "FROM Mission ORDER BY missionid";
	
	@Override
	public List<Mission> getAllMissions() {
		TypedQuery<Mission> query = entityManager.createQuery(SELECT_ALL,Mission.class);
		return query.getResultList();
	}

	@Override
	public List<Mission> getMissionsByTechnologyKeyWord(String[] keyWords) {
		List<Mission> missions = new ArrayList<Mission>();
		TypedQuery<Mission> query = entityManager.createQuery(SELECT_BY_KEY_WORDS,Mission.class);
		
		for(String key : keyWords)
		{
			query.setParameter("keyWord", key);
			missions.addAll(query.getResultList());
		}
		return missions;
	}

}

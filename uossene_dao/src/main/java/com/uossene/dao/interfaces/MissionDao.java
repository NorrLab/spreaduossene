package com.uossene.dao.interfaces;

import java.util.List;

import com.uossene.dao.entity.Mission;

public interface MissionDao extends GenericDao<Mission>{
	
	List<Mission> getAllMissions();
	List<Mission> getMissionsByTechnologyKeyWord(String[] keyWords);
	
}

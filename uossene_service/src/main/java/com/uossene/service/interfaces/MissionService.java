package com.uossene.service.interfaces;

import java.util.List;

import com.uossene.dao.entity.Mission;

public interface MissionService extends GenericService<Mission>{
	public List<Mission> getAllMissions();
	public List<Mission> getMissionsByTechnologyKeyWord(String[] keyWords);
}

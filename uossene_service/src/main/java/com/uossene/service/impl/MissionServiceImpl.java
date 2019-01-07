package com.uossene.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uossene.dao.entity.Mission;
import com.uossene.dao.interfaces.GenericDao;
import com.uossene.dao.interfaces.MissionDao;
import com.uossene.service.interfaces.MissionService;

@Service("missionService")
public class MissionServiceImpl extends GenericServiceImpl<Mission> implements MissionService{
	
	@Autowired
	private MissionDao missionDao;
	
	@Override
	public List<Mission> getAllMissions() {
		
		return missionDao.getAllMissions();
	}

	@Override
	public List<Mission> getMissionsByTechnologyKeyWord(String[] keyWords) {
		// TODO Auto-generated method stub
		return missionDao.getMissionsByTechnologyKeyWord(keyWords);
	}
	
	@Override
	public List<Mission> getAll() {
		return missionDao.getAllMissions();
	}
	
	@Override
	public GenericDao<Mission> getDao() {
		return this.missionDao ;
	}

	

}

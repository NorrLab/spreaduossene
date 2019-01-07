package com.uossene.service.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uossene.dao.entity.Mission;
import com.uossene.service.interfaces.GenericService;
import com.uossene.service.interfaces.MissionService;

@RestController
@RequestMapping(value="/mission")
public class MissionRestController extends GenericRestController<Mission>{
	
	@Autowired
	private MissionService missionService;
	
	@Override
	public GenericService<Mission> getService()
	{
		return this.missionService;
	}

	public MissionRestController() 
	{
		
	}
	
	@RequestMapping(value="/all/")
	public List<Mission> getAllMissions()
	{
		return missionService.getAllMissions();
		
	}
	
	@RequestMapping(value="/saerch-mission/{keyWords}")
	public List<Mission> getMissionsByTechnologyKeyWord(@PathVariable String keyWords)
	{	
		String[] keyWord = keyWords.split(",");
		
		return missionService.getMissionsByTechnologyKeyWord(keyWord);
		
	}
	
}

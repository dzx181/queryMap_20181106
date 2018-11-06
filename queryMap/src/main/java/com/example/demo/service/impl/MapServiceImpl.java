package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MapMapper;
import com.example.demo.service.MapService;
/**
 * @author dengzhenxiang
 * @Date 2018/11/6 21:10
 * @Version
 */
@Service
public class MapServiceImpl implements MapService {

	@Autowired
	private MapMapper mapMapper;
	
	@Override
	public List<String> queryStationName() {
		
		return mapMapper.queryStationName();
	}
	
	public List<String> queryLineName() {
		
		return mapMapper.queryLineName();
	}

	public MapMapper getMapMapper() {
		return mapMapper;
	}

	public void setMapMapper(MapMapper mapMapper) {
		this.mapMapper = mapMapper;
	}

	
	
	
}

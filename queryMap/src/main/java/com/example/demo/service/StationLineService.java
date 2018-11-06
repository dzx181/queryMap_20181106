package com.example.demo.service;


import com.example.demo.entity.Line;
import com.example.demo.entity.Station;

import java.util.List;
/**
 * @author dengzhenxiang
 * @Date 2018/11/6 21:10
 * @Version
 */
public interface StationLineService {
	int insertStation(List<Station> stationList);
	int insertLine(List<Line> lineList );
}

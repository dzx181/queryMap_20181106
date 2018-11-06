package com.example.demo.service.impl;

import com.example.demo.dao.*;
import com.example.demo.entity.*;
import com.example.demo.service.StationLineService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author dengzhenxiang
 * @Date 2018/11/6 21:10
 * @Version
 */
@Service
public class StationLineServiceImpl implements StationLineService {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private StationMapper stationMapper;

	@Autowired
	private BusLineMapper busLineMapper;

	@Autowired
	private BoundMapper boundMapper;

	@Autowired
	private LineMapper lineMapper;

	@Autowired
	private ViaStopMapper viaStopMapper;

	@Autowired
	private LocationMapper locationMapper;


	@Override
	public int insertStation(List<Station> stationList) {
		Station station = null;
		BusLines busLines = null;
		ArrayList<Station> arrayList = (ArrayList<Station>) stationList;
		for (int i = 0; i < arrayList.size() && arrayList.size()!=0; i++) {
			//装配station
			station = new Station();
			station.setId(arrayList.get(i).getId());
			station.setName(arrayList.get(i).getName());
			station.setCitycode(arrayList.get(i).getCitycode());
			station.setAdcode(arrayList.get(i).getAdcode());
			station.setLocation(arrayList.get(i).getLocation());
			stationMapper.insertStation(station);

			//装配BusLine
			int busLineSize= arrayList.get(i).getBuslines().size();
			for (int j = 0; j < busLineSize && arrayList.get(i).getBuslines().size()!=0 ; j++) {
				busLines = new BusLines();
				busLines.setId(arrayList.get(i).getBuslines().get(j).getId());
				busLines.setStart_stop(arrayList.get(i).getBuslines().get(j).getStart_stop());
				busLines.setEnd_stop(arrayList.get(i).getBuslines().get(j).getEnd_stop());
				busLines.setLocation(arrayList.get(i).getBuslines().get(j).getLocation());
				busLines.setStationID(arrayList.get(i).getId());
				busLines.setName(arrayList.get(i).getName());
				busLineMapper.insertBusLine(busLines);

			}

			logger.info("站台第"+i+"轮装配完毕");

		}
		return 0;
	}

	@Override
	public int insertLine(List<Line> lineList) {
		Line line = null;
		Location location = null;
		ViaStop viaStop = null;
		Bounds bounds = null;
		ArrayList<Line> arrayList = (ArrayList<Line>) lineList;
		for (int i = 0; i < arrayList.size() && arrayList.size()!=0; i++) {
			line = new Line();
			//装配line
			line.setId(lineList.get(i).getId());
			line.setBasic_price(lineList.get(i).getBasic_price());
			line.setTotal_price(lineList.get(i).getTotal_price());
			line.setCitycode(lineList.get(i).getCitycode());
			line.setCompany(lineList.get(i).getCompany());
			line.setDistance(lineList.get(i).getDistance());
			line.setEnd_stop(lineList.get(i).getEnd_stop());
			line.setStart_stop(lineList.get(i).getStart_stop());
			line.setName(lineList.get(i).getName());
			line.setType(lineList.get(i).getType());
			lineMapper.insertLine(line);

			//装配Location
			int pathSize = lineList.get(i).getPath().size();
			for (int j = 0; j < pathSize && pathSize!=0; j++) {
				location = new Location();
				location.setLat(lineList.get(i).getPath().get(j).getLat());
				location.setLng(lineList.get(i).getPath().get(j).getLng());
				location.setBusLineID(lineList.get(i).getId());
				locationMapper.insertLocation(location);
			}

			//装配ViaStop
			int viaStopSize = lineList.get(i).getVia_stops().size();
			for (int z = 0; z < viaStopSize && viaStopSize!=0; z++) {
				viaStop = new ViaStop();
				viaStop.setId(lineList.get(i).getVia_stops().get(z).getId());
				viaStop.setLocation(lineList.get(i).getVia_stops().get(z).getLocation());
				viaStop.setName(lineList.get(i).getVia_stops().get(z).getName());
				viaStop.setSequence(lineList.get(i).getVia_stops().get(z).getSequence());
				viaStop.setBusLineID(lineList.get(i).getId());
				viaStopMapper.insertViaStop(viaStop);
			}

			//装配Bounds
			bounds = new Bounds();
			bounds.setMc(lineList.get(i).getBounds().getMc());
			bounds.setXb(lineList.get(i).getBounds().getXb());
			bounds.setNortheast(lineList.get(i).getBounds().getNortheast());
			bounds.setSouthwest(lineList.get(i).getBounds().getSouthwest());
			bounds.setBusLineID(lineList.get(i).getId());
			boundMapper.insertBound(bounds);

			logger.info("线路第"+i+"轮装配完毕");

			}


		return 0;
	}
}

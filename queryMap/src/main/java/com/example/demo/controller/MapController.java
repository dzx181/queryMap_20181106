package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.TruncateMapper;
import com.example.demo.service.StationLineService;
import com.example.demo.service.TruncateTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Line;
import com.example.demo.entity.Station;
import com.example.demo.service.MapService;

/**
 * 根据数据库深圳市所有的公交站点名和公交线路名
 * 从高德地图上其详细信息
 *
 * @author dengzhenxiang zhaohejia
 * @Date 2018/11/6 15:16
 * @Version
 */
@Controller
public class MapController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MapService mapService;

	@Autowired
	private StationLineService stationLineService;

	@Autowired
	private TruncateTableService truncateTableService;
	/**
	 * 站点界面
	 *
	 * @return
	 */
	@RequestMapping("/gostation")
	public String getMap() {
		return "/station";
	}

	/**
	 * 线路界面
	 *
	 * @return
	 */
	@RequestMapping("/goline")
	public String geta() {
		return "/line";
	}


	/**
	 * 获取所有的站点名
	 *
	 * @return
	 */
	@GetMapping("/querySN")
	@ResponseBody
	public List<String> queryStationName() {
		logger.info("to query station name ......");
		List<String> stationNames = mapService.queryStationName();
		logger.info("stationName---->" + stationNames.size());
		return stationNames;
	}


	/**
	 * 获取所有站点信息，并转配入库
	 *
	 * @param sins
	 * @return
	 */
	@PostMapping("/getstationinfo")
	@ResponseBody
	public String getStationInfo(@RequestBody List<Station> sins) {
		logger.info("getStationInfo---------------------------------------->" + sins);
		Long sec1 = System.currentTimeMillis();
		stationLineService.insertStation(sins);
		Long sec2 = System.currentTimeMillis();
		logger.info("站台装配完成，耗时" + (sec2 - sec1) + "毫秒");
		return "0";
	}


	/**
	 * 获取所有的线路名
	 *
	 * @return
	 */
	@GetMapping("/queryLE")
	@ResponseBody
	public List<String> queryLineName() {
		logger.info("to query line name ......");
		List<String> lineNames = mapService.queryLineName();
		logger.info("lineNames---->" + lineNames);
		return lineNames;
	}

	/**
	 * 获取所有线路信息转配入库
	 * 获取线路详细信息
	 *
	 * @param lines
	 * @return
	 */
	@PostMapping("/getlineinfo")
	@ResponseBody
	public String getLineinfo(@RequestBody List<Line> lines) {
		logger.info("getLineinfo---------------------------------------->" + lines);
		Long sec1 = System.currentTimeMillis();
		stationLineService.insertLine(lines);
		Long sec2 = System.currentTimeMillis();
		logger.info("线路装配完成，耗时" + (sec2 - sec1) + "毫秒");

		return "0";
	}

	/**
	 * 清空表的方法,num为1,清空以bus开头的表，num为2清空以line开头的表
	 * 如需删除特定的表，请到until包下修改
	 * @return
	 */
	@GetMapping("/truncate/{num}")
	@ResponseBody
	public String truncateTable(@PathVariable Integer num){
		ArrayList<String> tableNameList = (ArrayList<String>) truncateTableService.tableNameList(num);
		int flag = truncateTableService.truncateTable(tableNameList);
		return flag > 0 ? "truncate success": "truncate error";
	}

	public MapService getMapService() {
		return mapService;
	}

	public void setMapService(MapService mapService) {
		this.mapService = mapService;
	}

}

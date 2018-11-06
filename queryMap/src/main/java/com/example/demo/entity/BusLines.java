package com.example.demo.entity;
/**
 * 站点所经过的公交线路信息
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusLines {
	
	//公交线路id，该id是唯一标识
	private String id;

	//公交线路名称
	private String name;

	//公交线路途经此站的经纬度
	private Location location;

	//首发站
	private String start_stop;

	//终点站
	private String end_stop;
	
	//存储StationID
	private String stationID;

}

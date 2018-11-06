package com.example.demo.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 高德获取公交车路线
 * @author zhaohejia
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Line {
	
	//公交线路id，该id是唯一标识
	private String id;
	//公交线路名称
	private String name;
	//公交线路经纬度
	private List<Location> path;
	//公交类型列表
	private String type;
	//公交线路所在城市的城市编码
	private String citycode;
	//首发站
	private String start_stop;
	//终点站
	private String end_stop;
	//所属公交公司
	private String company;
	//全程距离，单位：千米
	private String distance;
	//首班车时间
	private Object stime;
	//末班车时间
	private Object etime;
	//起步票价，单位：元
	private String basic_price;
	//全程票价，单位：元
	private String total_price;
	//此公交路线的地理范围
	private Bounds bounds;
	//途径站，包括首发站和终点站
	private List<ViaStop> via_stops;
}

package com.example.demo.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 高德获取公交站点
 * @author zhaohejia
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station {
	
	//公交站点id，该id是唯一标识
	private String id;
	//公交站点名称
	private String name;	
	//区域编码
	private String adcode;	
	//城市编码
	private String citycode;	
	//公交站点经纬度
	private Location location;
	//途经此站点的公交路线列表
	private List<BusLines> buslines;
}

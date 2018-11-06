package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 经纬度位置信息
 * @author zhaohejia
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
	private String N; 
	private String O;
	private String lat;
	private String lng;
	private String busLineID;
}

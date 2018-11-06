package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公交车途径站，包括首发站和终点站
 * @author zhaohejia
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaStop {
	
	private  String id;
	//
	private  Location location;
	//
	private  String name;
	//
	private  String sequence;
	//
	private String busLineID;

}

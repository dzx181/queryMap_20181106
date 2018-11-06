package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公交路线的地理范围信息
 * @author zhaohejia
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bounds {
	
	private String CLASS_NAME;

	private Location mc;

	private Location Xb;

	private Location southwest;

	private Location northeast;

	private String busLineID;
}

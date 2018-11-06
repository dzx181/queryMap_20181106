package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
/**
 * @author dengzhenxiang
 * @Date 2018/11/6 21:10
 * @Version
 */
@Mapper
public interface MapMapper {

	List<String> queryStationName();
	
	List<String> queryLineName();
}

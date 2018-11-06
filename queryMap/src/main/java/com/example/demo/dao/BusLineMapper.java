package com.example.demo.dao;

import com.example.demo.entity.BusLines;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author dengzhenxiang
 * @Date 2018/11/6 21:10
 * @Version
 */
@Mapper
public interface BusLineMapper {
	int insertBusLine(BusLines buslines);
}

package com.example.demo.dao;

import com.example.demo.entity.Line;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @author dengzhenxiang
 * @Date 2018/11/6 21:10
 * @Version
 */
@Mapper
public interface LineMapper {
	int insertLine(Line lineList);
}

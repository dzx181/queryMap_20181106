package com.example.demo.dao;

import com.example.demo.entity.TableName;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dengzhenxiang
 * @Date 2018/11/6 21:10
 * @Version
 */

@Mapper
public interface TruncateMapper {
	int truncateTable(TableName tableNames);
}

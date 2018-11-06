package com.example.demo.service;

import java.util.List;

/**
 * @author dengzhenxiang
 * @Date 2018/11/6 21:10
 * @Version
 */
public interface TruncateTableService {
	int truncateTable(List<String> tableNames);
	List tableNameList(Integer flag);
}

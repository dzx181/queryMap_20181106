package com.example.demo.service.impl;

import com.example.demo.dao.TruncateMapper;
import com.example.demo.entity.TableName;
import com.example.demo.service.TruncateTableService;
import com.example.demo.until.TableNameConst;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * 清空表操作
 * @author dengzhenxiang
 * @Date 2018/11/6 16:58
 * @Version
 *
 */
@Service
public class TruncateTableServiceImpl implements TruncateTableService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TruncateMapper truncateMapper;

	@Override
	public int truncateTable(List<String> tableNames) {
		int flag = 0;
		TableName tableName = null;
		for (int i = 0; i < tableNames.size() && tableNames.size()!=0; i++) {
			tableName = new TableName();
			tableName.setPrefixWithBusAndLine(tableNames.get(i));
			truncateMapper.truncateTable(tableName);
			flag = 1;
			logger.info("清空"+tableNames.get(i)+"表");
		}

		return flag;
	}

	@Override
	public List tableNameList(Integer flag) {
		if (flag == 1){
			List<String > list = new ArrayList<>();
			list.add(TableNameConst.BUS_LINE);
			list.add(TableNameConst.BUS_STATION);
			return list;
		}else {
			List<String > list = new ArrayList<>();
			list.add(TableNameConst.LINE_BOUND);
			list.add(TableNameConst.LINE_BUSLINE);
			list.add(TableNameConst.LINE_LOCATION);
			list.add(TableNameConst.LINE_VIA_STOP);
			return list;
		}

	}
}

package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppArea;
import com.mobile.blue.launcher.model.Example.AppAreaExample;
import com.mobile.blue.launcher.model.Example.AppAreaExample.Criteria;

public interface AreaDao {

	List<AppArea> selectByExample(AppAreaExample example, Criteria criteria);

	int countByExample(AppAreaExample appareaExample, Criteria criteria);

}

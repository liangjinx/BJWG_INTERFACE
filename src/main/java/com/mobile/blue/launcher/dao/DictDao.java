package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppDict;
import com.mobile.blue.launcher.model.Example.AppDictExample;
import com.mobile.blue.launcher.model.Example.AppDictExample.Criteria;

public interface DictDao {

	List<AppDict> selectByExamlpe(AppDictExample example, Criteria criteria);

}

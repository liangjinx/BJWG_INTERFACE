package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppArea;
import com.mobile.blue.launcher.model.Example.AppAreaExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppAreaMapper {
	int countByExample(AppAreaExample example);

	int deleteByPrimaryKey(Long areaId);

	int insert(AppArea record);

	int insertSelective(AppArea record);

	List<AppArea> selectByExample(AppAreaExample example);

	AppArea selectByPrimaryKey(Long areaId);

	int updateByPrimaryKeySelective(AppArea record);

	int updateByPrimaryKey(AppArea record);
}
package com.mobile.blue.launcher.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppMyEarnings;
import com.mobile.blue.launcher.model.Example.AppMyEarningsExample;

@Component
@MyBatisRepository
public interface AppMyEarningsMapper {
	int countByExample(AppMyEarningsExample example);

	int deleteByPrimaryKey(Long earningsId);

	int insert(AppMyEarnings record);

	int insertSelective(AppMyEarnings record);

	List<AppMyEarnings> selectByExample(AppMyEarningsExample example);

	AppMyEarnings selectByPrimaryKey(Long earningsId);

	int updateByPrimaryKeySelective(AppMyEarnings record);

	int updateByPrimaryKey(AppMyEarnings record);
}
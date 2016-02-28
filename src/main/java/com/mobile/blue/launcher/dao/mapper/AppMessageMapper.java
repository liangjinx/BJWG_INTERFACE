package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppMessage;
import com.mobile.blue.launcher.model.Example.AppMessageExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppMessageMapper {
	int countByExample(AppMessageExample example);

	int deleteByPrimaryKey(Long messageId);

	int insert(AppMessage record);

	int insertSelective(AppMessage record);

	List<AppMessage> selectByExample(AppMessageExample example);

	AppMessage selectByPrimaryKey(Long messageId);

	int updateByPrimaryKeySelective(AppMessage record);

	int updateByPrimaryKey(AppMessage record);
}
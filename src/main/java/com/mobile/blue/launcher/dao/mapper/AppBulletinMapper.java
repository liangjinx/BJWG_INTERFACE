package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppBulletin;
import com.mobile.blue.launcher.model.Example.AppBulletinExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppBulletinMapper {
	int countByExample(AppBulletinExample example);

	int deleteByPrimaryKey(Long bulletinId);

	int insert(AppBulletin record);

	int insertSelective(AppBulletin record);

	List<AppBulletin> selectByExample(AppBulletinExample example);

	AppBulletin selectByPrimaryKey(Long bulletinId);

	int updateByPrimaryKeySelective(AppBulletin record);

	int updateByPrimaryKey(AppBulletin record);
}
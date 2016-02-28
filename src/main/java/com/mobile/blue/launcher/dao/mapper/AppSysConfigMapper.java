package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppSysConfig;
import com.mobile.blue.launcher.model.Example.AppSysConfigExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppSysConfigMapper {
    int countByExample(AppSysConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppSysConfig record);

    int insertSelective(AppSysConfig record);

    List<AppSysConfig> selectByExample(AppSysConfigExample example);

    AppSysConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppSysConfig record);

    int updateByPrimaryKey(AppSysConfig record);
}
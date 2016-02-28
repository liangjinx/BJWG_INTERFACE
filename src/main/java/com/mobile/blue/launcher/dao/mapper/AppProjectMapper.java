package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppProject;
import com.mobile.blue.launcher.model.Example.AppProjectExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppProjectMapper {
    int countByExample(AppProjectExample example);

    int deleteByPrimaryKey(Long paincbuyProjectId);

    int insert(AppProject record);

    int insertSelective(AppProject record);

    List<AppProject> selectByExampleWithBLOBs(AppProjectExample example);

    List<AppProject> selectByExample(AppProjectExample example);

    AppProject selectByPrimaryKey(Long paincbuyProjectId);

    int updateByPrimaryKeySelective(AppProject record);

    int updateByPrimaryKeyWithBLOBs(AppProject record);

    int updateByPrimaryKey(AppProject record);
}
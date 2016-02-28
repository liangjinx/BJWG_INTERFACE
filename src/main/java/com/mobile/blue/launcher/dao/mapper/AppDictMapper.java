package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppDict;
import com.mobile.blue.launcher.model.Example.AppDictExample;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
@MyBatisRepository
public interface AppDictMapper {
    int countByExample(AppDictExample example);

    int deleteByPrimaryKey(Long dictId);

    int insert(AppDict record);

    int insertSelective(AppDict record);

    List<AppDict> selectByExample(AppDictExample example);

    AppDict selectByPrimaryKey(Long dictId);

    int updateByPrimaryKeySelective(AppDict record);

    int updateByPrimaryKey(AppDict record);
}
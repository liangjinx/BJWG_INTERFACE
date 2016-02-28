package com.mobile.blue.launcher.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppPresentFreinds;
import com.mobile.blue.launcher.model.Example.AppPresentFreindsExample;
@Component
@MyBatisRepository
public interface AppPresentFreindsMapper {
    int countByExample(AppPresentFreindsExample example);

    int deleteByPrimaryKey(Long presentId);

    int insert(AppPresentFreinds record);

    int insertSelective(AppPresentFreinds record);

    List<AppPresentFreinds> selectByExample(AppPresentFreindsExample example);

    AppPresentFreinds selectByPrimaryKey(Long presentId);

    int updateByPrimaryKeySelective(AppPresentFreinds record);

    int updateByPrimaryKey(AppPresentFreinds record);
}
package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppPreorder;
import com.mobile.blue.launcher.model.AppPreorderKey;
import com.mobile.blue.launcher.model.Example.AppPreorderExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppPreorderMapper {
    int countByExample(AppPreorderExample example);

    int deleteByPrimaryKey(AppPreorderKey key);

    int insert(AppPreorder record);

    int insertSelective(AppPreorder record);

    List<AppPreorder> selectByExample(AppPreorderExample example);

    AppPreorder selectByPrimaryKey(AppPreorderKey key);

    int updateByPrimaryKeySelective(AppPreorder record);

    int updateByPrimaryKey(AppPreorder record);
}
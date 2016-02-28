package com.mobile.blue.launcher.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppTestUserFenye;
import com.mobile.blue.launcher.model.AppTestUserFenyeExample;
@Component
@MyBatisRepository
public interface AppTestUserFenyeMapper	{
    int countByExample(AppTestUserFenyeExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(AppTestUserFenye record);

    int insertSelective(AppTestUserFenye record);

    List<AppTestUserFenye> selectByExample(AppTestUserFenyeExample example);

    AppTestUserFenye selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(AppTestUserFenye record);

    int updateByPrimaryKey(AppTestUserFenye record);
}
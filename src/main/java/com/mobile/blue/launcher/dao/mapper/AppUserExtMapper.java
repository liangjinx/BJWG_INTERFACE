package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppUserExt;
import com.mobile.blue.launcher.model.Example.AppUserExtExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppUserExtMapper {
    int countByExample(AppUserExtExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(AppUserExt record);

    int insertSelective(AppUserExt record);

    List<AppUserExt> selectByExample(AppUserExtExample example);

    AppUserExt selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(AppUserExt record);

    int updateByPrimaryKey(AppUserExt record);
}
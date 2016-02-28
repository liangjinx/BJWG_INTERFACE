package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppWithdrawals;
import com.mobile.blue.launcher.model.Example.AppWithdrawalsExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppWithdrawalsMapper {
    int countByExample(AppWithdrawalsExample example);

    int deleteByPrimaryKey(Long withwradalsId);

    int insert(AppWithdrawals record);

    int insertSelective(AppWithdrawals record);

    List<AppWithdrawals> selectByExample(AppWithdrawalsExample example);

    AppWithdrawals selectByPrimaryKey(Long withwradalsId);

    int updateByPrimaryKeySelective(AppWithdrawals record);

    int updateByPrimaryKey(AppWithdrawals record);
}
package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppWalletChangeLog;
import com.mobile.blue.launcher.model.Example.AppWalletChangeLogExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppWalletChangeLogMapper {
    int countByExample(AppWalletChangeLogExample example);

    int deleteByPrimaryKey(Long walletChangeId);

    int insert(AppWalletChangeLog record);

    int insertSelective(AppWalletChangeLog record);

    List<AppWalletChangeLog> selectByExample(AppWalletChangeLogExample example);

    AppWalletChangeLog selectByPrimaryKey(Long walletChangeId);

    int updateByPrimaryKeySelective(AppWalletChangeLog record);

    int updateByPrimaryKey(AppWalletChangeLog record);
}
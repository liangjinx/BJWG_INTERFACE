package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppWallet;
import com.mobile.blue.launcher.model.Example.AppWalletExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppWalletMapper {
    int countByExample(AppWalletExample example);

    int deleteByPrimaryKey(Long walletId);

    int insert(AppWallet record);

    int insertSelective(AppWallet record);

    List<AppWallet> selectByExample(AppWalletExample example);

    AppWallet selectByPrimaryKey(Long walletId);

    int updateByPrimaryKeySelective(AppWallet record);

    int updateByPrimaryKey(AppWallet record);
}
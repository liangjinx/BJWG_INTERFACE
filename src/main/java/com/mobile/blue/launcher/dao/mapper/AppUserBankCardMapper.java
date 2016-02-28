package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppUserBankCard;
import com.mobile.blue.launcher.model.Example.AppUserBankCardExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppUserBankCardMapper {
    int countByExample(AppUserBankCardExample example);

    int deleteByPrimaryKey(Long cardId);

    int insert(AppUserBankCard record);

    int insertSelective(AppUserBankCard record);

    List<AppUserBankCard> selectByExample(AppUserBankCardExample example);

    AppUserBankCard selectByPrimaryKey(Long cardId);

    int updateByPrimaryKeySelective(AppUserBankCard record);

    int updateByPrimaryKey(AppUserBankCard record);
}
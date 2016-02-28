package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppBankCard;
import com.mobile.blue.launcher.model.Example.AppBankCardExample;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
@MyBatisRepository
public interface AppBankCardMapper {
    int countByExample(AppBankCardExample example);

    int deleteByPrimaryKey(Long cardId);

    int insert(AppBankCard record);

    int insertSelective(AppBankCard record);

    List<AppBankCard> selectByExample(AppBankCardExample example);

    AppBankCard selectByPrimaryKey(Long cardId);

    int updateByPrimaryKeySelective(AppBankCard record);

    int updateByPrimaryKey(AppBankCard record);
}
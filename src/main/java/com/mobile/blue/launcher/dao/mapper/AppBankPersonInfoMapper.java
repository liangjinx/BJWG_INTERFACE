package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppBankPersonInfo;
import com.mobile.blue.launcher.model.Example.AppBankPersonInfoExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppBankPersonInfoMapper {
	int countByExample(AppBankPersonInfoExample example);

	int deleteByPrimaryKey(Long personId);

	int insert(AppBankPersonInfo record);

	int insertSelective(AppBankPersonInfo record);

	List<AppBankPersonInfo> selectByExample(AppBankPersonInfoExample example);

	AppBankPersonInfo selectByPrimaryKey(Long personId);

	int updateByPrimaryKeySelective(AppBankPersonInfo record);

	int updateByPrimaryKey(AppBankPersonInfo record);
}
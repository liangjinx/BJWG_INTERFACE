package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppDictDefatl;
import com.mobile.blue.launcher.model.Example.AppDictDefatlExample;
import com.mobile.blue.view.BankNameVo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppDictDefatlMapper {
	int countByExample(AppDictDefatlExample example);

	int deleteByPrimaryKey(Long dictDetailId);

	int insert(AppDictDefatl record);

	int insertSelective(AppDictDefatl record);

	List<AppDictDefatl> selectByExample(AppDictDefatlExample example);

	AppDictDefatl selectByPrimaryKey(Long dictDetailId);

	int updateByPrimaryKeySelective(AppDictDefatl record);

	int updateByPrimaryKey(AppDictDefatl record);

	List<BankNameVo> selectBankNamelist(AppDictDefatlExample example);
}
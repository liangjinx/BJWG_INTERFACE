package com.mobile.blue.launcher.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppOrderExtFee;
import com.mobile.blue.launcher.model.Example.AppOrderExtFeeExample;
@Component
@MyBatisRepository
public interface AppOrderExtFeeMapper {
    int countByExample(AppOrderExtFeeExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(AppOrderExtFee record);

    int insertSelective(AppOrderExtFee record);

    List<AppOrderExtFee> selectByExample(AppOrderExtFeeExample example);

    AppOrderExtFee selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(AppOrderExtFee record);

    int updateByPrimaryKey(AppOrderExtFee record);
}
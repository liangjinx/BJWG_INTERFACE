package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppOrderAddress;
import com.mobile.blue.launcher.model.Example.AppOrderAddressExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppOrderAddressMapper {
    int countByExample(AppOrderAddressExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(AppOrderAddress record);

    int insertSelective(AppOrderAddress record);

    List<AppOrderAddress> selectByExample(AppOrderAddressExample example);

    AppOrderAddress selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(AppOrderAddress record);

    int updateByPrimaryKey(AppOrderAddress record);
}
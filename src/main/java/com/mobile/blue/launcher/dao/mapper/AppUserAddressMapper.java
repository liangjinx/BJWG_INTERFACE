package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppUserAddress;
import com.mobile.blue.launcher.model.Example.AppUserAddressExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppUserAddressMapper {
    int countByExample(AppUserAddressExample example);

    int deleteByPrimaryKey(Long addressId);

    int insert(AppUserAddress record);

    int insertSelective(AppUserAddress record);

    List<AppUserAddress> selectByExample(AppUserAddressExample example);

    AppUserAddress selectByPrimaryKey(Long addressId);

    int updateByPrimaryKeySelective(AppUserAddress record);

    int updateByPrimaryKey(AppUserAddress record);
}
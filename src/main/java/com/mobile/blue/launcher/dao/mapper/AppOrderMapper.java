package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppOrder;
import com.mobile.blue.launcher.model.Example.AppOrderExample;
import com.mobile.blue.view.OrderRankingVo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppOrderMapper {
    int countByExample(AppOrderExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(AppOrder record);

    int insertSelective(AppOrder record);

    List<AppOrder> selectByExample(AppOrderExample example);

    AppOrder selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(AppOrder record);

    int updateByPrimaryKey(AppOrder record);

	int countByRanking(AppOrderExample example);

	List<OrderRankingVo> selectByRanking(AppOrderExample example);
}
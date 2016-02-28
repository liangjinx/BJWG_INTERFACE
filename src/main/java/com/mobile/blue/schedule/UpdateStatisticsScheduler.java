package com.mobile.blue.schedule;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.mobile.blue.util.Constant;

@Component
public class UpdateStatisticsScheduler {

	@Autowired
	private RedisTemplate<Serializable, Serializable> redisTemplate;

	private Log log = LogFactory.getLog(this.getClass());

	public void process() throws SQLException, ParseException {
		log.info("Start statistics weather data ");
		HashOperations<Serializable, Object, Object> valueOper = redisTemplate.opsForHash();
		Set<Object> setTable = valueOper.keys(Constant.WEATHER_TABLE);

		for (Object o : setTable) {
			valueOper.delete(Constant.WEATHER_TABLE, o);
		}
		log.info("End statistics weather data ");
	}

}

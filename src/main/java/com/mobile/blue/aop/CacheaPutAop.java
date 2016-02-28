package com.mobile.blue.aop;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.mobile.blue.annotation.CacheKey;
import com.mobile.blue.annotation.CachePut;
import com.mobile.blue.annotation.CachePut.PutTypeMode;
import com.mobile.blue.annotation.CacheValue;

@Aspect
@Component
public class CacheaPutAop {

	@Autowired
	private RedisTemplate<Serializable, Serializable> redisTemplate;

	@AfterReturning("@annotation(cache)")
	public void cached(final JoinPoint point, CachePut cache) throws Throwable {

		putCacheValue(cache, getCache(point, cache));
	}

	private void putCacheValue(CachePut cache, Map<String, Object> map)
			throws InstantiationException, IllegalAccessException {
		String key = map.get("key").toString();
		Serializable value = (Serializable) map.get("value");
		if (cache.type() == PutTypeMode.STRING) {
			ValueOperations<Serializable, Serializable> valueOper = redisTemplate.opsForValue();
			valueOper.set(key, value);
		} else if (cache.type() == PutTypeMode.HASH) {
			HashOperations<Serializable, Object, Object> valueOper = redisTemplate.opsForHash();
			String tableName = cache.table().getSimpleName();
			valueOper.put(tableName, key, value);
		}
		// }else if (cache.type()==TypeMode.LIST) {
		// ListOperations<Serializable, Serializable> valueOper =
		// redisTemplate.opsForList();
		// valueOper.set(arg0, arg1, arg2);
		// }else if (cache.type()==TypeMode.SET) {
		// SetOperations<Serializable, Serializable> valueOper =
		// redisTemplate.opsForSet();
		// value = value =value=valueOper.getOperations();
		// }

	}

	/**
	 * 获取缓存的key值
	 * 
	 * @param pjp
	 * @param cache
	 * @return
	 */
	private Map<String, Object> getCache(JoinPoint point, CachePut cache) {
		Map<String, Object> map = new HashMap<String, Object>();
		Object[] args = point.getArgs();
		Annotation[][] pas = ((MethodSignature) point.getSignature()).getMethod().getParameterAnnotations();
		for (int i = 0; i < pas.length; i++) {
			for (Annotation an : pas[i]) {
				if (an instanceof CacheKey) {
					Object key = args[i].toString();
					map.put("key", key);
				}
				if (an instanceof CacheValue) {
					Serializable value = (Serializable) args[i];
					map.put("value", value);
				}
			}
		}
		return map;
	}

}

package com.mobile.blue.aop;

import java.io.Serializable;
import java.lang.annotation.Annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.mobile.blue.annotation.CacheDel;
import com.mobile.blue.annotation.CacheDel.DelsTypeMode;
import com.mobile.blue.annotation.CacheKey;

@Aspect
@Component
public class CacheaDelAop {

	@Autowired
	private RedisTemplate<Serializable, Serializable> redisTemplate;

	@AfterReturning("@annotation(cache)")
	public void cached(final JoinPoint point, CacheDel cache) throws Throwable {

		delCacheValue(cache, getCache(point, cache));
	}

	private void delCacheValue(CacheDel cache, Object key) throws InstantiationException, IllegalAccessException {
		if (cache.type() == DelsTypeMode.STRING) {
			redisTemplate.delete((Serializable) key);
		} else if (cache.type() == DelsTypeMode.HASH) {
			HashOperations<Serializable, Object, Object> valueOper = redisTemplate.opsForHash();
			String tableName = cache.table().getSimpleName();
			valueOper.delete(tableName, key);
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
	private Object getCache(JoinPoint point, CacheDel cache) {
		Object key = null;
		Object[] args = point.getArgs();
		Annotation[][] pas = ((MethodSignature) point.getSignature()).getMethod().getParameterAnnotations();
		for (int i = 0; i < pas.length; i++) {
			for (Annotation an : pas[i]) {
				if (an instanceof CacheKey) {
					key = args[i].toString();
				}
			}
		}
		return key;
	}

}

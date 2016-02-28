/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mobile.blue.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;

/**
 * Annotation indicating that a method (or all methods on a class) trigger(s) a
 * {@link Cache#put(Object, Object)} operation. As opposed to {@link Cacheable}
 * annotation, this annotation does not cause the target method to be skipped -
 * rather it always causes the method to be invoked and its result to be placed
 * into the cache.
 * 
 * @author Costin Leau
 * @author Phillip Webb
 * @author Stephane Nicoll
 * @since 3.1
 * @see CacheConfig
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CachePut {

	public enum PutTypeMode {
		STRING, // redis 使用String类型作为value
		HASH, // redis 使用HashMap类型作为value
		LIST, // redis 使用List类型作为value
		SET, // redis 使用set类型作为value
		SORT_LIST; // redis 使用有序集合作为value
	}

	public PutTypeMode type() default PutTypeMode.HASH; // 缓存的类型

	@SuppressWarnings("rawtypes")
	public Class table() default String.class; // 缓存table
}

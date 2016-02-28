package com.mobile.blue.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Cacheable {

	public enum TypeMode {
		STRING, // redis 使用String类型作为value
		HASH, // redis 使用HashMap类型作为value
		LIST, // redis 使用List类型作为value
		SET, // redis 使用set类型作为value
		SORT_LIST; // redis 使用有序集合作为value
	}

	public TypeMode type() default TypeMode.HASH; // 缓存的类型

	public String key() default ""; // 缓存key

	@SuppressWarnings("rawtypes")
	public Class table() default String.class; // 缓存table

}

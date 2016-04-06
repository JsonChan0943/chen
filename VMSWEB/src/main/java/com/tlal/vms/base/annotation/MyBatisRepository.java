package com.tlal.vms.base.annotation;

import org.springframework.stereotype.Repository;

/**
 * 自定义注解
 * 只有被此注解修饰的接口才会被扫描称为DAO
 * @author Administrator
 *
 */
@Repository
public @interface MyBatisRepository {
	String value() default "";
}

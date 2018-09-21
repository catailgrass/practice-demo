package com.flycat.dao.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  * 标识MyBatis的DAO,方便{@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描  */ 
@Retention(RetentionPolicy.RUNTIME) //运行时保留
@Target(ElementType.TYPE) //修饰的目标  Class, interface (including annotation type), or enum declaration
public @interface MyBatisRepository {}

package com.polaris.framework.view.support.extjs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识数据模型定义
 * 
 * @author wang.sheng
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Model
{
	/**
	 * 名称.默认类名
	 * 
	 * @return
	 */
	String value() default "";
}

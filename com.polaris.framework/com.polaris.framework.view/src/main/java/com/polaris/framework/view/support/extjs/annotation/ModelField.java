package com.polaris.framework.view.support.extjs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 属性模型
 * 
 * @author wang.sheng
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ModelField
{
	/**
	 * 名称.默认属性名
	 * 
	 * @return
	 */
	String value() default "";

	/**
	 * 默认取值
	 * 
	 * @return
	 */
	String defaultValue() default "";

	/**
	 * 类型
	 * 
	 * @return
	 */
	String type() default "";

	/**
	 * 转换方法名
	 * 
	 * @return
	 */
	String convert() default "";

	/**
	 * 关键字
	 * 
	 * @return
	 */
	boolean key() default false;
}

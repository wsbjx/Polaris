package com.polaris.platform.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 模块定义
 * 
 * @author wang.sheng
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Module
{
	/**
	 * javascript文件的路径
	 * 
	 * @return
	 */
	String jsFile() default "";

	/**
	 * 模块名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 模块ID.应该全局唯一
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 角色集合
	 * 
	 * @return
	 */
	String[] roles() default {};
}

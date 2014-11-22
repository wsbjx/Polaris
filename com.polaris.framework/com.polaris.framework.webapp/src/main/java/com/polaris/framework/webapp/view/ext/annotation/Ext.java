package com.polaris.framework.webapp.view.ext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对应标签库中的标识
 * 
 * @author wang.sheng
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Ext
{
	/**
	 * 定义的类型
	 * 
	 * @return
	 */
	public VarType type() default VarType.CONFIG;

	/**
	 * 名称
	 * 
	 * @return
	 */
	public String name() default "";
}

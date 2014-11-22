package com.polaris.framework.webapp.view.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标签库中的属性设置注释<br>
 * 必须对应Ext类的set方法<br>
 * 
 * @author Administrator
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
public @interface TagAttribute
{
	/**
	 * 属性名称
	 * 
	 * @return
	 */
	public String name() default "";

	/**
	 * 是否是URL地址
	 * 
	 * @return
	 */
	public boolean isURL() default false;

	/**
	 * 是否必填
	 * 
	 * @return
	 */
	public boolean required() default false;

	/**
	 * 是否可以动态加载
	 * 
	 * @return
	 */
	public boolean rtexprvalue() default true;

	/**
	 * 描述信息
	 * 
	 * @return
	 */
	public String description() default "";
}

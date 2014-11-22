package com.polaris.framework.webapp.view.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对应标签库解析标签<br>
 * 与@TagAttribute配合使用可以自动生成TLD文件<br>
 * 
 * @author wang.sheng
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TagLib
{
	/**
	 * 标签名称
	 * 
	 * @return
	 */
	public String name() default "";

	/**
	 * 对应的组件实现类
	 * 
	 * @return
	 */
	public Class<?> component() default Object.class;

	/**
	 * 标签描述
	 * 
	 * @return
	 */
	public String description() default "";

	/**
	 * 内容类型
	 * 
	 * @return
	 */
	public String bodyContent() default "JSP";
}

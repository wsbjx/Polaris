package com.polaris.framework.view.support.extjs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 属性的模型定义
 * 
 * @author wang.sheng
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GridField
{
	/**
	 * 列标题
	 * 
	 * @return
	 */
	String header() default "";

	/**
	 * 宽度
	 * 
	 * @return
	 */
	int width() default -1;

	/**
	 * 对应数据对象的索引
	 * 
	 * @return
	 */
	String dataIndex() default "";

	/**
	 * 输入框类型
	 * 
	 * @return
	 */
	String input() default "";

	/**
	 * 是否可排序.默认可以排序
	 * 
	 * @return
	 */
	boolean sortable() default true;

	/**
	 * 比例宽度
	 * 
	 * @return
	 */
	int flex() default -1;
}

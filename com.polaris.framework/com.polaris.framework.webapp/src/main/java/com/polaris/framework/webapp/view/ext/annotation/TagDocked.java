package com.polaris.framework.webapp.view.ext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 父子标记之前的嵌套<br>
 * 必须注释在方法上,并且方法的参数数量必须为1<br>
 * 
 * @author wang.sheng
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TagDocked
{
	/**
	 * 附加组件的类型,可以是抽象类.默认是Object类
	 * 
	 * @return
	 */
	public Class<?> dockType() default Object.class;
}

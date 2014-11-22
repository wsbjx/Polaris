package com.polaris.framework.webapp.view.ext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 子对象,也有可能是对象的引用
 * 
 * @author wang.sheng
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExtChild
{
	public String name() default "";
}

package com.polaris.framework.common.xml.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XmlList
{
	public String name();

	public Class<?> listClass() default java.util.ArrayList.class;

	public Class<?> itemClass();
}

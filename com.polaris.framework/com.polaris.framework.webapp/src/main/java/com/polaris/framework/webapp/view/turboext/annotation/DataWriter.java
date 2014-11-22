package com.polaris.framework.webapp.view.turboext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DataWriter
{
	public boolean allowSingle() default false;

	public String type() default "json";

	public boolean writeAllFields() default true;
}

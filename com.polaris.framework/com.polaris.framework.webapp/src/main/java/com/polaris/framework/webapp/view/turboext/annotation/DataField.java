package com.polaris.framework.webapp.view.turboext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DataField
{
	public String name() default "";

	public String type() default "";

	public String dateFormat() default "";

	public boolean isIdProperty() default false;
}

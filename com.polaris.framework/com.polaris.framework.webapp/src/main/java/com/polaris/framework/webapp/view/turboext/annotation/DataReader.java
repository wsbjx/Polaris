package com.polaris.framework.webapp.view.turboext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DataReader
{
    public String root() default "results";
    
    public String totalProperty() default "totalCount";
    
    public String successProperty() default "success";
}

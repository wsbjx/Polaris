package com.polaris.framework.webapp.view.ext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 要么是普通字符串,要么是JSON字符串
 * 
 * @author wang.sheng
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExtField
{
    /**
     * 在EXT脚本中生成的名称.默认取属性的名称
     * 
     * @return
     */
    public String name() default "";
    
    /**
     * 是否要翻译成JSON字符串
     * 
     * @return
     */
    public boolean isJson() default false;
}

package com.polaris.framework.webapp.view.ext.api;

/**
 * 不是实际的对象,而是一个对象的引用
 * 
 * @author wang.sheng
 */
public class EReference
{
    private String name;
    private Object target;
    
    public EReference(String name, Object target)
    {
        this.name = name;
        this.target = target;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Object getTarget()
    {
        return target;
    }
    
}

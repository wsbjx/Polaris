package com.polaris.framework.webapp.view.ext.jsp;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.EReference;
import com.polaris.framework.webapp.view.ext.api.ERootBody;

/**
 * 用于页面内部的变量对象应用
 * 
 * @author wang.sheng
 */
@TagLib(name = "reference", description = "引用变量定义", component = EReference.class, bodyContent = "empty")
public class ReferenceTag extends ExtTagSupport
{
    private static final long serialVersionUID = 1L;
    @TagAttribute(required = true)
    private String            name;
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    protected Object createComponent()
    {
        ERootBody root = super.getRootBody();
        Object target = root.findModule(name);
        if(target == null)
        {
            log.error("Reference target not found! varName:" + name);
            return null;
        }
        return new EReference(name, target);
    }
}

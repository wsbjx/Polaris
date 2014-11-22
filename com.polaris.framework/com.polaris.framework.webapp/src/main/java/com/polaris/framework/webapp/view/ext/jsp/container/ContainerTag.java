package com.polaris.framework.webapp.view.ext.jsp.container;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.container.EContainer;
import com.polaris.framework.webapp.view.ext.jsp.ComponentTag;

/**
 * container标签
 * 
 * @author wang.sheng
 */
@TagLib(name = "container", component = EContainer.class)
public class ContainerTag extends ComponentTag
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected String          layout;
    @TagAttribute
    protected String          defaultType;
    @TagAttribute
    protected String          defaults;
    @TagAttribute
    protected Boolean         suspendLayout;
    
    public void setLayout(String layout)
    {
        this.layout = layout;
    }
    
    public void setDefaultType(String defaultType)
    {
        this.defaultType = defaultType;
    }
    
    public void setDefaults(String defaults)
    {
        this.defaults = defaults;
    }
    
    public void setSuspendLayout(Boolean suspendLayout)
    {
        this.suspendLayout = suspendLayout;
    }
    
}

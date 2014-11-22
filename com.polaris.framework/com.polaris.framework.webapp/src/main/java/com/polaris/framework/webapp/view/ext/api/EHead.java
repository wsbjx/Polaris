package com.polaris.framework.webapp.view.ext.api;

import com.polaris.framework.webapp.view.annotation.TagAttribute;

/**
 * JSP页面的头部
 * 
 * @author wang.sheng
 */
public class EHead
{
    private String version;
    private String title = "EXT PAGE";
    
    public String getVersion()
    {
        return version;
    }
    
    @TagAttribute
    public void setVersion(String version)
    {
        this.version = version;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    @TagAttribute
    public void setTitle(String title)
    {
        this.title = title;
    }
    
}

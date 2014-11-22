package com.polaris.framework.webapp.view.ext.api.util;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.TagContent;

public class EListener
{
    private String event;
    private String function;
    
    public String getEvent()
    {
        return event;
    }
    
    @TagAttribute
    public void setEvent(String event)
    {
        this.event = event;
    }
    
    public String getFunction()
    {
        return function;
    }
    
    @TagContent
    @TagAttribute
    public void setFunction(String function)
    {
        this.function = function;
    }
    
}

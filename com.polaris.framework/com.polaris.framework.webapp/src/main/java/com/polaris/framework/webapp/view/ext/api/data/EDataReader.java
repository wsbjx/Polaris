package com.polaris.framework.webapp.view.ext.api.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(type = VarType.CONFIG)
public class EDataReader
{
    @ExtField
    private String root;
    @ExtField
    private String totalProperty;
    @ExtField
    private String successProperty;
    @ExtField
    private String messageProperty;
    
    public String getRoot()
    {
        return root;
    }
    
    @TagAttribute
    public void setRoot(String root)
    {
        this.root = root;
    }
    
    public String getTotalProperty()
    {
        return totalProperty;
    }
    
    @TagAttribute
    public void setTotalProperty(String totalProperty)
    {
        this.totalProperty = totalProperty;
    }
    
    public String getSuccessProperty()
    {
        return successProperty;
    }
    
    @TagAttribute
    public void setSuccessProperty(String successProperty)
    {
        this.successProperty = successProperty;
    }
    
    public String getMessageProperty()
    {
        return messageProperty;
    }
    
    @TagAttribute
    public void setMessageProperty(String messageProperty)
    {
        this.messageProperty = messageProperty;
    }
    
}

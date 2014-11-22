package com.polaris.framework.webapp.view.ext.api.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(type = VarType.CONFIG)
public class EDataProxyAPI
{
    @ExtField
    protected String read;
    @ExtField
    protected String create;
    @ExtField
    protected String update;
    @ExtField
    protected String destroy;
    
    @TagAttribute(isURL = true)
    public void setRead(String read)
    {
        this.read = read;
    }
    
    @TagAttribute(isURL = true)
    public void setCreate(String create)
    {
        this.create = create;
    }
    
    @TagAttribute(isURL = true)
    public void setUpdate(String update)
    {
        this.update = update;
    }
    
    @TagAttribute(isURL = true)
    public void setDestroy(String destroy)
    {
        this.destroy = destroy;
    }
    
}

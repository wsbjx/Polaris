package com.polaris.framework.webapp.view.ext.api.toolbar;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(name = "pagingtoolbar", type = VarType.CONFIG)
public class EPagingToolbar extends EToolbar
{
    @ExtChild
    protected String  store;
    @ExtField
    protected Boolean displayInfo;
    
    @TagAttribute
    public void setStore(String store)
    {
        this.store = store;
    }
    
    @TagAttribute
    public void setDisplayInfo(Boolean displayInfo)
    {
        this.displayInfo = displayInfo;
    }
    
}

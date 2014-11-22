package com.polaris.framework.webapp.view.ext.api.grid.column;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(name = "Ext.grid.RowNumberer", type = VarType.CREATE)
public class ERowNumberer
{
    @ExtField
    protected Integer width;
    @ExtField
    protected Boolean sortable;
    
    @TagAttribute
    public void setWidth(Integer width)
    {
        this.width = width;
    }
    
    @TagAttribute
    public void setSortable(Boolean sortable)
    {
        this.sortable = sortable;
    }
    
}

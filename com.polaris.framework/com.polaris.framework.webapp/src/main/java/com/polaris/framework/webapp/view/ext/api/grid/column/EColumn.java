package com.polaris.framework.webapp.view.ext.api.grid.column;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.EObject;
import com.polaris.framework.webapp.view.ext.api.form.field.EField;

@Ext(type = VarType.CONFIG)
public class EColumn extends EObject
{
    @ExtField
    protected String  header;
    @ExtField
    protected String  dataIndex;
    @ExtField
    protected Integer flex;
    @ExtField
    protected Integer width;
    @ExtChild
    protected Object  field;
    @ExtField
    protected Boolean sortable;
    @ExtField
    protected String  align;
    @ExtChild
    protected String  renderer;
    @ExtField
    protected Boolean hideable;
    @ExtField
    protected Boolean menuDisabled;
    @ExtField
    protected String  menuText;
    @ExtField
    protected Boolean resizable;
    @ExtField
    protected Boolean draggable;
    
    @TagAttribute
    public void setHideable(Boolean hideable)
    {
        this.hideable = hideable;
    }
    
    @TagAttribute
    public void setHeader(String header)
    {
        this.header = header;
    }
    
    @TagAttribute
    public void setWidth(Integer width)
    {
        this.width = width;
    }
    
    @TagAttribute
    public void setDataIndex(String dataIndex)
    {
        this.dataIndex = dataIndex;
    }
    
    @TagAttribute
    public void setFlex(Integer flex)
    {
        this.flex = flex;
    }
    
    @TagAttribute
    public void setField(String field)
    {
        this.field = field;
    }
    
    @TagDocked
    public void setField(EField field)
    {
        this.field = field;
    }
    
    @TagAttribute
    public void setSortable(Boolean sortable)
    {
        this.sortable = sortable;
    }
    
    @TagAttribute
    public void setAlign(String align)
    {
        this.align = align;
    }
    
    @TagAttribute
    public void setRenderer(String renderer)
    {
        this.renderer = renderer;
    }
    
    @TagAttribute
    public void setMenuDisabled(Boolean menuDisabled)
    {
        this.menuDisabled = menuDisabled;
    }
    
    @TagAttribute
    public void setMenuText(String menuText)
    {
        this.menuText = menuText;
    }
    
    @TagAttribute
    public void setResizable(Boolean resizable)
    {
        this.resizable = resizable;
    }
    
    @TagAttribute
    public void setDraggable(Boolean draggable)
    {
        this.draggable = draggable;
    }
    
}

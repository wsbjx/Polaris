package com.polaris.framework.webapp.view.ext.api.button;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagContent;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.EComponent;

@Ext(name = "button", type = VarType.CONFIG)
public class EButton extends EComponent
{
    @ExtField
    protected String text;
    @ExtField
    protected String tooltip;
    @ExtChild
    protected String handler;
    @ExtField
    protected String iconCls;
    @ExtField
    protected String type;
    @ExtField
    protected String href;
    @ExtField
    protected String hrefTarget;
    @ExtChild
    protected Object params;
    @ExtField
    protected String textAlign;
    
    @TagAttribute
    public void setType(String type)
    {
        this.type = type;
    }
    
    @TagAttribute
    public void setHref(String href)
    {
        this.href = href;
    }
    
    @TagAttribute
    public void setHrefTarget(String hrefTarget)
    {
        this.hrefTarget = hrefTarget;
    }
    
    @TagAttribute
    public void setParams(String params)
    {
        this.params = params;
    }
    
    @TagAttribute
    public void setTextAlign(String textAlign)
    {
        this.textAlign = textAlign;
    }
    
    @TagAttribute
    public void setIconCls(String iconCls)
    {
        this.iconCls = iconCls;
    }
    
    @TagAttribute
    public void setText(String text)
    {
        this.text = text;
    }
    
    @TagAttribute
    public void setTooltip(String tooltip)
    {
        this.tooltip = tooltip;
    }
    
    @TagAttribute
    @TagContent
    public void setHandler(String handler)
    {
        this.handler = handler;
    }
    
}

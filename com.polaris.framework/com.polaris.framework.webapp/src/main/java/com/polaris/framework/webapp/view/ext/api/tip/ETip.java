package com.polaris.framework.webapp.view.ext.api.tip;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.panel.EPanel;

@Ext(name = "Ext.tip.Tip", type = VarType.CREATE)
public class ETip extends EPanel
{
    @ExtField
    protected Boolean constrainPosition;
    @ExtField
    protected Boolean shadow;
    
    @TagAttribute
    public void setConstrainPosition(Boolean constrainPosition)
    {
        this.constrainPosition = constrainPosition;
    }
    
    @TagAttribute
    public void setShadow(Boolean shadow)
    {
        this.shadow = shadow;
    }
    
}

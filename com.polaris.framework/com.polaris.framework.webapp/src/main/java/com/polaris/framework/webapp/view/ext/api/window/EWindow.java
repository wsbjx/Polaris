package com.polaris.framework.webapp.view.ext.api.window;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.panel.EAbstractPanel;

@Ext(name = "Ext.window.Window", type = VarType.CREATE)
public class EWindow extends EAbstractPanel
{
    @ExtField
    protected String  animateTarget;
    @ExtField
    protected Boolean constrain;
    @ExtField
    protected Boolean constrainHeader;
    @ExtField
    protected String  defaultFocus;
    @ExtField
    protected Boolean draggable;
    @ExtField
    protected Boolean expandOnShow;
    @ExtField
    protected Boolean maximizable;
    @ExtField
    protected Boolean maximized;
    @ExtField
    protected Boolean minimizable;
    @ExtField
    protected Boolean modal;
    @ExtField
    protected String  onEsc;
    @ExtField
    protected Boolean plain;
    @ExtField
    protected Boolean resizable;
    @ExtField
    protected Integer x;
    @ExtField
    protected Integer y;
    
    @TagAttribute
    public void setConstrainHeader(Boolean constrainHeader)
    {
        this.constrainHeader = constrainHeader;
    }
    
    @TagDocked
    public void addPanel(EAbstractPanel panel)
    {
        super.items.add(panel);
    }
    
    @TagAttribute
    public void setAnimateTarget(String animateTarget)
    {
        this.animateTarget = animateTarget;
    }
    
    @TagAttribute
    public void setConstrain(Boolean constrain)
    {
        this.constrain = constrain;
    }
    
    @TagAttribute
    public void setDefaultFocus(String defaultFocus)
    {
        this.defaultFocus = defaultFocus;
    }
    
    @TagAttribute
    public void setDraggable(Boolean draggable)
    {
        this.draggable = draggable;
    }
    
    @TagAttribute
    public void setExpandOnShow(Boolean expandOnShow)
    {
        this.expandOnShow = expandOnShow;
    }
    
    @TagAttribute
    public void setMaximizable(Boolean maximizable)
    {
        this.maximizable = maximizable;
    }
    
    @TagAttribute
    public void setMaximized(Boolean maximized)
    {
        this.maximized = maximized;
    }
    
    @TagAttribute
    public void setMinimizable(Boolean minimizable)
    {
        this.minimizable = minimizable;
    }
    
    @TagAttribute
    public void setModal(Boolean modal)
    {
        this.modal = modal;
    }
    
    @TagAttribute
    public void setOnEsc(String onEsc)
    {
        this.onEsc = onEsc;
    }
    
    @TagAttribute
    public void setPlain(Boolean plain)
    {
        this.plain = plain;
    }
    
    @TagAttribute
    public void setResizable(Boolean resizable)
    {
        this.resizable = resizable;
    }
    
    @TagAttribute
    public void setX(Integer x)
    {
        this.x = x;
    }
    
    @TagAttribute
    public void setY(Integer y)
    {
        this.y = y;
    }
    
}

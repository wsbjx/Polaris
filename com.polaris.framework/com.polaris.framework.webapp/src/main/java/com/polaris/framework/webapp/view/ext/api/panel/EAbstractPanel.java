package com.polaris.framework.webapp.view.ext.api.panel;

import java.util.ArrayList;
import java.util.List;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.ExtChildren;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.api.EModule;
import com.polaris.framework.webapp.view.ext.api.button.EButton;
import com.polaris.framework.webapp.view.ext.api.button.EToolButton;
import com.polaris.framework.webapp.view.ext.api.container.EContainer;
import com.polaris.framework.webapp.view.ext.api.toolbar.EToolbar;
import com.polaris.framework.webapp.view.ext.api.view.EView;


/**
 * 抽象的面板
 * 
 * @author wang.sheng
 */
public abstract class EAbstractPanel extends EContainer implements EModule
{
    protected String       varName;
    @ExtField
    protected String       region;
    @ExtField
    protected Boolean      collapsible;
    @ExtField
    protected String       title;
    @ExtField
    protected String       anchor;
    @ExtField
    protected Boolean      closable;
    @ExtField
    protected String       closeAction;
    @ExtField
    protected Integer      bodyPadding;
    @ExtField
    protected Boolean      collapsed;
    @ExtField
    protected String       buttonAlign;
    @ExtField
    protected Boolean      frameHeader;
    @ExtField
    protected Boolean      titleCollapse;
    @ExtField
    protected Boolean      preventHeader;
    
    @ExtChildren
    protected List<Object> dockedItems = new ArrayList<Object>();
    @ExtChildren
    protected List<Object> tools       = new ArrayList<Object>();
    @ExtChildren
    protected List<Object> buttons     = new ArrayList<Object>();
    
    @TagAttribute
    public void setPreventHeader(Boolean preventHeader)
    {
        this.preventHeader = preventHeader;
    }
    
    @TagAttribute
    public void setClosable(Boolean closable)
    {
        this.closable = closable;
    }
    
    @TagAttribute
    public void setCloseAction(String closeAction)
    {
        this.closeAction = closeAction;
    }
    
    @TagAttribute
    public void setCollapsed(Boolean collapsed)
    {
        this.collapsed = collapsed;
    }
    
    @TagAttribute
    public void setButtonAlign(String buttonAlign)
    {
        this.buttonAlign = buttonAlign;
    }
    
    @TagAttribute
    public void setFrameHeader(Boolean frameHeader)
    {
        this.frameHeader = frameHeader;
    }
    
    @TagAttribute
    public void setTitleCollapse(Boolean titleCollapse)
    {
        this.titleCollapse = titleCollapse;
    }
    
    @TagAttribute
    public void setAnchor(String anchor)
    {
        this.anchor = anchor;
    }
    
    @TagAttribute
    public void setBodyPadding(Integer bodyPadding)
    {
        this.bodyPadding = bodyPadding;
    }
    
    @Override
    public String getVarName()
    {
        return varName;
    }
    
    @TagAttribute
    public void setVarName(String varName)
    {
        this.varName = varName;
    }
    
    @TagAttribute
    public void setRegion(String region)
    {
        this.region = region;
    }
    
    @TagAttribute
    public void setCollapsible(Boolean collapsible)
    {
        this.collapsible = collapsible;
    }
    
    @TagAttribute
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    @TagDocked
    public void addView(EView view)
    {
        super.items.add(view);
    }
    
    @TagDocked
    public void addToolbar(EToolbar toolbar)
    {
        dockedItems.add(toolbar);
    }
    
    @TagDocked
    public void addButton(EButton button)
    {
        buttons.add(button);
    }
    
    @TagDocked
    public void addToolButton(EToolButton button)
    {
        tools.add(button);
    }
}

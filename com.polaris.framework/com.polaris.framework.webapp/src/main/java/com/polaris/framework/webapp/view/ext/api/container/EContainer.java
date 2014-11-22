package com.polaris.framework.webapp.view.ext.api.container;

import java.util.ArrayList;
import java.util.List;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtChildren;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.EComponent;
import com.polaris.framework.webapp.view.ext.api.EImg;
import com.polaris.framework.webapp.view.ext.api.button.EButton;
import com.polaris.framework.webapp.view.ext.api.form.field.EField;


@Ext(name = "container", type = VarType.CONFIG)
public class EContainer extends EComponent
{
    @ExtChild
    protected String       layout;
    @ExtField
    protected String       defaultType;
    @ExtChild
    protected String       defaults;
    @ExtField
    protected Boolean      suspendLayout;
    @ExtChildren
    protected List<Object> items = new ArrayList<Object>();
    
    @TagDocked
    public void addItem(EField child)
    {
        items.add(child);
    }
    
    @TagDocked
    public void addImg(EImg img)
    {
        items.add(img);
    }
    
    @TagDocked
    public void addItem(EButton button)
    {
        items.add(button);
    }
    
    @TagDocked
    public void addItem(EContainer container)
    {
        items.add(container);
    }
    
    @TagAttribute
    public void setLayout(String layout)
    {
        this.layout = layout;
    }
    
    @TagAttribute
    public void setDefaultType(String defaultType)
    {
        this.defaultType = defaultType;
    }
    
    @TagAttribute
    public void setDefaults(String defaults)
    {
        this.defaults = defaults;
    }
    
    @TagAttribute
    public void setSuspendLayout(Boolean suspendLayout)
    {
        this.suspendLayout = suspendLayout;
    }
    
}

package com.polaris.framework.webapp.view.ext.api.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(name = "textareafield", type = VarType.CONFIG)
public class ETextAreaField extends ETextField
{
    @ExtField
    protected Integer cols;
    @ExtField
    protected Boolean enterIsSpecial;
    @ExtField
    protected String  growAppend;
    @ExtField
    protected Integer growMin;
    @ExtField
    protected Integer growMax;
    @ExtField
    protected Boolean preventScrollbars;
    
    @TagAttribute
    public void setCols(Integer cols)
    {
        this.cols = cols;
    }
    
    @TagAttribute
    public void setEnterIsSpecial(Boolean enterIsSpecial)
    {
        this.enterIsSpecial = enterIsSpecial;
    }
    
    @TagAttribute
    public void setGrowAppend(String growAppend)
    {
        this.growAppend = growAppend;
    }
    
    @TagAttribute
    public void setGrowMin(Integer growMin)
    {
        this.growMin = growMin;
    }
    
    @TagAttribute
    public void setGrowMax(Integer growMax)
    {
        this.growMax = growMax;
    }
    
    @TagAttribute
    public void setPreventScrollbars(Boolean preventScrollbars)
    {
        this.preventScrollbars = preventScrollbars;
    }
    
}

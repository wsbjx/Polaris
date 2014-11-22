package com.polaris.framework.webapp.view.ext.jsp.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.form.field.ETextAreaField;

@TagLib(name = "textareafield", component = ETextAreaField.class)
public class TextAreaFieldTag extends TextFieldTag
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected Integer         cols;
    @TagAttribute
    protected Boolean         enterIsSpecial;
    @TagAttribute
    protected String          growAppend;
    @TagAttribute
    protected Integer         growMin;
    @TagAttribute
    protected Integer         growMax;
    @TagAttribute
    protected Boolean         preventScrollbars;
    
    public void setCols(Integer cols)
    {
        this.cols = cols;
    }
    
    public void setEnterIsSpecial(Boolean enterIsSpecial)
    {
        this.enterIsSpecial = enterIsSpecial;
    }
    
    public void setGrowAppend(String growAppend)
    {
        this.growAppend = growAppend;
    }
    
    public void setGrowMin(Integer growMin)
    {
        this.growMin = growMin;
    }
    
    public void setGrowMax(Integer growMax)
    {
        this.growMax = growMax;
    }
    
    public void setPreventScrollbars(Boolean preventScrollbars)
    {
        this.preventScrollbars = preventScrollbars;
    }
    
}

package com.polaris.framework.webapp.view.ext.api.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(name = "timefield", type = VarType.CONFIG)
public class ETimeField extends EAbstractField
{
    @ExtField
    protected String minValue;
    @ExtField
    protected String maxValue;
    
    @TagAttribute
    public void setMinValue(String minValue)
    {
        this.minValue = minValue;
    }
    
    @TagAttribute
    public void setMaxValue(String maxValue)
    {
        this.maxValue = maxValue;
    }
    
}

package com.polaris.framework.webapp.view.ext.jsp.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.form.field.ETimeField;

@TagLib(name = "timefield", component = ETimeField.class)
public class TimeFieldTag extends AbstractFieldTag
{
    private static final long serialVersionUID = 1L;
    @TagAttribute(description = "格式例如 1:30 AM 或者 9:15 PM")
    protected String          minValue;
    @TagAttribute(description = "格式例如 1:30 AM 或者 9:15 PM")
    protected String          maxValue;
    
    public void setMinValue(String minValue)
    {
        this.minValue = minValue;
    }
    
    public void setMaxValue(String maxValue)
    {
        this.maxValue = maxValue;
    }
}

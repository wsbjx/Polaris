package com.polaris.framework.webapp.view.ext.jsp.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.data.EDataField;
import com.polaris.framework.webapp.view.ext.jsp.ExtTagSupport;

@TagLib(name = "fieldtype", component = EDataField.class, bodyContent = "empty")
public class FieldTypeTag extends ExtTagSupport
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected String          name;
    @TagAttribute
    protected String          type;
    @TagAttribute
    protected String          dateFormat;
    @TagAttribute
    protected Object          defaultValue;
    @TagAttribute
    protected Boolean         useNull;
    @TagAttribute
    protected String          convert;
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public void setDateFormat(String dateFormat)
    {
        this.dateFormat = dateFormat;
    }
    
    public void setDefaultValue(Object defaultValue)
    {
        this.defaultValue = defaultValue;
    }
    
    public void setUseNull(Boolean useNull)
    {
        this.useNull = useNull;
    }
    
    public void setConvert(String convert)
    {
        this.convert = convert;
    }
    
}

package com.polaris.framework.webapp.view.ext.api.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(type = VarType.CONFIG)
public class EDataWriter
{
    @ExtField
    private String  type;
    @ExtField
    private Boolean writeAllFields;
    @ExtField
    private Boolean allowSingle;
    
    public String getType()
    {
        return type;
    }
    
    @TagAttribute
    public void setType(String type)
    {
        this.type = type;
    }
    
    public Boolean getWriteAllFields()
    {
        return writeAllFields;
    }
    
    @TagAttribute
    public void setWriteAllFields(Boolean writeAllFields)
    {
        this.writeAllFields = writeAllFields;
    }
    
    public Boolean getAllowSingle()
    {
        return allowSingle;
    }
    
    @TagAttribute
    public void setAllowSingle(Boolean allowSingle)
    {
        this.allowSingle = allowSingle;
    }
    
}

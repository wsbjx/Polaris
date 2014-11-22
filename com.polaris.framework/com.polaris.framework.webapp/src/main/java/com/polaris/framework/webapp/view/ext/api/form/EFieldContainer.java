package com.polaris.framework.webapp.view.ext.api.form;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.container.EContainer;

@Ext(name = "fieldcontainer", type = VarType.CONFIG)
public class EFieldContainer extends EContainer
{
    @ExtField
    protected Boolean combineErrors;
    @ExtField
    protected String  labelConnector;
    @ExtField
    protected Boolean combineLabels;
    @ExtField
    protected String  fieldDefaults;
    @ExtField
    protected String  fieldLabel;
    
    @TagAttribute
    public void setCombineErrors(Boolean combineErrors)
    {
        this.combineErrors = combineErrors;
    }
    
    @TagAttribute
    public void setLabelConnector(String labelConnector)
    {
        this.labelConnector = labelConnector;
    }
    
    @TagAttribute
    public void setCombineLabels(Boolean combineLabels)
    {
        this.combineLabels = combineLabels;
    }
    
    @TagAttribute
    public void setFieldDefaults(String fieldDefaults)
    {
        this.fieldDefaults = fieldDefaults;
    }
    
    @TagAttribute
    public void setFieldLabel(String fieldLabel)
    {
        this.fieldLabel = fieldLabel;
    }
    
}

package com.polaris.framework.webapp.view.ext.api.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.data.EAbstractStore;

@Ext(name = "combobox", type = VarType.CONFIG)
public class EComboBox extends ETextField
{
    @ExtChild
    protected Object  store;
    @ExtField
    protected String  queryMode;
    @ExtField
    protected String  displayField;
    @ExtField
    protected String  valueField;
    @ExtField
    protected Boolean autoSelect;
    @ExtField
    protected Boolean forceSelection;
    
    @TagDocked
    public void setStore(EAbstractStore store)
    {
        this.store = store;
    }
    
    @TagAttribute
    public void setStore(String store)
    {
        this.store = store;
    }
    
    @TagAttribute
    public void setQueryMode(String queryMode)
    {
        this.queryMode = queryMode;
    }
    
    @TagAttribute
    public void setDisplayField(String displayField)
    {
        this.displayField = displayField;
    }
    
    @TagAttribute
    public void setValueField(String valueField)
    {
        this.valueField = valueField;
    }
    
    @TagAttribute
    public void setAutoSelect(Boolean autoSelect)
    {
        this.autoSelect = autoSelect;
    }
    
    @TagAttribute
    public void setForceSelection(Boolean forceSelection)
    {
        this.forceSelection = forceSelection;
    }
    
}

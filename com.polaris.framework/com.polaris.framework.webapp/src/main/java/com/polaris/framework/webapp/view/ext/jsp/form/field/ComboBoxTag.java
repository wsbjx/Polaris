package com.polaris.framework.webapp.view.ext.jsp.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.form.field.EComboBox;

@TagLib(name = "combobox", component = EComboBox.class)
public class ComboBoxTag extends TextFieldTag
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected String          store;
    @TagAttribute
    protected String          queryMode;
    @TagAttribute
    protected String          displayField;
    @TagAttribute(required = true)
    protected String          valueField;
    @TagAttribute
    protected Boolean         autoSelect;
    @TagAttribute
    protected Boolean         forceSelection;
    
    public void setStore(String store)
    {
        this.store = store;
    }
    
    public void setQueryMode(String queryMode)
    {
        this.queryMode = queryMode;
    }
    
    public void setDisplayField(String displayField)
    {
        this.displayField = displayField;
    }
    
    public void setValueField(String valueField)
    {
        this.valueField = valueField;
    }
    
    public void setAutoSelect(Boolean autoSelect)
    {
        this.autoSelect = autoSelect;
    }
    
    public void setForceSelection(Boolean forceSelection)
    {
        this.forceSelection = forceSelection;
    }
    
}

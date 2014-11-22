package com.polaris.framework.webapp.view.ext.jsp.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.form.field.ECheckboxField;

@TagLib(name = "checkboxfield", component = ECheckboxField.class)
public class CheckboxFieldTag extends AbstractFieldTag
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected String          boxLabel;
    @TagAttribute
    protected Boolean         checked;
    @TagAttribute
    protected String          inputValue;
    @TagAttribute
    protected String          uncheckedValue;
    
    public void setBoxLabel(String boxLabel)
    {
        this.boxLabel = boxLabel;
    }
    
    public void setChecked(Boolean checked)
    {
        this.checked = checked;
    }
    
    public void setInputValue(String inputValue)
    {
        this.inputValue = inputValue;
    }
    
    public void setUncheckedValue(String uncheckedValue)
    {
        this.uncheckedValue = uncheckedValue;
    }
    
}

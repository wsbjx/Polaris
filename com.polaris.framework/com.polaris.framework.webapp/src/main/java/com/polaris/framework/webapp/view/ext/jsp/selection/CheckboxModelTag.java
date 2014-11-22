package com.polaris.framework.webapp.view.ext.jsp.selection;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.selection.ECheckboxModel;
import com.polaris.framework.webapp.view.ext.jsp.ExtTagSupport;

@TagLib(name = "checkboxmodel", component = ECheckboxModel.class, bodyContent = "empty")
public class CheckboxModelTag extends ExtTagSupport
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected String          varName;
    
    public void setVarName(String varName)
    {
        this.varName = varName;
    }
    
}

package com.polaris.framework.webapp.view.ext.jsp.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.data.EDataModel;
import com.polaris.framework.webapp.view.ext.jsp.ExtTagSupport;

@TagLib(name = "datamodel", component = EDataModel.class)
public class DataModelTag extends ExtTagSupport
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected String          idProperty;
    @TagAttribute
    protected String          define;
    
    public void setIdProperty(String idProperty)
    {
        this.idProperty = idProperty;
    }
    
    public void setDefine(String define)
    {
        this.define = define;
    }
    
}

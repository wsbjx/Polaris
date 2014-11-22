package com.polaris.framework.webapp.view.ext.jsp.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.jsp.ExtTagSupport;

/**
 * 抽象的Store标记
 * 
 * @author wang.sheng
 */
public abstract class AbstractStoreTag extends ExtTagSupport
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected String          varName;
    @TagAttribute
    protected Boolean         autoLoad;
    @TagAttribute
    protected Boolean         autoSync;
    @TagAttribute
    protected String          model;
    @TagAttribute
    protected String          storeId;
    
    public void setVarName(String varName)
    {
        this.varName = varName;
    }
    
    public void setAutoLoad(Boolean autoLoad)
    {
        this.autoLoad = autoLoad;
    }
    
    public void setAutoSync(Boolean autoSync)
    {
        this.autoSync = autoSync;
    }
    
    public void setModel(String model)
    {
        this.model = model;
    }
    
    public void setStoreId(String storeId)
    {
        this.storeId = storeId;
    }
    
}

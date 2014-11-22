package com.polaris.framework.webapp.view.ext.jsp.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.jsp.ComponentTag;

/**
 * 抽象的标签支持类
 * 
 * @author wang.sheng
 */
abstract class AbstractFieldTag extends ComponentTag
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected Integer         labelWidth;
    @TagAttribute
    protected Boolean         allowBlank;
    @TagAttribute
    protected String          blankText;
    @TagAttribute
    protected String          name;
    @TagAttribute
    protected String          fieldLabel;
    @TagAttribute
    protected Boolean         readOnly;
    @TagAttribute
    protected String          anchor;
    @TagAttribute
    protected String          labelSeparator;
    @TagAttribute
    protected Boolean         hideEmptyLabel;
    
    public void setBlankText(String blankText)
    {
        this.blankText = blankText;
    }
    
    public void setLabelWidth(Integer labelWidth)
    {
        this.labelWidth = labelWidth;
    }
    
    public void setAllowBlank(Boolean allowBlank)
    {
        this.allowBlank = allowBlank;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setFieldLabel(String fieldLabel)
    {
        this.fieldLabel = fieldLabel;
    }
    
    public void setReadOnly(Boolean readOnly)
    {
        this.readOnly = readOnly;
    }
    
    public void setAnchor(String anchor)
    {
        this.anchor = anchor;
    }
    
    public void setLabelSeparator(String labelSeparator)
    {
        this.labelSeparator = labelSeparator;
    }
    
    public void setHideEmptyLabel(Boolean hideEmptyLabel)
    {
        this.hideEmptyLabel = hideEmptyLabel;
    }
    
}

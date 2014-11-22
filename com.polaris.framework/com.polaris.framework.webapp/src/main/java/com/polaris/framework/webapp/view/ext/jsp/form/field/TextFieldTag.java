package com.polaris.framework.webapp.view.ext.jsp.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.form.field.ETextField;

/**
 * textfield标签
 * 
 * @author wang.sheng
 */
@TagLib(name = "textfield", component = ETextField.class)
public class TextFieldTag extends AbstractFieldTag
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected String          emptyText;
    @TagAttribute
    protected String          maskRe;
    @TagAttribute
    protected String          regex;
    @TagAttribute
    protected String          regexText;
    @TagAttribute
    protected Integer         maxLength;
    @TagAttribute
    protected Boolean         enforceMaxLength;
    @TagAttribute(description = "取值为password表示密码输入框")
    protected String          inputType;
    @TagAttribute
    protected Boolean         grow;
    
    public void setEmptyText(String emptyText)
    {
        this.emptyText = emptyText;
    }
    
    public void setMaskRe(String maskRe)
    {
        this.maskRe = maskRe;
    }
    
    public void setRegex(String regex)
    {
        this.regex = regex;
    }
    
    public void setRegexText(String regexText)
    {
        this.regexText = regexText;
    }
    
    public void setMaxLength(Integer maxLength)
    {
        this.maxLength = maxLength;
    }
    
    public void setEnforceMaxLength(Boolean enforceMaxLength)
    {
        this.enforceMaxLength = enforceMaxLength;
    }
    
    public void setInputType(String inputType)
    {
        this.inputType = inputType;
    }
    
    public void setGrow(Boolean grow)
    {
        this.grow = grow;
    }
    
}

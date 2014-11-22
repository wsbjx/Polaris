package com.polaris.framework.webapp.view.ext.api.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.EComponent;

@Ext(name = "Ext.form.HtmlEditor", type = VarType.CREATE)
public class EHtmlEditor extends EComponent implements EField
{
    @ExtField
    protected String  createLinkText;
    @ExtField
    protected String  defaultLinkValue;
    @ExtField
    protected String  defaultValue;
    @ExtField
    protected String  name;
    @ExtField
    protected String  fieldLabel;
    @ExtField
    protected Boolean enableAlignments;
    @ExtField
    protected Boolean enableColors;
    @ExtField
    protected Boolean enableFont;
    @ExtField
    protected Boolean enableFontSize;
    @ExtField
    protected Boolean enableFormat;
    @ExtField
    protected Boolean enableLinks;
    @ExtField
    protected Boolean enableLists;
    @ExtField
    protected Boolean enableSourceEdit;
    @ExtField
    protected Boolean fontFamilies;
    
    @TagAttribute
    public void setFieldLabel(String fieldLabel)
    {
        this.fieldLabel = fieldLabel;
    }
    
    @TagAttribute
    public void setName(String name)
    {
        this.name = name;
    }
    
    @TagAttribute
    public void setCreateLinkText(String createLinkText)
    {
        this.createLinkText = createLinkText;
    }
    
    @TagAttribute
    public void setDefaultLinkValue(String defaultLinkValue)
    {
        this.defaultLinkValue = defaultLinkValue;
    }
    
    @TagAttribute
    public void setDefaultValue(String defaultValue)
    {
        this.defaultValue = defaultValue;
    }
    
    @TagAttribute
    public void setEnableAlignments(Boolean enableAlignments)
    {
        this.enableAlignments = enableAlignments;
    }
    
    @TagAttribute
    public void setEnableColors(Boolean enableColors)
    {
        this.enableColors = enableColors;
    }
    
    @TagAttribute
    public void setEnableFont(Boolean enableFont)
    {
        this.enableFont = enableFont;
    }
    
    @TagAttribute
    public void setEnableFontSize(Boolean enableFontSize)
    {
        this.enableFontSize = enableFontSize;
    }
    
    @TagAttribute
    public void setEnableFormat(Boolean enableFormat)
    {
        this.enableFormat = enableFormat;
    }
    
    @TagAttribute
    public void setEnableLinks(Boolean enableLinks)
    {
        this.enableLinks = enableLinks;
    }
    
    @TagAttribute
    public void setEnableLists(Boolean enableLists)
    {
        this.enableLists = enableLists;
    }
    
    @TagAttribute
    public void setEnableSourceEdit(Boolean enableSourceEdit)
    {
        this.enableSourceEdit = enableSourceEdit;
    }
    
    @TagAttribute
    public void setFontFamilies(Boolean fontFamilies)
    {
        this.fontFamilies = fontFamilies;
    }
    
}

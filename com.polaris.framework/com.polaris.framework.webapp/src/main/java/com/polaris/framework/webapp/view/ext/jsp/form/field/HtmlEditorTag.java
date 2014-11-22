package com.polaris.framework.webapp.view.ext.jsp.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.form.field.EHtmlEditor;
import com.polaris.framework.webapp.view.ext.jsp.ComponentTag;

@TagLib(name = "htmleditor", component = EHtmlEditor.class)
public class HtmlEditorTag extends ComponentTag
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected String          createLinkText;
    @TagAttribute
    protected String          defaultLinkValue;
    @TagAttribute
    protected String          defaultValue;
    @TagAttribute
    protected Boolean         enableAlignments;
    @TagAttribute
    protected Boolean         enableColors;
    @TagAttribute
    protected Boolean         enableFont;
    @TagAttribute
    protected Boolean         enableFontSize;
    @TagAttribute
    protected Boolean         enableFormat;
    @TagAttribute
    protected Boolean         enableLinks;
    @TagAttribute
    protected Boolean         enableLists;
    @TagAttribute
    protected Boolean         enableSourceEdit;
    @TagAttribute
    protected Boolean         fontFamilies;
    @TagAttribute
    protected String          name;
    @TagAttribute
    protected String          fieldLabel;
    
    public void setFieldLabel(String fieldLabel)
    {
        this.fieldLabel = fieldLabel;
    }
    
    public void setCreateLinkText(String createLinkText)
    {
        this.createLinkText = createLinkText;
    }
    
    public void setDefaultLinkValue(String defaultLinkValue)
    {
        this.defaultLinkValue = defaultLinkValue;
    }
    
    public void setDefaultValue(String defaultValue)
    {
        this.defaultValue = defaultValue;
    }
    
    public void setEnableAlignments(Boolean enableAlignments)
    {
        this.enableAlignments = enableAlignments;
    }
    
    public void setEnableColors(Boolean enableColors)
    {
        this.enableColors = enableColors;
    }
    
    public void setEnableFont(Boolean enableFont)
    {
        this.enableFont = enableFont;
    }
    
    public void setEnableFontSize(Boolean enableFontSize)
    {
        this.enableFontSize = enableFontSize;
    }
    
    public void setEnableFormat(Boolean enableFormat)
    {
        this.enableFormat = enableFormat;
    }
    
    public void setEnableLinks(Boolean enableLinks)
    {
        this.enableLinks = enableLinks;
    }
    
    public void setEnableLists(Boolean enableLists)
    {
        this.enableLists = enableLists;
    }
    
    public void setEnableSourceEdit(Boolean enableSourceEdit)
    {
        this.enableSourceEdit = enableSourceEdit;
    }
    
    public void setFontFamilies(Boolean fontFamilies)
    {
        this.fontFamilies = fontFamilies;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
}

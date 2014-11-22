package com.polaris.framework.webapp.view.ext.jsp;

import com.polaris.framework.webapp.view.annotation.TagAttribute;

/**
 * 抽象的组件标签库
 * 
 * @author wang.sheng
 */
public abstract class ComponentTag extends ExtTagSupport
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected Boolean         autoScroll;
    @TagAttribute
    protected String          margin;
    @TagAttribute
    protected Boolean         disabled;
    @TagAttribute
    protected Boolean         hidden;
    @TagAttribute
    protected String          padding;
    @TagAttribute
    protected Integer         width;
    @TagAttribute
    protected Integer         height;
    @TagAttribute
    protected String          renderTo;
    @TagAttribute
    protected Object          data;
    @TagAttribute
    protected Object          value;
    @TagAttribute
    protected Integer         flex;
    @TagAttribute
    protected String          html;
    @TagAttribute
    protected Integer         minHeight;
    @TagAttribute
    protected Integer         minWidth;
    @TagAttribute
    protected Integer         maxHeight;
    @TagAttribute
    protected Integer         maxWidth;
    @TagAttribute
    protected Boolean         frame;
    @TagAttribute
    protected String          dock;
    
    public void setAutoScroll(Boolean autoScroll)
    {
        this.autoScroll = autoScroll;
    }
    
    public void setDock(String dock)
    {
        this.dock = dock;
    }
    
    public void setMinHeight(Integer minHeight)
    {
        this.minHeight = minHeight;
    }
    
    public void setMinWidth(Integer minWidth)
    {
        this.minWidth = minWidth;
    }
    
    public void setMaxHeight(Integer maxHeight)
    {
        this.maxHeight = maxHeight;
    }
    
    public void setMaxWidth(Integer maxWidth)
    {
        this.maxWidth = maxWidth;
    }
    
    public void setData(Object data)
    {
        this.data = data;
    }
    
    public void setMargin(String margin)
    {
        this.margin = margin;
    }
    
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }
    
    public void setHidden(Boolean hidden)
    {
        this.hidden = hidden;
    }
    
    public void setPadding(String padding)
    {
        this.padding = padding;
    }
    
    public void setWidth(Integer width)
    {
        this.width = width;
    }
    
    public void setHeight(Integer height)
    {
        this.height = height;
    }
    
    public void setRenderTo(String renderTo)
    {
        this.renderTo = renderTo;
    }
    
    public void setValue(Object value)
    {
        this.value = value;
    }
    
    public void setFlex(Integer flex)
    {
        this.flex = flex;
    }
    
    public void setHtml(String html)
    {
        this.html = html;
    }
    
    public void setFrame(Boolean frame)
    {
        this.frame = frame;
    }
    
}

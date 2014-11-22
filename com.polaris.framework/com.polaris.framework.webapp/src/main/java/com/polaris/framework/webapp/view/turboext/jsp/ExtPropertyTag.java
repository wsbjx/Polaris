package com.polaris.framework.webapp.view.turboext.jsp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;

/**
 * property标签,为父标签设置具体属性
 * 
 * @author wang.sheng
 */
@TagLib(name = "property")
public class ExtPropertyTag extends BodyTagSupport
{
    private static final long serialVersionUID = 1L;
    Log                       log              = LogFactory.getLog(getClass());
    @TagAttribute
    private String            name;
    @TagAttribute
    private String            value;
    
    @Override
    public int doStartTag() throws JspException
    {
        Tag parent = super.getParent();
        if(parent == null)
        {
            // 没有父标签
            log.warn("parent tag not found!");
            return Tag.SKIP_BODY;
        }
        return BodyTag.EVAL_BODY_BUFFERED;
    }
    
    @Override
    public int doEndTag() throws JspException
    {
        String content = null;
        if(value == null || value.length() < 1)
        {
            content = super.getBodyContent().getString();
        }
        else
        {
            content = value;
        }
        Tag parent = super.getParent();
        try
        {
            BeanUtils.setProperty(parent, name, content);
        }
        catch(Exception e)
        {
            // TODO Auto-generated catch block
            log.warn("setProperty failed! object=" + parent + ",property=" + name + ",value=" + content, e);
        }
        return Tag.EVAL_PAGE;
    }
    
    public void setValue(String value)
    {
        this.value = value;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
}

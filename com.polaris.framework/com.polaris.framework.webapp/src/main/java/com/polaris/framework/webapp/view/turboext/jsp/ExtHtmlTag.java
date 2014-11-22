package com.polaris.framework.webapp.view.turboext.jsp;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.polaris.framework.webapp.view.annotation.TagLib;

/**
 * html标签
 * 
 * @author wang.sheng
 */
@TagLib(name = "html")
public class ExtHtmlTag extends BodyTagSupport
{
    private static final long serialVersionUID = 1L;
    Log                       log              = LogFactory.getLog(getClass());
    
    @Override
    public int doStartTag() throws JspException
    {
        JspWriter out = super.pageContext.getOut();
        try
        {
            out.println("<html>");
        }
        catch(IOException e)
        {
            // TODO Auto-generated catch block
            log.warn("JspWriter exception!", e);
        }
        return Tag.EVAL_BODY_INCLUDE;
    }
    
    @Override
    public int doEndTag()
    {
        JspWriter out = super.pageContext.getOut();
        try
        {
            out.println("</html>");
        }
        catch(IOException e)
        {
            // TODO Auto-generated catch block
            log.warn("JspWriter exception!", e);
        }
        return Tag.EVAL_PAGE;
    }
}

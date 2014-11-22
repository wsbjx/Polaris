package com.polaris.framework.webapp.view.turboext.jsp;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.polaris.framework.webapp.common.utils.WebUtils;
import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;


/**
 * 在界面上生成URL地址
 * 
 * @author wang.sheng
 */
@TagLib(name = "url", bodyContent = "empty")
public class UrlTag extends BodyTagSupport
{
    private static final long serialVersionUID = 1L;
    Log                       log              = LogFactory.getLog(getClass());
    @TagAttribute(required = true)
    protected String          url;
    
    public void setUrl(String url)
    {
        this.url = url;
    }
    
    @Override
    public int doEndTag()
    {
        JspWriter out = super.pageContext.getOut();
        try
        {
            out.print(WebUtils.toRealURL(url, super.pageContext.getServletContext()));
        }
        catch(IOException e)
        {
            // TODO Auto-generated catch block
            log.warn("JspWriter exception!", e);
        }
        return Tag.EVAL_PAGE;
    }
}

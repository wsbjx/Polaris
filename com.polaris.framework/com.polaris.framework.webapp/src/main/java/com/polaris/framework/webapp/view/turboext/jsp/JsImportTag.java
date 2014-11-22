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

@TagLib(name = "importjs", bodyContent = "empty")
public class JsImportTag extends BodyTagSupport
{
	private static final long serialVersionUID = 1L;
	Log log = LogFactory.getLog(getClass());
	@TagAttribute(required = true)
	protected String src;

	public void setSrc(String src)
	{
		this.src = src;
	}

	@Override
	public int doEndTag()
	{
		JspWriter out = super.pageContext.getOut();
		try
		{
			out.println("<script type=\"text/javascript\" src=\"" + WebUtils.toRealURL(src, super.pageContext.getServletContext())
					+ "\"></script>");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			log.warn("JspWriter exception!", e);
		}
		return Tag.EVAL_PAGE;
	}
}

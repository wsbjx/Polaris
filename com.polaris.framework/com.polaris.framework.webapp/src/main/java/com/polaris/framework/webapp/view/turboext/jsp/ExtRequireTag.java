package com.polaris.framework.webapp.view.turboext.jsp;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;

@TagLib(name = "require", bodyContent = "empty")
public class ExtRequireTag extends BodyTagSupport
{
	private static final long serialVersionUID = 1L;
	Log log = LogFactory.getLog(getClass());
	@TagAttribute(required = true)
	protected String name;

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int doEndTag()
	{
		JspWriter out = super.pageContext.getOut();
		try
		{
			String[] strs = name.split(",");
			out.println("Ext.require([");
			for (int i = 0; i < strs.length; i++)
			{
				if (i > 0)
				{
					out.print(",");
				}
				out.println("'" + strs[i] + "'");
			}
			out.println("]);");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			log.warn("JspWriter exception!", e);
		}
		return Tag.EVAL_PAGE;
	}

}

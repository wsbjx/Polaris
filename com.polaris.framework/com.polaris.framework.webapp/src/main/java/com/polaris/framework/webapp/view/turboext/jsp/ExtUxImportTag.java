package com.polaris.framework.webapp.view.turboext.jsp;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;

/**
 * 导入EXT扩展资源
 * 
 * @author wang.sheng
 */
@TagLib(name = "importux", bodyContent = "empty")
public class ExtUxImportTag extends BodyTagSupport
{
	private static final long serialVersionUID = 1L;
	private final static String CONTAINS_IMPORT_FLAG = "_CONTAINS_IMPORT_FLAG";
	Log log = LogFactory.getLog(getClass());
	@TagAttribute(required = true)
	protected String name;
	@TagAttribute(required = true)
	protected String path;

	public void setName(String name)
	{
		this.name = name;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	@Override
	public int doEndTag()
	{
		JspWriter out = super.pageContext.getOut();
		ServletRequest request = super.pageContext.getRequest();
		try
		{
			if (request.getAttribute(CONTAINS_IMPORT_FLAG) == null)
			{
				// 看看是否是第一次进行引入操作
				request.setAttribute(CONTAINS_IMPORT_FLAG, true);
				out.println("Ext.Loader.setConfig({enabled: true});");
			}
			String[] strs = path.trim().split("\\.");
			StringBuffer buffer = new StringBuffer();
			buffer.append(request.getServletContext().getContextPath()).append("/resource");
			for (String str : strs)
			{
				buffer.append("/").append(str);
			}
			buffer.append("/");
			out.println("Ext.Loader.setPath('" + name + "', '" + buffer + "');");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			log.warn("JspWriter exception!", e);
		}
		return Tag.EVAL_PAGE;
	}
}

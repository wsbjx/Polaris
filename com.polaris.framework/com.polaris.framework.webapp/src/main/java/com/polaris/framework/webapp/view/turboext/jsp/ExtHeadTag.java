package com.polaris.framework.webapp.view.turboext.jsp;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.polaris.framework.webapp.common.utils.WebUtils;
import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;

/**
 * 标签<head/>的解析
 * 
 * @author wang.sheng
 */
@TagLib(name = "head")
public class ExtHeadTag extends BodyTagSupport
{
	private static final long serialVersionUID = 1L;
	Log log = LogFactory.getLog(getClass());
	@TagAttribute
	private String version;
	@TagAttribute
	private String title = "web page";

	/**
	 * 使用的extjs的版本
	 * 
	 * @param version
	 */
	public void setVersion(String version)
	{
		this.version = version;
	}

	/**
	 * 页面标题
	 * 
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	@Override
	public int doStartTag() throws JspException
	{
		JspWriter out = super.pageContext.getOut();
		try
		{
			out.println("<head>");
			out.println("<!-- PRODUCED BY W.S. -->");
			out.println("<title>" + WebUtils.escapeXml(title) + "</title>");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			log.warn("JspWriter Exception!", e);
		}
		if (version == null || version.length() < 1)
		{
			version = WebUtils.getDefaultExtVersion(super.pageContext.getServletContext());
		}
		@SuppressWarnings("unchecked")
		Map<String, String[]> headJsMap = WebUtils.getApplicationContext(super.pageContext.getServletContext()).getBean("headJsMap",
				Map.class);
		String[] array = headJsMap.get(version);
		String contextPath = super.pageContext.getServletContext().getContextPath();
		if (array != null && array.length > 0)
		{
			try
			{
				for (String item : array)
				{
					if (!item.startsWith("/"))
					{
						item = "/" + item;
					}
					item = contextPath + "/resource" + item;
					if (item.endsWith(".js"))
					{
						// JS脚本
						out.println("<script type=\"text/javascript\" src=\"" + item + "\"></script>");
					}
					else if (item.endsWith(".css"))
					{
						// CSS脚本
						out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + item + "\" />");
					}
					else
					{
						// 尚未识别的
						log.warn("unknown item:" + item);
					}
				}
			}
			catch (Exception ex)
			{
				log.warn("JspWriter Exception!", ex);
			}
		}
		return Tag.EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag()
	{
		JspWriter out = super.pageContext.getOut();
		try
		{
			out.println("</head>");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			log.warn("JspWriter exception!", e);
		}
		return Tag.EVAL_PAGE;
	}
}

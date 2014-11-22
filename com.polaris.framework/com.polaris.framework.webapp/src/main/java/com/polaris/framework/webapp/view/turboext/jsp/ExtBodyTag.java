package com.polaris.framework.webapp.view.turboext.jsp;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.EModule;
import com.polaris.framework.webapp.view.extjs.api.ERootBody;
import com.polaris.framework.webapp.view.extjs.jsp.ComponentSupport;
import com.polaris.framework.webapp.view.extjs.utils.ExtAnnotationUtils;

/**
 * 在页面上生成ext.onready语句以及<script>标记
 * 
 * @author wang.sheng
 */
@TagLib(name = "body")
public class ExtBodyTag extends BodyTagSupport implements ComponentSupport
{
	private static final long serialVersionUID = 1L;
	Log log = LogFactory.getLog(getClass());
	private ERootBody rootBody;

	@Override
	public final int doStartTag() throws JspException
	{
		rootBody = new ERootBody();
		JspWriter out = super.pageContext.getOut();
		try
		{
			out.println("<body>");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			log.warn("JspWriter exception!", e);
		}
		return BodyTag.EVAL_BODY_BUFFERED;
	}

	@Override
	public final int doEndTag()
	{
		JspWriter out = super.pageContext.getOut();
		try
		{
			out.println("<script language=\"javascript\">");
			for (Object child : rootBody.getChildren())
			{
				if (child instanceof EModule)
				{
					String varName = ((EModule) child).getVarName();
					if (varName != null && varName.length() > 0)
					{
						out.println("var " + varName + ";");
					}
				}
			}
			out.println("Ext.require(['*']);");
			out.println("Ext.onReady(function() {");
			out.println("   Ext.QuickTips.init();");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			log.warn("JspWriter exception!", e);
		}
		for (Object child : rootBody.getChildren())
		{
			try
			{
				ExtAnnotationUtils.writeJavaScript(child, out, true);
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				log.warn("writeJavaScript failed! object:" + child, e);
			}
		}
		try
		{
			out.println("});");
			out.println("</script>");
			out.println("</body>");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			log.warn("JspWriter exception!", e);
		}
		return Tag.EVAL_PAGE;
	}

	@Override
	public Object getComponent()
	{
		// TODO Auto-generated method stub
		return rootBody;
	}
}
